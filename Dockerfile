FROM openjdk:17 
MAINTAINER  padmanathan
COPY target/spring-boot.jar spring-boot.jar
ENTRYPOINT ["java","-jar","/spring-boot.jar"]