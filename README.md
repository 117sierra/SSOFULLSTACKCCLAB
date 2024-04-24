## Dockerize Spring Boot Application with MySQL Database

## Step 1: Download MySQL Docker Image
docker pull mysql:8.0.34 # Pull MySQL image (adjust version if needed)

## Step 2: Create MySQL Connection in MySQL Workbench
Create a new MySQL connection in MySQL Workbench CE on port 3307.

## Step 3: Run MySQL Docker Container
docker run -p 3307:3306 --name CONTAINERNAME -e MYSQL_ROOT_PASSWORD=PASSWORD -e MYSQL_DATABASE=DATABASENAME mysql:8.0.34 
#### Replace CONTAINERNAME, PASSWORD, and DATABASENAME with your desired values.

## Step 4: Create Docker Network
docker network create springssonet

## Step 5: Connect MySQL Container to Docker Network
docker network connect springssonet ContainerName
Replace ContainerName with the name of your MySQL container.

## Step 6: Build Spring Boot Application
mvn install # Maven build command to create spring.jar file

## Step 7: Build Docker Image for Spring Boot Application
docker build -t IMAGENAME . # Build Docker image for Spring Boot app
Replace IMAGENAME with ur choice.

## Step 8: Run Docker Containers
docker run -p 7000:8080 --name IMAGENAME --net springssonet -e MYSQL_HOST=MYSQLContainername -e MYSQL_USER=USERNAME -e MYSQL_PASSWORD=PASSWORD -e MYSQL_PORT=3306 springsso
Replace MYSQLContainername, USERNAME, and PASSWORD with your MySQL container details.

## Note:
- Set up SSO credentials (Secret ID and Secret Password).
- Adjust port number as per the above commands (set it to 7000).
- Update src/main/resources/application.properties accordingly for configuration.
