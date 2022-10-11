# Demo Project

### Reference Documentation

![Spring Boot 2.7.4](https://img.shields.io/badge/Spring%20Boot-2.7.4-brightgreen.svg)
![JDK 8](https://img.shields.io/badge/JDK-8-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.6.2-yellowgreen.svg)
![Vultr](https://img.shields.io/badge/Vultr-yellowgreen.svg)

## 環境需求

- [Intellij IDEA](https://www.jetbrains.com/idea/)
    - Ultimate
    - Community
- [Docker](https://www.docker.com/)
- [jdk 11 +](https://www.oracle.com/tw/java/technologies/javase/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)

---


|Driver | JDBC URL|帳號 | 密碼 |
|----|----|----|----|
|org.h2.Driver|jdbc:h2:mem:demo|root|1234|



---

## Coin API


> ### list coins
> ```shell
> curl -X GET "http://<ip>:<port>/api/coins" 
> ```

> ### create coin
> ```shell
> curl -X POST -H 'Content-type: application/json' --data '{"code": "TWD","name":"台幣"}' "http://<ip>:<port>/api/coins" 
> ```

> ### update coin
> ```shell
> curl -X PUT -H 'Content-type: application/json' --data '{"name":"台幣_1"}' "http://<ip>:<port>/api/coins/{code}" 
> ```

> ### delete coin
> ```shell
> curl -X DELETE  "http://<ip>:<port>/api/coins/{code}" 
> ```


---

## CoinDesk API

> ### list coindesk and convert
> ```shell
> curl -X GET  "http://<ip>:<port>/api/coindesk" 
> ```

