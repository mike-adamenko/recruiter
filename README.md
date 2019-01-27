# recruiter

### Run the application  

To run the application, execute from the recruiter dir:

./gradlew build && java -jar build/libs/recruiter-0.0.1-SNAPSHOT.jar

Application will be started on http://localhost:8080

Port is configurable in application.properties (server.port)

For handling of notifications an event system is implemented (look at package com.heavenhr.recruiter.service.eventsystem)

### Please find application predefined data here :

recruiter\src\main\resources\data.sql

### Defined REST services:

#### HTTP GET operations 
*read a single offer by id*  
  http://localhost:8080/offers/{id}
  
  *read a single offer by job Title*  
    http://localhost:8080/offer?jobTitle={jobTitle}
   
   *read all offers*  
http://localhost:8080/offers

*read one application by id*  
http://localhost:8080/applications/{id}    

*read one application by candidate Email*
http://localhost:8080/applications/{candidateEmail}

*read  all applications per offer*
http://localhost:8080/applications/offer/{jobTitle}

*track the number of applications*
http://localhost:8080/numberOfApplications/{jobTitle}

#### HTTP PUT operations
*create a job offer*  
http://localhost:8080/offer  

BODY  example  
    {"jobTitle": "java programmer",  
    	"startDate": "2019-02-03",  
    	"numberOfApplications": "5"}  

 
 *apply for an offer*  
 http://localhost:8080/offer/{jobTitle}  
 
 BODY  example   
 {"candidateEmail":"email@gmail.com",
 "resumeText": "resumeText"}  
 
 #### HTTP POST operations
*progress the status of an application*  
http://localhost:8080/application/{candidateEmail}

BODY Example  
applicationStatus="INVITED"

