# Okwu Asụ̀sụ̄ Igbo Dictionary

The Okwu Asụ̀sụ̄ Igbo Dictionary App is a language learning application that allows users to explore and understand the Igbo language. This app utilizes the [Igbo API](https://github.com/nkowaokwu/igbo_api) to provide accurate and up-to-date information about Igbo words and their meanings. The app follows a clean architecture approach, ensuring modularity and maintainability. It also incorporates caching to enhance user experience.

## Screeshots
![20230821_184526](https://github.com/GreatGrant/Okwu-Asusu-Igbo-Dictionary/assets/62026220/8e338491-b00b-4117-8edc-898bc74e8541=250x)

## Features

- Search and retrieve meanings of Igbo words using the Igbo API.
- Clean architecture design to separate concerns and improve code maintainability.
- Caching mechanism to store previously searched words for offline access.
- User-friendly interface built with Jetpack Compose, providing a modern and engaging user experience.
- Integration with Dagger Hilt for dependency injection to manage and provide app-wide components.
- Utilizes Retrofit for efficient network communication with the Igbo API.
- Implements Room database for local caching and storage of word meanings.
- Integration with Coroutines for asynchronous programming and lifecycle-aware operations.

## Dependencies

- [AndroidX Core KTX](https://developer.android.com/jetpack/androidx/releases/core) - Core utility libraries for Android.
- [AppCompat](https://developer.android.com/jetpack/androidx/releases/appcompat) - Support library for compatibility across different Android versions.
- [Material Design](https://material.io/develop/android/docs/getting-started) - Implement Google's Material Design guidelines in the app.
- [Lifecycle Runtime KTX](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Android architecture components for handling lifecycle events.
- [Activity Compose](https://developer.android.com/jetpack/androidx/releases/activity) - AndroidX library for creating activities using Jetpack Compose.
- [JUnit](https://junit.org/junit4/) - Testing framework for unit testing Java code.
- [Espresso](https://developer.android.com/training/testing/espresso) - Android testing framework for UI testing.
- [Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose UI toolkit for building native UIs.
- [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library for asynchronous and concurrent programming.
- [Dagger Hilt](https://dagger.dev/hilt/) - Dependency injection framework for Android apps.
- [Retrofit](https://square.github.io/retrofit/) - Type-safe HTTP client for making network requests.
- [OkHttp](https://square.github.io/okhttp/) - HTTP client for efficient network communication.
- [Room](https://developer.android.com/jetpack/androidx/releases/room) - Android architecture components for SQLite database interactions.
- [AndroidX Media](https://developer.android.com/jetpack/androidx/releases/media) - Android architecture components for media playback.

## Bugs and Issues

Please note that the app is currently under development and bugs may be present. Bug reports and suggestions are welcome. The app also requires active internet connection to function properly.

## Setup

1. Clone the repository: `git clone https://github.com/GreatGrant/Okwu-Asusu-Igbo-Dictionary.git` 
2. Open the project in Android Studio and download all necessary dependencies.
3. Replace the API key in the `local.properties` file with your actual API key.
   
## Architecture Overview

The Igbo Dictionary App follows the clean architecture approach, separating the app into different layers:

- **Presentation**: Contains UI-related code, built using Jetpack Compose.
- **Domain**: Contains business logic and use cases.
- **Data**: Responsible for retrieving and storing data. Integrates with the API and local storage.


## How to Contribute

Contributions to the Igbo Dictionary App project are welcome! Here's how you can get started:

1. Fork the repository.
2. Create a new branch for your feature: `git checkout -b feature-name`.
3. Implement your changes and ensure they are well-tested.
4. Push your changes to your fork: `git push origin feature-name`.
5. Open a pull request to the main repository.

For major changes, please open an issue first to discuss what you would like to change.

## Contact
If you have any questions or suggestions, feel free to contact me on [X](https://twitter.com/iAmGreatGrant) or [LinkedIn](https://www.linkedin.com/in/Great-Grant-Williams). You can also raise an issue in the [repository](https://github.com/GreatGrant/Okwu-Asusu-Igbo-Dictionary).

## Support
If you like this project, please consider supporting it by giving it a star ⭐️.


## Credits

This project is built by the collaborative efforts of contributors. The Igbo API used by this app is provided by [nkowaokwu](https://github.com/nkowaokwu).

## License

This project is licensed under the [MIT License](LICENSE).
