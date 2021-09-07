# International phone number validation

This project is a single page application that uses the provided database (SQLite) to list and categorize country phone numbers.
And it's possible to filter by country and state       

# Project Technologies

- Spring boot
- Java 8
- Build Tool: Maven
- Database: SQLite
- Docker

# How to Use

- Clone this repository
- Install [Maven](https://maven.apache.org/download.cgi)
- Install [Docker](https://runnable.com/docker/install-docker-on-windows-10)
- To build project, run below code in root:
```bash
mvn clean install
```
- Maven will generate a target folder with phone-number-validator-1.0.0-SNAPSHOT.jar inside it
- To run the project as a packaged application, run below code in root:
```bash
java -jar target/phone-number-validator-1.0.0-SNAPSHOT.jar
```
- To run the project using the Maven plugin, run below code in root:
```bash
mvn spring-boot:run
```

Then open http://localhost:8080/phone-number-validator/customers/phoneNumbers

- To run the project using Docker, run below code in root:

```bash
docker build -t phone-number-validator .
```
```bash
docker run -p8080:8080 phone-number-validator.
```

Then open http://localhost:8080/phone-number-validator/customers/phoneNumbers