## About
This framework perform basic automation testing of Android app. Can be launched as local as from Docker container
## Instruments:
* Java 17
* TestNG
* Selenium
* Appium
* Docker
## Requirements:
### On local:
* Java 17
* Install Appium server
### By Docker:
* Install Docker
## Launch tests:
### On local:
* Start ADB `adb devices`
* Connect device or start emulator
* Start Appium server `appium`
* Change values in properties files due to device and appium configurations (/src/main/resources/) 
* Run tests `./gradlew first_test`
* Check tests results (/build/reports/first_test/index.html)
## By Docker
* Start ADB `adb devices`
* Connect device or start emulator
* Change values in .env file due to device and appium configurations (min changes: DEVICE_NAME, PLATFORM_VERSION on yours)
* Run tests `docker build -t test-art . && docker-compose up --exit-code-from test-art`
* Check tests results (/build/reports/first_test/index.html)