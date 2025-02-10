Practice Multiplatform Application targeting Web, Desktop & Server.

**Components**

* Kotlin Wasm: The front end target format for targetting the browser
* Compose Multiplatform: Cross Platform Declarative UI framework (JVM Desktop and Wasm Browser target)
* Ktor 3.0: JVM Server and Wasm Client
* Kotlinx.RPC: Communication mechanism between client, server and 3rd party API's
* Decompose: Component lifecycle and Navigation framework
* Kotlin-Exposed: Dataframe API that will leverage mySQL



# **_Folder Structure_**

* `/composeApp` is the UI folder that will be shared across the Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    

* `/server` is the Backend folder for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. 


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…


sample the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.