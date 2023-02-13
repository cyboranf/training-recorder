FROM openjdk:17
ADD ./target/*.jar maven-wrapper.jar
ENTRYPOINT ["java","-jar","maven-wrapper.jar"]