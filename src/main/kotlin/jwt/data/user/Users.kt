package jwt.data.user

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Users : Table() {
    private val id = long("user_id").autoIncrement()
    private val username = varchar("username", 50)
    private val email = varchar("user_email", 50)
    private val password = varchar("user_password", 100)
    private val salt = varchar("user_salt", 100)

    override val primaryKey = PrimaryKey(id)

    fun insert(userDTO: UserDTO) {
        transaction {
            Users.insert {
                it[username] = userDTO.username
                it[password] = userDTO.password
                it[email] = userDTO.email
                it[salt] = userDTO.salt
            }[Users.id]
        }
    }

    fun fetchUser(username: String): UserDTO? {
        return try {
            transaction {
                val userModel = Users.select {
                    Users.username.eq(username)
                }.single()
                UserDTO(
                    id = userModel[Users.id],
                    username = userModel[Users.username],
                    password = userModel[password],
                    salt = userModel[salt],
                    email = userModel[email]
                )
            }
        } catch (e: Exception) {
            null
        }
    }

    fun updateUser(username: String, userDTO: UserDTO) {
        transaction {
            Users.update({ Users.username eq username }) {
                UserDTO(
                    id = userDTO.id,
                    username = userDTO.username,
                    password = userDTO.password,
                    salt = userDTO.salt,
                    email = userDTO.email
                )
            }

        }
    }

    fun deleteUser(id: Long) {
        transaction {
            Users.deleteWhere { Users.id.eq(id) }
        }
    }

}
