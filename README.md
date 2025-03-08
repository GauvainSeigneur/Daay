This is a Kotlin Multiplatform project targeting Android, iOS.

Architecture
The project architecture is based on Clean Architecture, with a clear separation of concerns:

Five-Layer Architecture: See details.

BFF API Design: See details.
Key Technical Choices
Kotlin Multiplatform: Learn more.
JetBrains Compose: Used for building UIs.
Koin: For dependency injection
Ktor: For networking.



* `/composeApp` Package to init and display app:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

