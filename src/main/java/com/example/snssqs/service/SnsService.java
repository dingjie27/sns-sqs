package com.example.snssqs.service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnsService {
    @Autowired
    AmazonSNSClient snsClient;

    public void pulishMsg() {
        // Publish a message to an Amazon SNS topic.
        final String msg = "If you receive this message, publishing a message to an Amazon SNS topic works.";
        //替换成自己sns的arn，在console或者cli中可以找到这个arn
        final String topicArn = "arn:aws:sns:us-west-2:400177586157:fanout";
        final PublishRequest publishRequest = new PublishRequest(topicArn, msg);
        final PublishResult publishResponse = snsClient.publish(publishRequest);

        // Print the MessageId of the message.
        System.out.println("MessageId: " + publishResponse.getMessageId());

    }
}
