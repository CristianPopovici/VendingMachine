# VendingMachine

Application that implements change calculating algorithm based on greedy.

### Prerequisites

have maven installed.

## Deployment

1. Change "repository.path" const in application.properties to an actual properties file.To be modified, the properties file
 needs to be outside the jar, so a absolute path has to be provided. There is a properties file that can be copied
 in resources folder. The program can run with the classpath coin-inventory.properties if the "repository.path"
  property is left empty but no persistence will take place.
2. mvn clean install
3. mvn spring-boot:run - without any other app on port 8080
4. open browser > localhost:8080

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://projects.spring.io/spring-framework) - Dependency Injection and other spring features
* [Spring Boot](https://projects.spring.io/spring-framework) - Embeded web app and automation
* [EasyMock](http://easymock.org/) - testing framework


## Author

* **Cristian Popovici** - (https://github.com/CristianPopovici)



