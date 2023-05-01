# University_Event_Management

## Frameworks and Language used:
 - Spring
 - Spring boot
 - Java

 ## Data Flow
 #### Controller
 ---Student----
 - getAllStudents
 - getStudentById
 - addStudentRecords
 - updateStudentRecord
 - deleteStudentRecord
 
 ---Event----
 - getAllEvents
 - AddEventDetails
 - updateEventRecord
 - deleteEventRecord

 #### Service
 ---Student----
 - getAllStudentRecords
 - getStudentBasedOnId
 - addStudentData
 - updateStudentData
 - deleteStudentData
 
 ---Event----
 - getAllEventsRecords
 - addEventsData
 - updateEventData
 - deleteEventData
 #### Repository
 ---Student----

 IStudentRepository

 ---Event----

 IEventRepository
 #### Model
 ---Student----
 - studentId
 - firstName
 - lastName
 - age
 - department
 
 ---Event----
 - eventId
 - eventName
 - locationOfEvent
 - date
 - startTime
 - endTime
 #### Util
 - EventValidation
 - setStudent
 - setEvent
### Project Summary
Created a Simple University Event Management project in which I have created a model of student and Events details and description and added the CRUD(Create, Read, Update, Delete) operations. ALso perform validation for some fieds like 25>=age>=18, first name should be capital etc.

### How to use in your system?
 - Just Simply clone this repository
 - Start your server
 - Perform operations 
