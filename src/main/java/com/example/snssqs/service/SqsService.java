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
        //sqs的队列url
        final String queueUrl = "https://sqs.us-west-2.amazonaws.com/400177586157/fanout2";
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        //这里设计的是最大值，默认是1，最大可以到10，实际返回的消息可能会小于10
        receiveMessageRequest.setMaxNumberOfMessages(10);
        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
        System.out.println("msg count = " + messages.size());

        for (Message m : messages) {
            //consume msg
            System.out.println("consuming msg = " + m.getBody().toString());
            //delete msg
            sqsClient.deleteMessage(queueUrl, m.getReceiptHandle());

        }
    }
}
