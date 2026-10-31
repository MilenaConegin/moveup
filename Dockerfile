#Use the Eclipse temurin alpine official image
#https://hub.docker.com/_/eclipse-tumurin
From eclipse-temurin:21-jdk-alpine

#Creat and change to the app directory
WORKDIR /app

# Copy local code to the conteiner image
COPY . ./

#Build the app
RUN chmod +x mvnw
RUN ./mvnw -DoutputFile=target/mvn-dependecy-list.log -B -DskipTests clean dependecy:list install

#Run the java app
CMD ["sh", "-c", "java -jar target/moveup-0.0.1-SNAPSHOT.jar"]
