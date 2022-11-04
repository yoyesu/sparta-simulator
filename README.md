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
  - [Program Structure](#program-structure)
* [**Use of Functional Programming**](#use-of-functional-programming)
* * [**Testing**](#testing)
  - [JUnit Testing](#junit-testing)
  - [Manual Testing](#manual-testing)
* [**Project Management**](#project-management)
* [**Sprint 1**](#sprint-1)
  - [Requirements](#requirements)
  - [Delivery](#delivery)
* [**Sprint 2**](sprint-2)
  - [Requirements](#requirements)
  - [Delivery](#delivery)
* [**Sprint 3**](sprint-3)
  - [Requirements](#requirements)
  - [Delivery](#delivery)
* [**Future Developments**](#future-developments)


## About Project

To create a Sparta Global simulation of the company and its expansion, where trainees are randomly created on a monthly basis and either trained or assigned to a waiting list. This will run for a set amount of time determined by the user and output a summary of the number of trainees trained, trainees waiting, training centres open as well as other statistics.  This will allow the client to better predict their plans for the future.  

This project is developed as a team of 9, following agile methodologies, good programming practices in OOP, SOLID, design patterns, testing and logging. We created user stories on our [project board](https://trello.com/b/z01BitTz/boo-leans) to track our progess and ensure out focus remains on the tasks and requirements for the client.

### <span style="color: blue;">**Built With**</span>

* IntelliJ IDEA (Community Edition)
* junit-jupiter:5.8.2

### <span style="color: blue;">**Dependencies**</span>

* junit.jupiter Version 5.9.0

***
## Getting Started and Program Overview

Run the project using IntelliJ Community Edition.
Make sure to install the dependencies and software included.

### <span style="color: blue;">**Installation**</span>

Clone the repository below.
> https://github.com/yoyesu/sparta-simulator.git

Once installed and run the program will ask you to:
  1. Enter the number of years: <Enter number of years require for the simulation here>
  2. Select a choice for the report,
    1. A yearly breakdown -> this will print out a annual summary of the clients / tech centres / bootcamps / trainees for each course as well as save this in the resources folder
    2. A simulation summary -> this will only produce totals for the clients / tech centres / bootcamps / trainees for the entire simulation

The resources will save a history of the last 10 reports generated for reference.

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

## **Project Management**

To plan the project, Boo-Leans started by creating user stories from the client requirements.
Trello was the kanban board of choice as it provided a useful user-friendly interface.

Below is an image of Boo-Leans' kanban board:

![trello board](https://user-images.githubusercontent.com/115146708/199549971-900da146-3f70-41a0-9ff5-6079c3543509.png)


Acceptance criteria were written on each user story card and reviewed together as a group.
Boo-Leans used planning poker to agree on the level of difficulty of each user story before being commissioned.
The user stories where then assigned to either an individual or pair depending on difficulty and added to the user story card.

![user story](https://user-images.githubusercontent.com/115146708/199549868-ee5cb24c-7f83-44e5-9ea3-271718b8a838.png)

REVIEW
RETROSPECTIVE
  
BooLeans also created a UML diagram using Lucid, to create a visual representation of the program.
Here is an image of Boo-Leans' UML diagram:

![Lucid board](https://user-images.githubusercontent.com/115146708/199550021-2df35dea-3214-49d7-b571-f0453f6bac4e.png)

***

## **Sprint 1**
### <span style="color: blue;"> Requirements </span>

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


### <span style="color: blue;"> **Delivery** </span>

At the end of sprint 1, Booleans produced a minimum viable product to the client and the requirements were met.
***

## **Sprint 2**
### <span style="color: blue;"> Requirements </span>

* There are now 5 types of trainees: Java, C#, Data, DevOps or Business
* There are not 3 types of training centres:
  * Training hub: can train max 100 trainees but 3 are opened at a time.
  * Bootcamp: can train max 500 trainees but can remain open for 3 months if there are less than 25 trainees. If it has <25 trainees for 3 consecutive months it will close. Only 2 bootcamps can ever exist.
  * Tech centre: can train max 200 trainees but only teaches one course per centre, randomly chosen when its open.
* Sparta will check centres each month.
* If a centre has less <25 trainees, it will close.
* The simulation should offer a choice of output data, whether it's at the end of the simulation or the end of each month.
* The output should be the following, including a breakdown for each type:
  * number of open centres
  * number of closed centres
  * number of full centres
  * number of trainees currently training
  * number of trainees on the waiting list

### <span style="color: blue;"> **Delivery** </span>

At the end of sprint 2, Booleans produced a minimum viable product to the client and the requirements were met.
***

## **Sprint 3**
### <span style="color: blue;"> Requirements </span>

Stage 3 requirements:
- If a trainee has been in training for a year, they are moved to a bench state
- Clients will begin to be randomly created after 1 year of the simulation
- A client will have a requirement when they are created e.g a need for 27 Java trainees.  The requirement can be any value greater than or equal to
  15
- A client will take a random number of trainees from the bench each month (1 - full requirement) until their requirement is met
- A client will only take one type of trainee (Java, C#, Data, DevOps or Business)
- If a client does not collect enough trainees from the bench within a year, they will leave unhappy
- If a client does collect enough trainees from the bench within a year, they will leave happy and return the next year with the same requirement
- The output should now include a breakdown of happy and unhappy clients


## Future Development

For future improvements we would like to implement a user-friendly UI to view the data.<br>


***
