## Description

Example of java app, implementing mvc and dao architecture patterns

## Usage 

docker build -t cpatin10/mvc-dao-mysql-tomcat

docker run -d -p 8080:8080 -p 3306:3306 cpatin10/mvc-dao-mysql-tomcat

## Get container IP

docker inspect <container ID>     // IPAddress

## test

<container ID>:8080/Estudiante-dao-mvc/Index.html

## Note

When making a query you need to manually go back to <container ID>:8080/Estudiante-dao-mvc/Index.html 

