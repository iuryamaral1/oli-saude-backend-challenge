package com.oli.saude

import org.flywaydb.core.Flyway
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
/*
* When Spring starts a single instance of the context for all tests.
* When testcontainers recreate the container, the context is not recreated.
* So, we need to add this dirties context to activate the dynamic properties again.
*/
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
abstract class TestIntegration : AfterAllCallback, BeforeAllCallback {

    companion object {
        const val POSTGRES_IMAGE = "postgres:13.2-alpine"

        @Container
        private val postgresContainer = PostgreSQLContainer(POSTGRES_IMAGE).apply {
            withDatabaseName("oli-saude")
            withUsername("oli-saude")
            withPassword("oli-saude")
            withReuse(true)
        }

        @JvmStatic
        @DynamicPropertySource
        fun configureProperties(registry: DynamicPropertyRegistry) {
            if (postgresContainer.isRunning) {
                registry.add("spring.datasource.url", postgresContainer::getJdbcUrl)
                registry.add("spring.datasource.username", postgresContainer::getUsername)
                registry.add("spring.datasource.password", postgresContainer::getPassword)
            }
        }
    }

    override fun beforeAll(context: ExtensionContext?) {
        if (!postgresContainer.isRunning) {
            postgresContainer.start()
            migrateDatabase()
        }
    }

    override fun afterAll(context: ExtensionContext?) {
        if (postgresContainer.isRunning) {
            postgresContainer.stop()
        }
    }

    private fun migrateDatabase() {
        Flyway.configure()
            .dataSource(
                postgresContainer.jdbcUrl,
                postgresContainer.username,
                postgresContainer.password
            )
            .locations("classpath:db/migration")
            .load()
            .migrate()
    }
}