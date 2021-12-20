FROM bellsoft/liberica-openjdk-alpine-musl:11.0.12
WORKDIR /usr/local/app
COPY db/migration/*.sql db/migration/
ADD marketplace-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar ./app.jar