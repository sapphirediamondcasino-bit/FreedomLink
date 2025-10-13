package FreedomLink.server.bootstrap

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "FreedomLink")
@Component
class PluginsConfig {
    var plugins: List<PluginDeclaration> = emptyList()
    var pluginsDir: String = "./plugins"
    var defaultPluginRepository: String = "https://maven.FreedomLink.dev/releases"
    var defaultPluginSnapshotRepository: String = "https://maven.FreedomLink.dev/snapshots"
}

data class PluginDeclaration(
    var dependency: String? = null,
    var repository: String? = null,
    var snapshot: Boolean = false
)