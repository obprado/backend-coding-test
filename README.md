Getting started
====
Instructions for building and running the app

Building and running the app
--------------
The following instructions have been designed for ubuntu server.
Tested under a digital ocean droplet:
Configuration: Ubuntu 14.04 x64, 512 Mb Ram, 20 Gb SSD

Execute the following commands:


    //Install Java 8
    add-apt-repository ppa:webupd8team/java
	//You may be asked to press enter
    apt-get update
    apt-get install -y oracle-java8-installer
    //At this point you will be asked to accept terms
    apt-get install oracle-java8-set-default 

    //Install git, maven and mysql
    apt-get install -y git
    apt-get install -y maven
	apt-get install -y mysql-server
	//The mysql installer may ask for a root password.
	//If you want to use simple defaults, use "secret"	

    //Clone project. 
    git clone https://github.com/obprado/backend-coding-test.git
    cd backend-coding-test
	
	//Create database and tables
	mysql -u root -p
	//Enter password. If you are using defaults, it's "secret"
	//Now you should see an interactive mysql shell
	create database expense;
	exit;
	//Back to ubuntu shell. Apply migration to create table
	mysql -u root -p expense < relational-persistence/src/main/resources/01_addExpenses.sql
	//Enter again password. If you are using defaults, it's "secret"
	
	//Build and test project. Should take 40 sec to 1 minute.
    mvn clean install

    //Run project
    cd rest-api
    mvn jetty:run
    //wait for: "[INFO] Starting scanner at interval of 10 seconds."
	//To see the site running, open a browser and go to "<server_IP_or_URL>:8080/default.html"
	
	
Known issues / things that can be improved
--------------
The integration tests interfere with the database, they introduce test data.

The system should have two different environments with different configurations. Embedded database (Ej. HSQLDB) for dev/testing and independent DB (Ej. MySQL) for production.
Configuration of the environments was left out of the scope of this project.

The unit tests could be more exhaustive.

The REST API should have focused test in addition to service-wide test.

If the service grows, the bootstraping / Module wiring / dependency inyection (expenses-servlet.xml) should be in a separate module, not embedded in the REST / interface module.

Client side code (HTML, JS, CSS,....) should probably be in a separate module.

Angular URL mapping should be prettyfied. "default.html#/expenses" doesn't seem very elegant.

Service should be moved to port 80 instead of 8080.

Continuous Integration / Deployment should be configured to work with the project. The current manual deployment explained in this README is not really agile-friendly.

The client side code sends the wrong date back to the server (sends 1 day less than it should). Couldn't find the cause.