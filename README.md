# FinalProjectID2207

Final Project for ID2207 by Henrietta Hellberg and Sophia Lao.

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

### Tasks that can be done
All employees can view events
All managers can view employees, view clients, edit events, and view requests
All admins have manager rights and can edit employees and edit clients.

Customer service employees can make new event requests and view and edit clients.
