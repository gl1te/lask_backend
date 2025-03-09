package jwt.plugins

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    val postgresqlUrl = System.getenv("POSTGRESQL_URL")
    val postgresqlDriver = System.getenv("POSTGRESQL_DRIVER")
    val postgresqlUsername = System.getenv("POSTGRESQL_USERNAME")
    val postgresqlPassword = System.getenv("POSTGRESQL_PASSWORD")

    Database.connect(
        url = postgresqlUrl,
        driver = postgresqlDriver,
        user = postgresqlUsername,
        password = postgresqlPassword
    )

}