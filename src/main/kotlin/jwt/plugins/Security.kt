package jwt.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import jwt.security.hashing.SHA256HashingServiceImpl
import jwt.security.token.JwtTokenService
import jwt.security.token.TokenConfig

fun Application.configureSecurity() {

    val tokenConfig = TokenConfig(
        issuer = environment.config.property("jwt.issuer").getString(),
        audience = environment.config.property("jwt.audience").getString(),
        expiresIn = 365L * 1000L * 60L * 60L * 24L,
        secret = System.getenv("JWT_SECRET")
    )

    authentication {
        jwt {
            realm = this@configureSecurity.environment.config.property("jwt.realm").getString()
            verifier(
                JWT
                    .require(Algorithm.HMAC256(tokenConfig.secret))
                    .withAudience(tokenConfig.audience)
                    .withIssuer(tokenConfig.issuer)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(tokenConfig.audience)) JWTPrincipal(credential.payload) else null
            }
        }
    }
}
    