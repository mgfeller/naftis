# naftis

## dockerize
replace _v1_ by the correct version:

````sh 
docker build --tag=naftis:v1 --rm=true --build-arg JAR_FILE=target/naftis-0.0.1-SNAPSHOT.jar . 
````

run naftis:

````sh
docker run -p 8080:8080 naftis:v1
````

POST some commands:

````sh
curl -d '{"externalId":1,"command":"echo","message":"hello","sender":"me"}' -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/rest/commands

curl -d '{"externalId":1,"command":"egress_http","message":"hello","sender":"me"}' -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/rest/commands

// If curl or the os does not like ':
curl -d "{\"externalId\":1,\"command\":\"egress_http\",\"message\":\"hello\",\"sender\":\"me\"}" -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/rest/commands

````