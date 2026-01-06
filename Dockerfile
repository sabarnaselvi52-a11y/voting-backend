# ---- Build stage ----
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy Maven wrapper & pom
COPY backend/mvnw ./mvnw
COPY backend/.mvn ./.mvn
COPY backend/pom.xml ./pom.xml

# ✅ FIX: give execute permission to mvnw
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY backend/src ./src

# Build jar
RUN ./mvnw clean package -DskipTests


# ---- Run stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
