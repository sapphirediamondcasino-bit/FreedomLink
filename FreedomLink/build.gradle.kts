import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.ajoberstar.grgit.Grgit
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.dokka") version "1.8.20" apply false
    id("com.gorylenko.gradle-git-properties") version "2.4.1"
    id("org.ajoberstar.grgit") version "5.2.0"
    id("org.springframework.boot") version "3.1.0" apply false
    id("org.sonarqube") version "4.2.0.3129"
    id("com.adarshr.test-logger") version "3.2.0"
    id("org.jetbrains.kotlin.jvm") version "2.1.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.1.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.20" apply false
    alias(libs.plugins.maven.publish.base) apply false
}

val (gitVersion, release) = versionFromGit()
logger.lifecycle("Version: $gitVersion (release: $release)")

allprojects {
    group = "dev.freedomlink"
    version = gitVersion

    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://m2.dv8tion.net/releases")
        maven("https://jitpack.io")
    }
}

subprojects {
    if (project.hasProperty("includeAnalysis")) {
        project.logger.lifecycle("applying analysis plugins")
        apply(from = "../analysis.gradle")
    }

    tasks.withType<KotlinCompile> {
        compilerOptions.jvmTarget = JvmTarget.JVM_17
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-Xlint:unchecked")
        options.compilerArgs.add("-Xlint:deprecation")
    }

    afterEvaluate {
        if (project.plugins.hasPlugin("com.vanniktech.maven.publish.base")) {
            if (release) {
                configure<MavenPublishBaseExtension> {
                    coordinates(group.toString(), project.the<BasePluginExtension>().archivesName.get(), version.toString())
                    val mavenCentralUsername = findProperty("mavenCentralUsername") as String?
                    val mavenCentralPassword = findProperty("mavenCentralPassword") as String?
                    if (!mavenCentralUsername.isNullOrEmpty() && !mavenCentralPassword.isNullOrEmpty()) {
                        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, false)
                        signAllPublications()
                    } else {
                        logger.lifecycle("Not publishing to Maven Central - no credentials")
                    }

                    pom {
                        url = "https://github.com/sapphirediamondcasino-bit/FreedomLink"
                        licenses {
                            license {
                                name = "MIT License"
                                url = "https://github.com/sapphirediamondcasino-bit/FreedomLink/blob/main/LICENSE"
                            }
                        }
                        developers {
                            developer {
                                id = "directorjake"
                                name = "Tanner Kurrasch"
                                url = "https://www.kurraschgamingmerchstore.com"
                            }
                        }
                        scm {
                            url = "https://github.com/sapphirediamondcasino-bit/FreedomLink"
                            connection = "scm:git:git://github.com/sapphirediamondcasino-bit/FreedomLink.git"
                            developerConnection = "scm:git:ssh://git@github.com/sapphirediamondcasino-bit/FreedomLink.git"
                        }
                    }
                }
            }
        }
    }
}

@SuppressWarnings("GrMethodMayBeStatic")
fun versionFromGit(): Pair<String, Boolean> {
    Grgit.open(mapOf("currentDir" to project.rootDir)).use { git ->
        val headTag = git.tag
            .list()
            .find { it.commit.id == git.head().id }

        val clean = git.status().isClean || System.getenv("CI") != null
        if (!clean) {
            logger.lifecycle("Git state is dirty, version is a snapshot.")
        }

        return if (headTag != null && clean) headTag.name to true else "${git.head().id}-SNAPSHOT" to false
    }
}