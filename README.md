# JSON Logger

[![Build Status](https://travis-ci.org/michaelruocco/http-client.svg?branch=master)](https://travis-ci.org/michaelruocco/http-client)
[![Coverage Status](https://coveralls.io/repos/github/michaelruocco/http-client/badge.svg?branch=master)](https://coveralls.io/github/michaelruocco/http-client?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/54ce00d4a4084dabba53f5e2c5ef9a01)](https://www.codacy.com/app/michael-ruocco/http-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/http-client&amp;utm_campaign=Badge_Grade)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/http-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/http-client)

This project builds upon the [JSON logger from savoirtech](https://github.com/savoirtech/slf4j-json-logger). It allows
a client to provide a gson instance in order to perform json formatting for custom object types
as well as being able to configure the logger to configure environment variables to be automatically
logged.

## Usage

To use the library from a program you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    compile 'com.github.michaelruocco:json-logger:1.0.0'
}
```

### Basic Usage

You can create a logger instance using the logger factory:

```
Logger logger = LoggerFactory.getLogger("name", new EnvironmentVariableAppender("MY_VAR"));
```

You can also pass a class instead of name:

```
Logger logger = LoggerFactory.getLogger(MyClass.class, new EnvironmentVariableAppender("MY_VAR"));
```

Each of the methods above also have an overloaded version where you can pass a Gson
instance if you want to format custom object types when logging:

```
Gson gson = new GsonBuilder()
    .disableHtmlEscaping()
    .serializeNulls()
    .registerTypeAdapter(MyCustomClass.class, new MyCustomClassSerializer())
    .create();

Logger logger = LoggerFactory.getLogger("name", gson, new EnvironmentVariableAppender("MY_VAR"));
```

Or using class name:

```
Gson gson = new GsonBuilder()
    .disableHtmlEscaping()
    .serializeNulls()
    .registerTypeAdapter(MyCustomClass.class, new MyCustomClassSerializer())
    .create();

Logger logger = LoggerFactory.getLogger(MyClass.class, gson, new EnvironmentVariableAppender("MY_VAR"));
```

## Running the Tests

You can run the tests for this project by running the following command:

```
gradlew clean build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
or not they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```