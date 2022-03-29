FROM node:latest

WORKDIR /build/app

COPY package.json .
COPY package-lock.json .
COPY src/main/js .

RUN npm uninstall babel
RUN npm install --save-dev babel-cli
RUN npx babel . --out-dir ./target

FROM openjdk:11-jdk as build

WORKDIR /build/app

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod a+x mvnw

RUN ./mvnw clean package

##################################################

FROM openjdk:11-jre-slim as run

COPY --from=build /build/app/target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
