FROM openjdk:11-jre-slim
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
WORKDIR application
COPY /target/SalaryCalculator-2.0-develop-SNAPSHOT.jar ./
ENTRYPOINT ["java", "-jar", "SalaryCalculator-2.0-develop-SNAPSHOT.jar"]
EXPOSE 8080
CMD java $JAVA_OPTIONS -jar SalaryCalculator-2.0-develop-SNAPSHOT.jar