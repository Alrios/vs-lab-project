FROM openjdk:17

# Create the folder /vs-lab-project/backend/
RUN mkdir -p /vs-lab-project/backend/
WORKDIR /vs-lab-project/backend/

COPY ./backend/src src
# Copy maven executable to the image
COPY ./backend/mvnw .
COPY ./backend/.mvn .mvn

# Copy the pom.xml file
COPY ./backend/pom.xml .

RUN ./mvnw clean install

CMD ./mvnw spring-boot:run
