package com.oli.saude.gateways

import com.oli.saude.TestIntegration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@AutoConfigureMockMvc
class ClientControllerTest : TestIntegration() {

    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun `Should create a new client successfully`() {

        val requestBody = """
            {
               "name": "John Doe",
               "sex": "M",
               "birthDate": "2000-01-01"
            }
        """.trimIndent()

        mockMvc?.post("/v1/clients") {
            contentType = MediaType.APPLICATION_JSON
            content = requestBody
        }?.andExpect {
            status { isCreated() }
            jsonPath("$.id") { isNotEmpty() }
            jsonPath("$.name") { value("John Doe") }
            jsonPath("$.birthDate") { value ("01/01/2000") }
            jsonPath("$.createdAt") { isNotEmpty() }
            jsonPath("$.updatedAt") { isNotEmpty() }
        }?.andReturn()
    }

    @Test
    fun `Should return bad request when it cannot save a new client with a greater name than 255 characters`() {

        val clientRequestBody = """
            {
               "name": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque suscipit fermentum felis. Morbi ac condimentum tortor. Nulla ac congue neque. Cras ultricies efficitur mattis. Etiam dapibus dui odio, nec feugiat nibh ultrices vel. Integer quis sem tincidunt, porta dui id, dignissim justo. Suspendisse sit amet ex libero. Praesent interdum felis vitae nisl rhoncus laoreet. Mauris vel bibendum nisl. Duis laoreet nec leo vitae pretium. Praesent massa risus, feugiat sit amet pellentesque vitae, pretium non mi. In hac habitasse platea dictumst. Nullam et dictum quam. Proin hendrerit, odio et posuere malesuada, arcu velit aliquet nisi, eu suscipit nisl arcu non nisl. Nunc sed tincidunt tortor. Integer porta leo in magna ullamcorper porttitor. Nam eget lacus mollis ligula mattis fermentum. Sed leo nunc, cursus vitae laoreet eget, dapibus ac ipsum. Donec tincidunt metus ex, sit amet lacinia lacus pulvinar eget. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas maximus porta turpis, sed ullamcorper libero. In nec erat eu dolor ullamcorper luctus.",
               "sex": "F",
               "birthDate": "2010-01-01" 
            }
        """.trimIndent()

        mockMvc?.post("/v1/clients") {
            contentType = MediaType.APPLICATION_JSON
            content = clientRequestBody
        }?.andExpect {
            status { isBadRequest() }
            jsonPath("$.message") { value("name must be between 3 and 255 characters") }
            jsonPath("$.timestamp") { isNotEmpty() }
        }?.andReturn()
    }

    @Test
    fun `Should throw error when trying to save a date in the future`() {

        val clientRequestBody = """
            {
               "name": "John Travolta",
               "sex": "M",
               "birthDate": "2150-01-01"
            }
        """.trimIndent()

        mockMvc?.post("/v1/clients") {
            contentType = MediaType.APPLICATION_JSON
            content = clientRequestBody
        }?.andExpect {
            status { isBadRequest() }
            jsonPath("$.message") { value("Birth date must be a past or present date") }
            jsonPath("$.timestamp") { isNotEmpty() }
        }?.andReturn()
    }
}