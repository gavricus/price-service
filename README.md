# **Price Service**

To run application execute (requires java 17 installed):
```
./mvnw spring-boot:run
```

then to check endpoint:
```
curl "http://localhost:8081/api/price/quotes?brandId=1&productId=35455&date=2020-06-14-10:00:00"
```

To run test
```
./mvnw test
```
