package jwt.features.register

import io.ktor.server.application.*
import io.ktor.server.routing.*
import jwt.security.hashing.HashingService
import jwt.security.hashing.SHA256HashingServiceImpl

fun Application.configureRegisterRouting(){
    routing {
        post("/register") {
            val hashingService = SHA256HashingServiceImpl()
            val registerController = RegisterController(call, hashingService)
            registerController.registerNewUser()
        }
    }
}