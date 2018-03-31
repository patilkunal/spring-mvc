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

If you are using Tomcat from Eclipse, make sure to edit server.xml to following after you have run the app at least once and found that it has no DB connectivity
```xml
      <Context docBase="spring-mvc" path="/spring-mvc" reloadable="true" source="org.eclipse.jst.j2ee.server:spring-mvc">
		<ResourceLink global="test-h2ds" name="jdbc/H2DS" type="javax.sql.DataSource"/>      	
      </Context>

```
## Running the application
* Start H2 database by running h2w.bat from the bin folder 
* Configure jdbc url as per configuration (one shown is out of box)

### Create Database table
Create category table using following SQL
```sql
create table category (
id int IDENTITY PRIMARY KEY,
name varchar(100)
);
```

### Create User and Address tables
```sql

create table user_detail (
id identity primary key,
first_name varchar(50),
last_name varchar(50),
role varchar(50),
enabled Boolean,
password varchar(100),
email varchar(255),
contact_number varchar(20)
);

create table address (
id identity primary key,
user_id int,
address_line1 varchar(255),
address_line2 varchar(255),
city varchar(50),
state varchar(50),
postal_code varchar(10),
billing Boolean,
shipping Boolean,
constraint fk_address_user_id foreign key (user_id) references user_detail(id)
);

create table cart (
id identity primary key,
user_id int,
grand_total decimal(10,2),
cart_lines int,
constraint fk_cart_user_id foreign key (user_id) references user_detail(id)
);

create table product (
id int IDENTITY PRIMARY KEY,
name varchar(100),
quantity int,
categoryId int
);

```

* Deploy the war (or click run on server from Eclipse IDE)
* Test the application using curl command
```
curl -H "Accept: application/json" http://localhost:8080/spring-mvc/category
``` 
