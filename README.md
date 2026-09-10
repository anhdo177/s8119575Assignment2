# s8119575Assignment2

Android application for the NIT3213 final assignment. The app uses the Footscray campus API to authenticate a student user, load the technology dashboard data, and show details for each technology device.

## Features

- Login screen for Student ID and password
- Footscray authentication endpoint
- Dashboard screen with RecyclerView list of technology devices
- Details screen showing full entity information, including description
- Material 3 styled XML layouts
- Hilt dependency injection
- Retrofit and Moshi network layer
- ViewModel unit tests using JUnit, MockK, and kotlinx-coroutines-test

## API

Base URL: https://nit3213apinew.onrender.com/

Endpoints used:

- POST footscray/auth
- GET dashboard/{keypass}

For Footscray login, the username is the Student ID without the `s`, and the password is the student's first name with matching case. A successful login returns a `keypass`, which is used to load the dashboard data.

## Project Structure

- network/data/login: Login request, response, and repository
- network/data/dashboard: Dashboard response, entity model, and repository
- network/services: Retrofit API interface
- network/utilities: Retrofit setup
- ui/login: Login screen
- ui/dashboard: Dashboard screen, ViewModel, RecyclerView adapter, and ViewHolder
- ui: Fragment host and details screen

## Main Dependencies

- Kotlin
- AndroidX AppCompat
- AndroidX Navigation Component
- Material Components
- Retrofit
- Moshi
- Hilt
- MockK
- JUnit
- kotlinx-coroutines-test

## How to Run

1. Open the project in Android Studio.
2. Sync Gradle.
3. Select an emulator or Android device.
4. Run the `app` configuration.
5. Log in with valid Footscray assignment credentials.

## How to Run Tests

Unit tests are located in `app/src/test/java`.

Run tests from Android Studio by right clicking the `test` folder and selecting **Run Tests**.

The current unit tests cover:

- Empty login input validation
- Successful login keypass handling
- Failed login error handling
- Successful dashboard entity loading
- Failed dashboard load error handling