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
    apt-get update
    apt-get install -y oracle-java8-installer

    //At this point you will be asked to accept terms
    apt-get install oracle-java8-set-default 

    //Install git and maven
    apt-get install -y git
    apt-get install -y maven

    //Clone, build and test project. Should take 40 sec to 1 minute.
    git clone https://github.com/obprado/backend-coding-test.git
    cd backend-coding-test
    mvn clean install

    //Run project
    cd rest-api
    mvn jetty:run
    //wait for: "[INFO] Starting scanner at interval of 10 seconds."
