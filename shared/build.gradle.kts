import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnLockMismatchReport
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

plugins {
    alias(libs.plugins.kotlinMultiplatform)

}

kotlin {
    jvm()
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation(libs.decompose.decompose)
            implementation(libs.decompose.extensions.compose.experimental)
            implementation(libs.essenty.lifecycle)
            implementation(libs.ktor.client)
            implementation(libs.kotlinx.rpc.client)
            implementation(libs.kotlinx.serialization.json)


        }
        wasmJsMain.dependencies {
          //   implementation(npm(libs.versions.web.jodaTimezone.toString()))
        }
    }
}



        rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin::class.java) {
            rootProject.the<YarnRootExtension>().yarnLockMismatchReport =
                YarnLockMismatchReport.WARNING // NONE | FAIL
            rootProject.the<YarnRootExtension>().reportNewYarnLock = false // true
            rootProject.the<YarnRootExtension>().yarnLockAutoReplace = false // true
        }

