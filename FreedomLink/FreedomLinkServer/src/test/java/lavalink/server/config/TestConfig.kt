package FreedomLink.server.config

import FreedomLink.server.bootstrap.PluginManager
import FreedomLink.server.bootstrap.PluginsConfig
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TestConfig {

    @Bean
    fun pluginManager() = PluginManager(PluginsConfig())

}