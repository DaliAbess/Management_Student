FROM maven:3.8.3-openjdk-17
WORKDIR /home/app
COPY ./src ./src
COPY ./pom.xml .

EXPOSE 8081

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "/home/app/target/Management_Student-0.0.1-SNAPSHOT.jar"]
