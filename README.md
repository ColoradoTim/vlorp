# Vlorp
This was a take-home coding exercise for an interview where the task was to build a REST API with CRUD operations that writes data to an in-memory database, using all the technologies listed below:   

Kotlin, Spring Boot, Spring Web, JPA, H2 (in-memory db), JUnit 5, Mockito, and Gradle.

If this was destined to be a production app, next steps would include:  
* more features  
* lots more tests. Unit, functional, end-to-end  
* input validation  
* ktlint  
* change from in-memory to persisted db  
* specify dependency versions in build.gradle  
* enable spring boot monitoring

and might include:  
* document the API (e.g., Swagger)  
* change server  
* create a UI and/or a reference client  


## Docker
To build image and run with docker, use `./gradlew clean jibDockerBuild && docker-compose up --build --remove-orphans`
Google's jib plugin pushes the image it builds to docker registry (run `docker images` to see a list)
Container entrypoint set to [java, -cp, /app/resources:/app/classes:/app/libs/*, timrapp.springbootjpah2.vlorp.VlorpApplicationKt]

## Redis
Docker starts a Redis container, but it's not used by the app. Yet.