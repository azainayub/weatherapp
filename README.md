# Weather App

<div style="display: flex; justify-content: space-between;">
    <img src="screenshots\homepage.png" alt="Homepage Screenshot" height="380px">
    <img src="screenshots\weatherpage.png" alt="Weather Page Screenshot" height="380px">
</div>

## Project Description

Weather App is a user-friendly, Java-based desktop application designed to provide real-time weather information to users. It offers a convenient way for users to access up-to-date weather data, including current weather conditions and a 7-day weather forecast, all within a desktop environment. This application utilizes the OpenWeatherMap API to fetch weather data, making it a valuable tool for individuals who want to stay informed about the weather conditions in their area or any location of their choice.

## Features

- **Current Weather**: Get real-time data on temperature, humidity, wind speed, and more.
- **7-Day Forecast**: Plan ahead with a detailed 7-day weather forecast.
- **Location Flexibility**: Enter your location manually or use your device's GPS for automatic detection.
- **User-Friendly Interface**: Enjoy a sleek and intuitive user interface for easy navigation.

## Prerequisites

- **Java 11:** Make sure you have Java 11 installed on your system. You can download it [here](https://www.oracle.com/pk/java/technologies/downloads/#java11).

- **Gradle 7.4.2:** The project is built using Gradle 7.4.2. You can install Gradle by following the instructions [here](https://gradle.org/install/).

## Getting Started

1. Clone the Repository:

    Start by cloning the project repository to your local machine. You can do this using Git:

    ```git clone https://github.com/azainayub/weatherapp.git```

2. Get an OpenWeatherMap API Key:

    To access weather data, you need an API key for OpenWeatherMap's One Call API. You can obtain your API key by signing up on the OpenWeatherMap website [here](https://openweathermap.org/api/one-call-3).

3. Set Up Environment Variables:

    Create a file named ```.env``` in the root folder of the project. Inside this file, set your OpenWeatherMap API key as an environment variable like this:

    ```OWM_API_KEY = your-api-key-here```

4. Build the Project with Gradle:

    Now, use Gradle to build the project. Open a terminal, navigate to the project's root folder, and run the following command:

    ```./gradlew build```

5. Run the Application:

    After the project has been built successfully, you can run the application using the following command:

    ```./gradlew run```

    The application will start, and you can use it to check the weather for your specified location or your current location.

