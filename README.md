#prototype api#


#Technology Stack

- Java 8
- Vert.x

#Build tools

- Gradle


#How to run

- change into project directory
- execute command 'gradle clean build run'


#services url

There are two service urls

/auth : - for initial authentication this will return JWT which will be used for next request authorization, 
        - you are able to find the username and password in application.properties file
        - passing encoded64 format of 'username:password' from application.properties file to 'Authorization' Header of the request


/jobs : - display all jobs data, put the previous JWT on the authorization header
        - request format :
	



