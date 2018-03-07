# Sample Spring MVC application (without using Spring BOOT)

## Tomcat configuration
Download and copy h2 jar in $TOMCAT_HOME/lib directory

Add following to server.xml to configure database

Under GlobalNamingResources 
```xml  
<Resource auth="Container" description="H2 Datasource (Test)" driverClassName="org.h2.Driver" name="test-h2ds" password="" scope="shareable" type="javax.sql.DataSource" url="jdbc:h2:tcp://localhost/~/test" username="sa"/>
```

Context Section (or context xml file) would look like this
```xml
      <Context docBase="spring-mvc" path="/spring-mvc" reloadable="true">
		<ResourceLink global="test-h2ds" name="jdbc/H2DS" type="javax.sql.DataSource"/>      	
      </Context>
```

## Running the application
* Start H2 database by running h2w.bat from the bin folder 
* Configure jdbc url as per configuration (one shown is out of box)

### Create Database table
Create User table using following SQL
```sql
create table category (
id int IDENTITY PRIMARY KEY,
name varchar(100)
);
```

* Deploy the war (or click run on server from Eclipse IDE)
* Test the application using curl command
```
curl -H "Accept: application/json" http://localhost:8080/spring-mvc/category
``` 
