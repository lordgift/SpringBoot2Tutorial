# SpringBoot2Tutorial
Spring Boot 2.0.0 Tutorial 

![](https://img.shields.io/badge/Java-8-orange.svg)
![](https://img.shields.io/badge/Spring%20Boot-2.0.0-green.svg)

This project for sample REST web service project. I've include all necessary that I use.

If anything works, Spring will start & swagger-ui will ready to access

[http://localhost:8000/spring/swagger-ui.html](http://localhost:8000/spring/swagger-ui.html)

----------------------

Incoming requests will passed this file first. That should include client verification here, otherwise you can add exclusion too.
[TokenAuthenticationFilter.java](./src/main/java/th/in/lordgift/SpringBoot2Tutorial/secure/filter/TokenAuthenticationFilter.java)

### Presentation Layer
* [ServiceController.java](./src/main/java/th/in/lordgift/SpringBoot2Tutorial/controller/ServiceController.java)

### Business Layer
* [ServiceManager.java](./src/main/java/th/in/lordgift/SpringBoot2Tutorial/service/ServiceManager.java)

### Persistence/DAO Layer
* [QueryRepository.java](./src/main/java/th/in/lordgift/SpringBoot2Tutorial/repository/QueryRepository.java)
* [PersistenceRepository.java](./src/main/java/th/in/lordgift/SpringBoot2Tutorial/repository/PersistenceRepository.java)
* [MyUserPaging.java](./src/main/java/th/in/lordgift/SpringBoot2Tutorial/repository/MyUserPaging.java)

----------------------

You can use [Testing.postman_collection.json](./Testing.postman_collection.json) for import & test with POSTMAN.
