FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
ADD . $HOME
RUN mvn package


FROM openjdk:11-jre-slim
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
WORKDIR application
COPY --from=build /usr/app/target/SalaryCalculator-2.0-develop-SNAPSHOT-jar-with-dependencies.jar ./
ENTRYPOINT ["java", "-jar", "SalaryCalculator-2.0-develop-SNAPSHOT-jar-with-dependencies.jar"]
CMD java $JAVA_OPTIONS -jar SalaryCalculator-2.0-develop-SNAPSHOT-jar-with-dependencies.jar