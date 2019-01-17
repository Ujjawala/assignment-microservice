FROM openjdk:11.0-oracle
ADD ./target/muzixapp-0.0.1-SNAPSHOT.jar /usr/src/muzixapp-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","muzixapp-0.0.1-SNAPSHOT.jar"]