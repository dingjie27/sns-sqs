package com.example.snssqs.service;

import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqsService {
    @Autowired
    AmazonSQSClient sqsClient;

    public void consumeMsg() {
        // consume a message from sqs.
        final String queueUrl = "https://sqs.us-west-2.amazonaws.com/400177586157/fanout2";
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        receiveMessageRequest.setMaxNumberOfMessages(10);
        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
        System.out.println("queue depth = " + messages.size());

        for (Message m : messages) {
            //consume msg
            System.out.println("consuming msg = " + m.getBody().toString());

            //delete msg
            sqsClient.deleteMessage(queueUrl, m.getReceiptHandle());

        }
    }
}
