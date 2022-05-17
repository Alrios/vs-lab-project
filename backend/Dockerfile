FROM openjdk:17

WORKDIR /app
COPY ./src src
# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

RUN ./mvnw clean install

CMD ./mvnw spring-boot:run
