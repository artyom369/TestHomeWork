FROM openjdk:17
WORKDIR /project
COPY . .
CMD ./gradlew "$SUITE"