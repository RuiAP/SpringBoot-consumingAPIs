FROM openjdk:12 as builder
WORKDIR /app
COPY . /app
RUN ./mvnw clean package

FROM openjdk:11
RUN addgroup --system springgroup && adduser --system --ingroup springgroup springuser
USER springuser:springgroup
COPY --from=builder /app/target/*.jar /producing_api.jar
CMD ["java", "-jar", "/producing_api.jar"]
