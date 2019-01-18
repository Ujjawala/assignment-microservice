FROM openjdk:11.0-oracle
ADD ./target/userapp-0.0.1-SNAPSHOT.jar /usr/src/userapp-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","userapp-0.0.1-SNAPSHOT.jar"]