# naftis

## dockerize
replace _n_ by the correct version:

````sh 
docker build --tag=naftis:n --tag=naftis:latest --rm=true --build-arg JAR_FILE=target/naftis-0.0.1-SNAPSHOT.jar . 
````

run naftis:

````sh
docker run -p 8080:8080 naftis:latest
````

POST some commands:

````sh
curl -d '{"externalId":1,"command":"echo","message":"hello","sender":"me"}' -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/rest/commands
````