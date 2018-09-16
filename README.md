#prototype api#
Api for display nearby jobs data

#Technology Stack

- Java 8
- Vert.x

#Build tools

- Gradle


#How to run

- change into project directory
- execute command 'gradle clean build run'

#Notes :

Since this project is prototype only 
- the data is hardcoded in repository layer
- The Authenticaion Credential is put on application.properties configuration file
  - username = prototype.user
  - password = prototype.password	

#Services url

There are two service urls

/auth : - for initial authentication this will return JWT which will be used for next request authorization, 
        - you are able to find the username and password in application.properties file
        - passing encoded64 format of 'username:password' from application.properties file to 'Authorization' Header of the request


/jobs : - display all jobs data, put the previous JWT on the authorization header
        
- Request format :
``` json
	{  
   		"location":{  
      			"longitude":191029121,
      			"latitude":-12374374
   		},
   		"level":{  
      			"id":1,
      			"name":"staff"
   		},
   		"salary":{  
      			"currency":"IDR",
      			"minimumRange":10000000,
      			"maximumRange":20000000
   		},
   		"specialization":[  
      			{  
         			"name":"IT/Software"
      			},
      			{  
         			"name":"Accounting"
      			}
   		]
	}
```
	
- Response format : 
``` json
[
    {
        "company": {
            "name": "Idemia",
            "address": "AIA Tower 38th floor, South Jakarta"
        },
        "jobTitle": "Backend Java Developer",
        "place": "South Jakarta",
        "distance": 10,
        "specialization": {
            "name": "IT/Software"
        },
        "level": {
            "id": 1,
            "name": "Staff"
        },
        "salary": {
            "currency": "IDR",
            "minimumRange": 10000000,
            "maximumRange": 20000000
        },
        "postDate": {
            "month": "AUGUST",
            "year": 2018,
            "dayOfMonth": 28,
            "dayOfWeek": "TUESDAY",
            "dayOfYear": 240,
            "monthValue": 8,
            "hour": 5,
            "minute": 18,
            "nano": 262000000,
            "second": 26,
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        },
        "expiredDate": {
            "month": "SEPTEMBER",
            "year": 2018,
            "dayOfMonth": 20,
            "dayOfWeek": "THURSDAY",
            "dayOfYear": 263,
            "monthValue": 9,
            "hour": 5,
            "minute": 18,
            "nano": 262000000,
            "second": 26,
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        }
    },
    {
        "company": {
            "name": "Idemia",
            "address": "AIA Tower 38th floor, South Jakarta"
        },
        "jobTitle": "Senior Backend Java Developer",
        "place": "South Jakarta",
        "distance": 10,
        "specialization": {
            "name": "IT/Software"
        },
        "level": {
            "id": 1,
            "name": "Supervisor"
        },
        "salary": {
            "currency": "SGD",
            "minimumRange": 9000,
            "maximumRange": 15000
        },
        "postDate": {
            "month": "AUGUST",
            "year": 2018,
            "dayOfMonth": 28,
            "dayOfWeek": "TUESDAY",
            "dayOfYear": 240,
            "monthValue": 8,
            "hour": 5,
            "minute": 18,
            "nano": 263000000,
            "second": 26,
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        },
        "expiredDate": {
            "month": "SEPTEMBER",
            "year": 2018,
            "dayOfMonth": 20,
            "dayOfWeek": "THURSDAY",
            "dayOfYear": 263,
            "monthValue": 9,
            "hour": 5,
            "minute": 18,
            "nano": 263000000,
            "second": 26,
            "chronology": {
                "id": "ISO",
                "calendarType": "iso8601"
            }
        }
    }]
```



