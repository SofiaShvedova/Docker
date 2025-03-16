FROM OpenJDK:11-jdk-slim
WORKDIR /app
COPY ./app
RUN javac -cp postgresql-42.7.5.jar App.java

CMD ["java", "-cp", ".:postgresql-42.7.5.jar", "App"]