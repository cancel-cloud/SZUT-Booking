package de.szut.booking

import de.szut.booking.plugins.configureRouting
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.sessions.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import de.szut.plugins.*

class ApplicationTest {
	@Test
	fun testRoot() = testApplication {
		application {
			configureRouting()
		}
		client.get("/").apply {
			assertEquals(HttpStatusCode.OK, status)
			assertEquals("Hello World!", bodyAsText())
		}
	}
}