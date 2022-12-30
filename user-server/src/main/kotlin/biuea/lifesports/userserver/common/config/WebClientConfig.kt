package biuea.lifesports.userserver.common.config

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import reactor.netty.resources.ConnectionProvider
import java.time.Duration
import java.util.concurrent.TimeUnit

@Configuration
class WebClientConfig {
    @Bean
    fun webClient(): WebClient {
        val provider = ConnectionProvider.builder("client")
            .maxConnections(100)
            .maxIdleTime(Duration.ofSeconds(4))
            .maxLifeTime(Duration.ofSeconds(4))
            .pendingAcquireTimeout(Duration.ofSeconds(5))
            .pendingAcquireMaxCount(-1)
            .evictInBackground(Duration.ofSeconds(30))
            .lifo()
            .metrics(true)
            .build()

        val httpClient = HttpClient.create(provider)
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 4000)
            .responseTimeout(Duration.ofMillis(4000))
            .doOnConnected { conn ->
                conn.addHandlerLast(ReadTimeoutHandler(4000, TimeUnit.MILLISECONDS))
                    .addHandlerLast(WriteTimeoutHandler(4000, TimeUnit.MILLISECONDS))
            }

        val webClient = WebClient.builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .build()

        httpClient.warmup().block()

        return webClient
    }
}