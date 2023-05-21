
<h1 align="center"> 
[  Food Delivery Platform API  ]</h1>

This is the documentation for The food delivery system which help the user to order food from restaurant.
This food delivery system first autheticate the user and after authentication the user can order food.


* This system perform all the crud operations using jpa repository.
* We have used different types of validation in this project to validate all the entities.
* This system help to authenticate the user using authentication.
>### Prerequisites

 * ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-purple)

* ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-orange)
* ![MySql](https://img.shields.io/badge/DBMS-MYSQL%205.7%20or%20Higher-blue)
>### Technologies and languages Used
* Java
* Spring Boot
* Hibernate
* Mysql
* Postmat
* Swagger



>### Flow of Program
 The food Delivery System consists different layers to control the flow of the system and make relationships between all the entities of the system.
 * Model
 * Dto
 * Controller
 * Service
 * Repository

* **Config** - The configuration layers is used to do the swagger configuration in the food delivery system.
* **DTO** -The DTO layer consists of classes that are used to transfer data between different layers of the application
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.

>### Structure of Food Delivery System:--
* **Model** :- Admin, AuthenticationToken, FoodItem, FoodOrder, User
* **Controller** :- AdminController, FoodOrderController, UserController
* **dto** :- SignInInput, SignInOutput, SignUpInput, SignInOutput
* **Service** :- AutheticationTokenService, FoodItemService, FoodOrderService, UserService
* **Repository** :- AdminRepository, AuthenticationRepository, UserRepository, FoodItemRepository, FoodOrderRepository
* **Config** :- SwaggerConfiguration.



>## Project Summary
The Food Delivery Platform API is a Spring Boot-based application that provides endpoints for users to order food items from restaurants. It ensures secure authentication for users and allows administrators to manage food items through CRUD operations. The API communicates with a MySQL database to store and retrieve user and food item data.
