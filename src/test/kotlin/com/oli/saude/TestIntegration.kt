package com.oli.saude

import org.flywaydb.core.Flyway
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
abstract class TestIntegration : AfterEachCallback, BeforeEachCallback {

    companion object {
        const val POSTGRES_IMAGE = "postgres:13.2-alpine"

        @Container
        private val postgresContainer = PostgreSQLContainer(POSTGRES_IMAGE).apply {
            withDatabaseName("oli-saude")
            withUsername("oli-saude")
            withPassword("oli-saude")
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

    override fun beforeEach(context: ExtensionContext?) {
        if (!postgresContainer.isRunning) {
            postgresContainer.start()
            migrateDatabase()
        }
    }

    override fun afterEach(context: ExtensionContext?) {
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