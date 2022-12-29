package biuea.lifesports.discoverymanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class DiscoveryManagementApplication

fun main(args: Array<String>) {
    runApplication<DiscoveryManagementApplication>(*args)
}
