# checkout-dw

First attempt at a DropWizard project, based on the supermarket checkout 
domain, and using Guicy dependency injection.


How to start the checkout-dw application
---
1. Update schema using liquibase update (assumes postgres is up and running)
2. Run `mvn clean package` to build your application
3. Start application (using java 17) with `java --add-opens java.base/java.lang=ALL-UNNAMED -jar target/checkout-dw-1.0-SNAPSHOT.jar server config.yml`
4. To manage stock items use `http://localhost:8080/items` - POST new items or retrieve existing items by SKU.

Health Check
---
To see your application's health enter url `http://localhost:8081/healthcheck`
