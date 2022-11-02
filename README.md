# Sparta Training Acadamy Simulator Project
![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor)
![performance](https://img.shields.io/badge/-Performance-orange?style=for-the-badge&logo=appveyor)

**Developed by Maria, Will, Max, Ricardo, Justin, John, Mohamed, Gurjeev, and Lucas**

### **Table Of Contents**
* [**About Project**](#about-project)
    - [Built With](#built-with)
    - [Dependencies](#dependencies)
* [**Requirements**](#requirements)
* [**Getting Started and Program Overview**](#getting-started-and-program-overview)
    - [Installation](#installation)
    - [Program Structure](#program-structure)

* [**Use of Functional Programming**](#use-of-functional-programming)
* [**Testing**](#testing)
    - [JUnit Testing](#junit-testing)
    - [Manual Testing](#manual-testing)


## About Project

This project is developed as a team of 9, following agile methodologies, good programming practices in OOP, SOLID, design patterns, testing and logging.

Sparta Global wants us to create a trainee simulator where we take in 50 new trainees per month and assign them to a new trainee centre which gets built every 2 months.
The client wants to input how long they would like to run the simulation for, then the program uses this information to output how many trainees were generated, how many full 
trainee centres, and how many open trainee centres there are among other statistics. This will allow the client to better predict their plan for the future.
The projects functionality includes being able to write data to a csv file, a GUI system that the user can interact with and the simulation for x amount of time.

### <span style="color: blue;">**Built With**</span>

* IntelliJ IDEA (Community Edition)
* junit-jupiter:5.8.2

### <span style="color: blue;">**Dependencies**</span>

* junit.jupiter Version 5.9.0

***
## Requirements

- The program starts by asking how long the simulation will run for
- Every month, a random number of trainees are generated wanting to be trained (50 - 100)
- Every 2 months, Sparta global opens a training centre. They open instantly and can take trainees every month
- A centre can train a max of 100 trainees and takes a random number of trainees every month. (0 - 50 trainees up to their capacity)
- If a centre is full, trainees can be moved to any other centre which is not full
- If all centres are full, the trainees go onto a waiting list. This list must be served first before new trainees are taken
- At the end of the simulation, output should show:
    - number of open centres
    - number of full centres
    - number of trainees currently training
    - number of trainees on the waiting list
***
## Getting Started and Program Overview

Run the project using IntelliJ Community Edition.
Make sure to install the dependencies and software included.

### <span style="color: blue;">**Installation**</span>

Clone the repository below.
> https://github.com/yoyesu/sparta-simulator.git


### <span style="color: blue;">**Program Structure**</span>

<span style="color: red;">**Model**</span>

→ **Trainee** package which contains the **Trainee** class which is an object that holds all the data that a trainee would have<br>
→ **TraineeInterface** class which implements Trainee<br>

→ **TraineeCentre** package which contains the **TraineeCentre** class which is an object that holds all the data that a trainee centre would have<br>

→ **WaitingList** package which contains the **WaitingList** class which holds the queue for new trainees wanting to join a trainee centre<br>
→ **Node** which holds an element for waiting list<br>
<span style="color: red;">**View**</span>

→ **Input** package which contains the **Inputable** and **TimeFrameImputter** classes which inputs the total time the simulation will run for <br>
→ **TraineeInterface** class which implements Trainee<br>
→ **CSVWriter** class which writes all the simulated data to a CSV file<br>
→ **OutputToConsole** and **OutputInterface** class which outputs all the simulated data to the console<br>

<span style="color: red;">**Controller**</span>

→ **App** class which starts the program<br>
→ **Starter** class which calls the necessary methods<br>
<span style="color: red;">**Utilities**</span>

→ **Utilities** package which contains the **Logging** class which logs all of our data and the program <br>
→ **Random** package which contains the **Randomizer** class which generates random numbers<br>

<span style="color: red;">**Exceptions**</span>

→ **Exceptions** package which contains the **Exceptions** classes which catches and throws errors that we encounter in the code<br>


<span style="color: red;">**Tests**</span>

Runs a similar MVC as main, but instead tests the code.

### <span style="color: blue;">**Analysis**</span>


***

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

For future improvements we would like to implement a user-friendly UI to view the data.<br>

