FROM openjdk:11.0-oracle
ADD ./target/musicservice-0.0.1-SNAPSHOT.jar /usr/src/musicservice-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","musicservice-0.0.1-SNAPSHOT.jar"]