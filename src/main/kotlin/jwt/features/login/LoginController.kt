package jwt.features.login

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import jwt.data.user.Users
import jwt.security.hashing.HashingService
import jwt.security.hashing.SaltedHash
import jwt.security.token.JwtTokenService
import jwt.security.token.TokenClaim
import jwt.security.token.TokenConfig

class LoginController(
    private val call: ApplicationCall,
    private val hashingService: HashingService,
    private val tokenService: JwtTokenService,
    private val tokenConfig: TokenConfig
) {

    suspend fun performLogin() {
        val receive = call.receive<LoginReceiveRemote>()
        val userDTO = Users.fetchUser(username = receive.username)

        if (userDTO == null) {
            call.respond(HttpStatusCode.BadRequest, "User not found")
        } else {
            val isValidPassword = hashingService.verify(
                value = receive.password,
                saltedHash = SaltedHash(
                    hash = userDTO.password,
                    salt = userDTO.salt
                )
            )
            if (!isValidPassword) {
                call.respond(HttpStatusCode.BadRequest, "Password is not valid")
            }

            val token = tokenService.generate(
                config = tokenConfig,
                TokenClaim(
                    name = "userId",
                    value = userDTO.id.toString()
                )
            )

            call.respond(
                HttpStatusCode.OK, LoginResponseRemote(
                    token = token
                )
            )

        }


    }

}