package jwt.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jwt.features.authenticate.configureAuthenticateRouting
import jwt.features.secretInfo.configureSecretInfoRouting

fun Application.configureRouting() {
    routing {
        configureAuthenticateRouting()
        configureSecretInfoRouting()
    }
}
