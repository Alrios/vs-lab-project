FROM openjdk:17

RUN mkdir -p /backend/
WORKDIR /backend

COPY ./backend/src src
# Copy maven executable to the image
COPY ./backend/mvnw .
COPY ./backend/.mvn .mvn

# Copy the pom.xml file
COPY ./backend/pom.xml .

RUN ./mvnw clean install

CMD ./mvnw spring-boot:run
