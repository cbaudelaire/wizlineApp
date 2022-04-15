### Requirements

- Java version 11.
- Lombok. Make sure to install the plugin for the IDE that you prefer. For more information visit [this](https://projectlombok.org/) link.

### Configuration

This project use a ***H2*** Database (that is a memory database). The URL for access to the database is ***localhost:8080/h2*** with the username ***admin*** and without ***password***. Furthermore, make sure that the field *JDBC URL* in the *H2* init panel is ***jdbc:h2:mem:./wizlineDB*** where ***wizlineDB*** is the name of the database. If you want, you can modify the URL for accessing to the database, the username, the password or the name of the database, modifying these attributes in the ***application.yml*** file that you can find in the directory ***src/main/resources***.

In the resources directory, you can find ***import.sql*** file where the initial data is created. You can also modify this data deleting or inserting rows in this file.

If you have any trouble with the port, you can modify the default port (8080) adding the field:

server:
    port: the number of the port that you prefer (be careful with the indentation).

### Endpoints

- localhost:8080/ (GET method)
- localhost:8080/hello (GET method)
- localhost:8080/students (GET method)


If you require any further information / assistance, please feel free to contact me abrilrdev@gmail.com
