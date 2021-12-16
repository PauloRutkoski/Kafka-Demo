package com.rutkoski.consumer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableKafka
public class ConsumerApplication {

	@Value(value = "${topics.test}")
	private String topicName;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@KafkaListener(id = "my_topic_tests", topics = "${topics.test}")
	public void testsTopicListener(Message msg) {
		System.out.println("============================");
		System.out.println("FROM: " + msg.getName());
		System.out.println("MESSAGE: " + msg.getText());
		System.out.println("============================");
	}
}
