## Compile project

```bash
./eureka/mvnw clean install -DskipTests -f ./eureka/pom.xml
./gateway_server/mvnw clean install -DskipTests -f ./gateway_server/pom.xml
./candidat/mvnw clean install -DskipTests -f ./candidat/pom.xml
./job/mvnw clean install -DskipTests -f ./job/pom.xml
```

## Start the containers

```bash
docker-compose up -d
```