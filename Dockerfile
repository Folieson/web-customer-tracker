FROM tomcat:9.0.34-jdk11-corretto
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/web-customer-tracker.war /usr/local/tomcat/webapps/web-customer-tracker.war
EXPOSE 8080
CMD ["catalina.sh","run"]