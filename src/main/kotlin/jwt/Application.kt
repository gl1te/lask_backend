package jwt

import com.configureSerialization
import io.ktor.server.application.*
import jwt.features.authenticate.configureAuthenticateRouting
import jwt.features.login.configureLoginRouting
import jwt.features.register.configureRegisterRouting
import jwt.features.secretInfo.configureSecretInfoRouting
import jwt.plugins.configureDatabase
import jwt.plugins.configureMonitoring
import jwt.plugins.configureRouting
import jwt.plugins.configureSecurity

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    configureLoginRouting()
    configureRegisterRouting()
    configureDatabase()
    configureSerialization()
    configureMonitoring()
    configureSecurity()
    configureRouting()
}
