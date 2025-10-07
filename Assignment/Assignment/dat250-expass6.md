DAT250: Software Technology Experiment Assignment 6

1. I went to install RabbitMQ as recommended in the assignment text. I downloaded through docker with this command:
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management
2. I went to the UI on the web with http://localhost:15672/, and got a cool log in. When I logged in I saw information about the server.
3. I added rabbitmq implementation to my build kts file, and made a package named "messaging", which I wanted to have my Consumer and 
Producer files (which is like the lecture examples on messages). I also added the host manually to application.properties.
4. I made the classes "PollProducer" and "PollConsumer" that looked like the lecture example, getting the localhost.
5. I also added tasks to the build.gradle.kts which linked to my classes.
6. I adjusted "createPoll" in PollManager to queue in RabbitMQ for each new poll, and gets them for each vote.
7. PollProducer connects to the server and declares queues and publishes messages to the queue while PollConsumer
declares and acknowledges the messages and processes incoming messages with subscribing to the queue. 
8. Because of my earlier code I was really confused how to make the different classes interact and have the
correct datatype. It took a lot of trial and error with syntax and impelementations (had the wrong version in gradle etc),
until I could see the results on the OverView Rabbit Page.