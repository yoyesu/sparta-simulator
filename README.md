# Sparta Training Academy Simulator Project
![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor)
![performance](https://img.shields.io/badge/-Performance-orange?style=for-the-badge&logo=appveyor)

**Developed by Maria, Will, Max, Ricardo, Justin, John, Mohamed, Gurjeev, and Lucas**

### **Table Of Contents**
* [**About Project**](#about-project)
  - [Built With](#built-with)
  - [Dependencies](#dependencies)
* [**Getting Started and Program Overview**](#getting-started-and-program-overview)
  - [Installation](#installation)
* [**Testing**](#testing)
  - [JUnit Testing](#junit-testing)
  - [Manual Testing](#manual-testing)
* [**Future Developments**](#future-developments)


## About Project

To create a Sparta Global simulation of the company and its expansion, where trainees are randomly created on a monthly basis and either trained or assigned to a waiting list. This will run for a set amount of time determined by the user and output a summary of the number of trainees trained, trainees waiting, training centres open as well as other statistics.  This will allow the client to better business forecasts.

### <span style="color: blue;">**Built With**</span>

* IntelliJ IDEA (Community Edition)
* junit-jupiter:5.8.2

### <span style="color: blue;">**Dependencies**</span>

* junit.jupiter Version 5.9.0

***
## Getting Started and Program Overview

Run the project using your IDE of choice.
Make sure to install the dependencies and software included.

### <span style="color: blue;">**Installation**</span>

Clone the repository below.
> https://github.com/yoyesu/sparta-simulator.git

Once installed and run the program will ask you to:

![Screenshot 2022-11-04 12 28 05](https://user-images.githubusercontent.com/115258568/199985863-bbf21b51-88e5-4e6e-876b-ac60342b1028.png)

  1. Create a *"resources"* folder in main.
2. Enter the number of years: <Enter number of years require for the simulation here>
3. Select a choice for the report,
    1. A yearly breakdown -> this will print out an annual summary of the clients / tech centres / bootcamps / trainees for each course as well as save this in the resources folder
    2. A simulation summary -> this will only produce totals for the clients / tech centres / bootcamps / trainees for the entire simulation

You will find the generated report in the **resources** folder.

***


## Testing

### <span style="color: blue;">**JUnit Testing**</span>

JUnit testing allowed us to test the classes in the model of the project such as using parameterized tests to test for multiple values without having to do any long manual testing.<br>

JUnit testing allowed us to maintain our program to ensure that it works without any error.<br>

Errors can be found by asserting results and comparing it to the actual result.<br>

Looking at our test coverage, the average % of code coverage is low due to code being unsuitable for unit testing.<br>
The classes which use it the most are within the model package of our project which have good testing coverage.<br>

### <span style="color: blue;">**Manual Testing**</span>

The parts of the program which were not suitable for unit testing were tested manually.<br>

***

## Future Development

For future improvements we would like to implement a user-friendly UI to view the data.
