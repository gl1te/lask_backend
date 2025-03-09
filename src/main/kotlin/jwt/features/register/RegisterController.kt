package jwt.features.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import jwt.data.user.UserDTO
import jwt.data.user.Users
import jwt.security.hashing.HashingService
import org.jetbrains.exposed.exceptions.ExposedSQLException

class RegisterController(
    private val call: ApplicationCall,
    private val hashingService: HashingService
) {
    suspend fun registerNewUser() {
        val registerReceiveRemote = call.receive<RegisterReceiveRemote>()

        val areFieldsBlank =
            registerReceiveRemote.username.isBlank() || registerReceiveRemote.password.isBlank() || registerReceiveRemote.email.isBlank()
        val isPasswordTooShort = registerReceiveRemote.password.length < 6

        if (areFieldsBlank || isPasswordTooShort) {
            call.respond(HttpStatusCode.Conflict)
        }

        val saltedHash = hashingService.generateSaltedHash(registerReceiveRemote.password)

        val userDTO = Users.fetchUser(username = registerReceiveRemote.username)
        if (userDTO != null) {
            call.respond(HttpStatusCode.Conflict, "User already exist")
        } else {

            try {
                Users.insert(
                    UserDTO(
                        id = 0,
                        username = registerReceiveRemote.username,
                        password = saltedHash.hash,
                        salt = saltedHash.salt,
                        email = registerReceiveRemote.email
                    )
                )
            } catch (e: ExposedSQLException) {
                call.respond(HttpStatusCode.Conflict, "User already exist")
            }
        }

        call.respond(HttpStatusCode.OK)
    }

}
