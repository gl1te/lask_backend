package jwt.features.login

import io.ktor.server.application.*
import io.ktor.server.routing.*
import jwt.security.hashing.SHA256HashingServiceImpl
import jwt.security.token.JwtTokenService
import jwt.security.token.TokenConfig

fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            val tokenConfig = TokenConfig(
                issuer = environment.config.property("jwt.issuer").getString(),
                audience = environment.config.property("jwt.audience").getString(),
                expiresIn = 365L * 1000L * 60L * 60L * 24L,
                secret = System.getenv("JWT_SECRET")
            )

            val tokenService = JwtTokenService()
            val hashingService = SHA256HashingServiceImpl()
            val loginController = LoginController(call, hashingService, tokenService, tokenConfig)
            loginController.performLogin()
        }
    }
}