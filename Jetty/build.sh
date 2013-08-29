JARS=/usr/share/java/jetty8-continuation.jar:/usr/share/java/jetty8-deploy.jar:/usr/share/java/jetty8-http.jar
JARS=$JARS:/usr/share/java/jetty8-io.jar:/usr/share/java/jetty8-jmx.jar:/usr/share/java/jetty8-overlay-deployer.jar
JARS=$JARS:/usr/share/java/jetty8-policy.jar:/usr/share/java/jetty8-rewrite.jar
JARS=$JARS:/usr/share/java/jetty8-security.jar:/usr/share/java/jetty8-server.jar
JARS=$JARS:/usr/share/java/jetty8-servlet.jar:/usr/share/java/jetty8-servlets.jar
JARS=$JARS:/usr/share/java/jetty8-start.jar:/usr/share/java/jetty8-util.jar
JARS=$JARS:/usr/share/java/jetty8-webapp.jar:/usr/share/java/jetty8-xml.jar

#javac -sourcepath $JARS FileServer.java
javac -cp $JARS FileServer.java
