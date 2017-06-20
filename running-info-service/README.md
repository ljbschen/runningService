# running-info-service
## Feature Supported
#### 1. Rest APIs
* Upload Running Information \
URL:```/runningInfo/upload```
* Delete All Running Information\
URL: ```/runningInfo/purge```
* Delete By RunningId\
URL: ```/runningInfo/deleteByRunningId```
* Return all Running Information in page with ```int page, int size, String sortDirection, String field```\
URL: ```/runningInfo```

#### 2. HAL Browser
* User can inspect supported REST APIs from Hal Browser
```localhost:8080/browser```

#### 3. OneToMany mapping supported.
* Separate table created for RunningInfo and UserInfo
* Duplicate UserInfo is detected by userName upon insert

## Requirements 
* Java Platform (JDK) 8
* Apache Maven
* Docker
* Docker Compose 

## Installation
#### 1. clone git
```aidl
git clone https://github.com/ljbschen/running-info-service.git
```

#### 2. run MySQL docker instance
```aidl
docker-compose up
```
Using MySQL version 5.7.18 with default password ```test```, default port ```3306``` and default databaseName ```running_info```

#### 3. Build and run Spring Boot application
```aidl
cd running-info-service
mvn clean install
java -jar target/running-information-service-1.0-SNAPSHOT.jar 
```

## Try your self
Feel free to use the input.json file to test the app out!