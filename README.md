# Description

This is a Spring Boot + Vue.JS project to create students, courses and results. The user will be able to view their creations
and also delete them.

It makes use of an in-memory H2 database, but can be configured to use another database by editing `application.resources`:
- **spring.datasource.url**
- **spring.datasource.driverClassName**
- **spring.datasource.username**
- **spring.datasource.password**
- **spring.jpa.database-platform**

## Additional Libraries/packages

This project makes use of node, npm, axios and vue-router. All will be included in the packaging step.
- axios (`npm install axios`)
- vue-router (`npm install vue-router`)

## Development
This can be executed without packaging it, but it'll require starting the backend and frontend applications separately.

- The Spring Boot application `MainApplication` can be executed standalone which will run on port 8080.
- The Vue application can be run via terminal with `npm run serve`, which will be accessible via `localhost:8081`

## Packaging 

This can be packaged using `mvn clean package` which will generate a JAR file.

## Deployment

Once the JAR is generated, this can be executed via:
java -jar `{JAR_LOCATION}`

If executed locally, `{JAR_LOCATION}` might be `target\student_result_mgmt-1.0-SNAPSHOT`

This can also be run on hosted/managed services.
