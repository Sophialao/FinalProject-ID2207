# FinalProjectID2207

Final Project for ID2207 by Henrietta Hellberg and Sophia Lao.

All tasks are handled through events!!

//Henri does this for next iteration
//Not done - HR request, finical request, commenting on event requests and events
//Adding comments on events

//some way to link an event request to an event?


//todo: make sure you can only make an event if there is an event request?
//checking all input?

//iteration 2

-Overview-
There is a test user called "emp" password "emp" with authority to do most things for testing purposes.

Everything should go through the facades

EmployeeData = database for worker system
RequestData = database for HR/Financial/Event requests
EventData = database for events

LoginHandler = handles stuff related to being logged in (we might want to add logging out)
EventHandler = (right now same as requests but will change) should handle events
RequestHandler = should handle everything related to requests

You can now
create event request
view event requests
update event request


All users should have mostly correct access rights(can be changed in EmployeeData) and only be able to view and execute the correct ones.

//started financial request and HR request

//iteration 1
#### Login Credentials

(Employee type - UserName:password)<br/>
Customer Service Employee - CSEmployee1:Pass<br/>
Customer Service Manager - CSManager:Pass<br/>
<br/>
Financial Employee - FEmployee1:Pass<br/>
Financial Manager - FManager:Pass<br/>
<br/>
Production Employee - PEmployee1:Pass<br/>

Production Manager - PManager:Pass<br/>
<br/>
Service Manager - SManager:Pass<br/>
Service Employee - SEmployee1:Pass<br/>
<br/>
Administration Manager - AManager:Pass<br/>
Admin Employee - AEmployee1:Pass<br/>
<br/>
Vice President - VPresident:Pass<br/>
