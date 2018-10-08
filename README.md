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
Customer Service Employee - CSEmployee1:CSEmployee1Pass<br/>
Customer Service Employee - CSEmployee2:CSEmployee2Pass<br/>
Customer Service Manager - CSManager:CSManagerPass<br/>
<br/>
Financial Employee - FEmployee1:FEmployee1Pass<br/>
Financial Manager - FManager:FManagerPass<br/>
<br/>
Production Employee - PEmployee1:PEmployee1Pass<br/>
Production Employee - PEmployee2:PEmployee2Pass<br/>
Production Employee - PEmployee3:PEmployee3Pass<br/>
Production Employee - PEmployee4:PEmployee4Pass<br/>
Production Employee - PEmployee5:PEmployee5Pass<br/>
Production Manager - PManager:PManagerPass<br/>
<br/>
Service Employee - SEmployee1:SEmployee1Pass<br/>
Service Employee - SEmployee2:SEmployee2Pass<br/>
Service Employee - SEmployee3:SEmployee3Pass<br/>
Service Employee - SEmployee4:SEmployee4Pass<br/>
Service Manager - SManager:SManagerPass<br/>
<br/>
Admin Employee - AEmployee1:AEmployee1Pass<br/>
Admin Employee - AEmployee2:AEmployee2Pass<br/>
Admin Employee - AEmployee3:AEmployee3Pass<br/>
Admin Employee - AEmployee4:AEmployee4Pass<br/>
Administration Manager - AManager:AManagerPass<br/>
<br/>
Secretary - Secretary:SecretaryPass<br/>
Vice President - VPresident:VPresidentPass<br/>

### Tasks that can be done
All employees can view events
All managers can view employees, view clients, edit events, and view requests
All admins have manager rights and can edit employees and edit clients.

Customer service employees can make new event requests and view and edit clients.
