# apm-server-sample
1 start elastic and kibana
2 start config spp to log  in file 
3 start log stash with config(config is in root git repo)
4 create jar file of your project mvn clean package spring-boot:repackage
5 run app with java agent (java -javaagent:elastic-apm-agent-1.7.1.jar 
-Delastic.apm.service_name=my-application   
-Delastic.apm.server_url=http://localhost:8200 
-Delastic.apm.secret_token=  
-Delastic.apm.application_packages=org.example 
-jar target/spring-boot-elk-0.0.1-SNAPSHOT.jar)
sample is in java inuse
