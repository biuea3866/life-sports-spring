package biuea.lifesports.authzserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthzServerApplication

fun main(args: Array<String>) {
    runApplication<AuthzServerApplication>(*args)
}
