# E2E POM design pattern for Java_Playwright

## _Playwright Automation_

##### This is a sample playwright(v1.40.0) project with POM design pattern. This readme provides a step-by-step guide to set up and execute tests using powerful combination of playwright, java and TestNG.

## _Prerequisite_

Before runnig the tests, ensure that you have following:

- Java Development Kit (JDK)
- Any IDE such as JetBrains Aqua, IntelliJ, or Eclipse.

## 🏁 _Getting started_

1. Clone this repository by running the following command:

        git clone https://github.com/alphabin1/playwright-sample
        cd Playwright_Java
2. Run the TestNG file located within the `testrunners` directory under `src/test/resources`:

        java -cp <CLASSPATH> org.testng.TestNG testng.xml


#### 🛠️ Test Configuration

- Modify the `browser` value within the `config.properties` file to seamlessly switch between browsers (e.g., Chrome, Firefox, WebKit, Chromium, and Edge) and execute your tests.

- To execute the tests, adjust the `headless` value within the config directory (`src/test/resources`) to `true` for headless mode or `false` for the standard mode.

## 🤝 Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.