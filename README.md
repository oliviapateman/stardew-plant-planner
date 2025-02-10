# Stardew Plant Planner Project

## About:
This solo project was designed with [Stardew Valley](https://www.stardewvalley.net/) players in mind. It aims to provide an efficient webapp that displays the data needed 
in order to yield a productive crop in the game. The project includes a landing page, a page with a spreadsheet of data relating to selling
prices of the different crops, and a page that holds a profit calculator. The calendar page is a work-in-progress.  

This project has been produced with Spring Boot, H2Database, Spring JPA, and ThymeLeaf. It works by Spring Boot autoconfiguring the application when it is run.
It then handles HTTP requests to the different pages in the web browser, as well as the requests for the calculator form, through the controller classes.
The data table webpage connects to an in-memory database to retrieve all the desired information, and then loops through each entity using ThymeLeaf to display it 
on the web browser. Additionally, the calculator form works by taking user input from the web, parsing it through a form with the corresponding fields, and matching
the form's plant ids with the database's plant ids to ensure the information matches correctly. The prices are then calculated in a service class, and displayed 
using ThymeLeaf.  

This project was created in Java in IntelliJ IDEA.

### Prerequisites:
- Use an IDE to run the program.

### How to run:
- Executing via commandline: ./mvnw spring-boot:run  
OR
- Through an IDE: Execute Maven Goal -> mvn spring-boot:run
- Open web URLs: http://localhost:8080/, http://localhost:8080/crops, http://localhost:8080/calculator and http://localhost:8080/calendar.
- Navigate webpages and fill out calculator form.

### Dependencies
- ThymeLeaf
- Spring Web
- Spring DevTools
- H2Database
- Spring Data JPA
- JUnit
