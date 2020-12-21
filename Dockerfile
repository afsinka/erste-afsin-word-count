#TODO not done, try to remove spotify-plugin
FROM maven
WORKDIR /usr/src/app
COPY . /usr/src/app
#RUN mvn -B -f /usr/src/app/pom.xml -s /usr/share/maven/ref/settings-docker.xml
RUN mvn clean install
#
#FROM adoptopenjdk/openjdk11:alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} /app/app.jar
#CMD ["mvn clean package"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/src/app/target/erste-afsin-1-1.0-SNAPSHOT.jar"]

