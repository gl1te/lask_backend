package jwt.features.authenticate

import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.* 

fun Route.configureAuthenticateRouting() {
    authenticate {
        get("/authenticate") {
            call.respond(HttpStatusCode.OK)
        }
    }
}

