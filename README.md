# Movie Tracker - Android App

A modern Android application for discovering popular, top-rated, and upcoming movies. This project is built entirely in Kotlin and utilizes the latest Android development technologies, including Jetpack Compose for the UI, Hilt for dependency injection, and the MVVM architecture pattern.

---

## About The Project

This app serves as a portfolio project to demonstrate proficiency in modern Android development. It fetches real-time movie data from [The Movie Database (TMDb) API](https://www.themoviedb.org/documentation/api) and displays it in a clean, user-friendly, and visually appealing interface.

The primary goals of this project were to:
-   Implement a scalable and maintainable architecture (MVVM).
-   Build a fully declarative UI using Jetpack Compose.
-   Handle dependency injection effectively using Hilt.
-   Perform asynchronous network operations with Coroutines.
-   Integrate with a third-party REST API (TMDb).

## ✨ Features

-   ✅ **Discover Movies**: Browse movies from three distinct categories: Popular, Top Rated, and Upcoming.
-   ✅ **Featured Movie Showcase**: The main screen highlights a popular movie with a large backdrop image and details.
-   ✅ **Dynamic UI**: All content is loaded dynamically from the TMDb API.
-   ✅ **Modern & Responsive UI**: The user interface is built with Jetpack Compose, ensuring a fluid experience on different screen sizes.

---

## 🛠 Tech Stack & Architecture

### Tech Stack
-   **Language**: [Kotlin](https://kotlinlang.org/)
-   **UI**: [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android's modern toolkit for building native UI.
-   **Asynchronous Programming**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
-   **Networking**:
    -   [Retrofit](https://square.github.io/retrofit/) for type-safe HTTP requests.
    -   [OkHttp Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) for debugging network requests.
-   **Dependency Injection**: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for managing dependencies.
-   **Image Loading**: [Coil](https://coil-kt.github.io/coil/) for loading images in Compose.
-   **Android Jetpack Components**:
    -   ViewModel
    -   LiveData
    -   Lifecycle

### Architecture
This app follows the **MVVM (Model-View-ViewModel)** architecture pattern, which promotes a clean separation of concerns and improves testability and maintainability.

-   **Model**: Represents the data layer (Network API calls via Retrofit, data classes).
-   **View**: The UI layer, built with Jetpack Compose Composables (`HomeScreen`). It observes the ViewModel for state changes.
-   **ViewModel**: Acts as a bridge between the Model and the View. It fetches data from the repository, manages the UI state, and exposes it to the View.

---

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

-   [Android Studio](https://developer.android.com/studio) (latest version recommended)
-   An API Key from [The Movie Database (TMDb)](https://www.themoviedb.org/settings/api).

### Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/MovieTrackerApp.git
    ```

2.  **Open the project in Android Studio.**

3.  **Get your TMDb API Key:**
    -   Visit [themoviedb.org](https://www.themoviedb.org) and create a free account.
    -   Go to your account settings, find the "API" section, and register for a key.

4.  **Create the `local.properties` file:**
    -   In the root directory of the project (the same level as `settings.gradle.kts`), create a new file named `local.properties`.

5.  **Add your API key to `local.properties`:**
    -   Open the file and add the following line, replacing `YOUR_API_KEY_HERE` with your actual key. **Do not use quotes.**
    ```properties
    TMDB_API_KEY=YOUR_API_KEY_HERE
    ```

6.  **Sync Gradle and Run:**
    -   Android Studio will prompt you to sync the project.
    -   Once the sync is complete, build and run the app on an emulator or a physical device.

---

## 📂 Project Structure

The project is organized into packages based on features and layers to ensure a clean and scalable codebase.

```
com.example.movietracker
├── data
│   ├── models          # Data classes (e.g., Movie)
│   ├── network         # Retrofit API service interface
│   └── repository      # Manages data operations
├── di
│   └── AppModule.kt    # Hilt module for dependency injection
├── ui
│   ├── home            # Composables and ViewModel for the home screen
│   └── theme           # Jetpack Compose theme (Colors, Typography)
├── MovieTrackerApplication.kt # Application class for Hilt
└── MainActivity.kt       # Main entry point of the app
```

