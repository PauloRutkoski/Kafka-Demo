package com.rutkoski.consumer2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Consumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer2Application.class, args);
	}

	@KafkaListener(id = "my_topic_tests_2", topics = "${topics.test}")
	public void testsTopicListener(Message msg) {
		System.out.println("============================");
		System.out.println("FROM: " + msg.getName());
		System.out.println("MESSAGE: " + msg.getText());
		System.out.println("============================");
	}
}
