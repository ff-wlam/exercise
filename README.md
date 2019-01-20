# Applause exercise

Prerequisites
=============
MySQL
JDK
Maven

Configuration
=============
src/main/resource/application.properties
 set the spring.datasource.url, spring.datasource.username and spring.datasource.password to local environment

src/main/resource/sqlscripts.sql
 MySQL schema DDL
 
Execution
=========
> ./mvnw spring-boot:run

UI/UX
=====
No UI, please use curl or compatible tools, e.g. POSTMAN

e.g.
curl "http://localhost:8080/search?countries=US&devices=iPhone%204"

sample output:
{"userModelList":[{"firstName":"Taybin","lastName":"Rutkin","bugCount":66},{"firstName":"Miguel","lastName":"Bautista","bugCount":23}]}
