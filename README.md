# FinalProjectID2207

Final Project for ID2207 by Henrietta Hellberg and Sophia Lao.

StartUp data to make testing easier:

*bob (EventRequest)- has a financial request associated with it
*party (EventRequest) - has been approved by both Admin and CSManager

*TestEvent - Is a test event that is not based on an event request, would not be able to exist if it wasn't hard coded

*Task - startup task must be added to "db" to be accessible

Functionality:
*You can now create and handle financial and HR requests.
-HREmployee (pass=pass) can handle HR requests
-FManager can handle financial requests

*You can add a discount to an event request
*You can add a comment to a task

*Events can not be started unless the event request they are based on has not been approved by both a CSManager and someone from Administration

Things that need fixing:
*When in "approve event request" all requests are displayed, not just the ones that need to be approved

*When in "comment on task" available events are not displayed because viewevents gets stuck in loop and show events is not based on employeeID

--------------------------
All tasks are handled through events!!

//Henri does this for next iteration
//Not done - HR request, finical request, commenting on event requests and events
//Adding comments on events

//some way to link an event request to an event?
They are linked through a unique name imo


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
