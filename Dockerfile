FROM java:8-jdk-alpine

COPY ./target/players-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch players-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","players-0.0.1-SNAPSHOT.jar"]