# Kafka-Demo

<p>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" /> 
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
<img src="https://img.shields.io/badge/Kakfa-F2F2F2?style=for-the-badge&logo=Apache&logoColor=black" />
</p>

> This project is a simple implementation of Kafka with Spring that have one producer, which send messages to one topic, and two consumers which receive these messages.

## Get Started

To run this project, it's necessary to have Docker and Java 11 installed in your computer. So, to start Kafka, run the following command in project's root folder.

    docker-compose up -d

After that, start the 3 Java projects (Producer, Consumer and Consumer2). It can be done by throught some IDE of your preference. They will be  at 8080, 8081 and 8082 ports.

Then, it's possible to test the application calling a POST requisition to the test endpoint and sending in the body the message object.

    http://localhost:8080/producer/send

    {
        "name": "Paulo",
        "text": "Hello World!"
    }

This message will be shown in both consumer services' log at the same time.
