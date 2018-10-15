# FinalProjectID2207

Final Project for ID2207 by Henrietta Hellberg and Sophia Lao.
After compiling, the code can be using the employee logins provided below.
    
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

#### Sample data already in the system:

    o bob (EventRequest)- has a financial request associated with it
    o party (EventRequest) - has been approved by both Admin and CSManager
    o TestEvent - Is a test event that is not based on an event request, would not be able to exist if it wasn't hard coded
    o Task - startup task must be added to "db" to be accessible

Futher actions to be done:

    o When in "approve event request" all requests are displayed, not just the ones that need to be approved
    o When in "comment on task" available events are not displayed because viewevents gets stuck in loop and show events is not based on employeeID.
