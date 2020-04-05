# code-contactmanagement

after all the maven build execute the project in following order

1. Eureka server -- it will run on port
URL to check all API listing
Eureka server URL : http://localhost:8761/



2. Start the config server -- it will refer the config file for all microservices from cloud and provide require details at run time.
it will also register itself on Eureka server.

URL can be checked to view the configuration
http://localhost:8087/{apiname}/{env}
below are URL for current configured config files
http://localhost:8087/ContactDetailManagement/prod 
http://localhost:8087/EdgeServer/prod


3. Start teh Edge server (pass following VM parameter to run as prod profile "Dspring.profiles.active=prod" )
 Server will pickup the configuration from config server and register on Eureka server as service.
It will run on 8000 port. 
API routing through edge(Zuul) server is pending, would require sometime to configure the setup.


4. Start ContactDetailManagement service  ( running on 9999)
--it will also register as API on eureka
-- it will refer configuration from config server
-- Business logic and all API end points are exposed from here.
-- Current its implemented from List, given extra time it can be enhanced via JPA.
-- for help purpose, I have added one default record in list.


below are the end point details

GET  http://localhost:9999/contactdetails  --to fetch the list of all contact detials
POST http://localhost:9999/contactdetails  -- to add the records in contact list , it will also provide the Location of resoruce, after successful addition.
                                                same url can be used to view that reqcord
GET http://localhost:9999/contactdetails/{ContactID}  - fetch saved record
POST http://localhost:9999/contactdetails/{ContactID}  -- to Modify teh contact details --passing contactid from url should match from passing body contact id, else it will fail.
                                                           this request will not modify the status
DELETE http://localhost:9999/contactdetails/{ContactID} --it will Inactive the record.



  








