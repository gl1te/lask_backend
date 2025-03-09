package jwt.data.user

data class UserDTO(
    val id: Long,
    val username: String,
    val email: String,
    val password: String,
    val salt: String
)
