# sns-sqs
using sns+sqs to fan out
The "fanout" scenario is when an Amazon SNS message is sent to a topic and then replicated and pushed to multiple Amazon SQS queues, HTTP endpoints, or email addresses. 


In this demo, you will implement a fanout messaging scenario using Amazon Simple Notification Service (SNS) and Amazon Simple Queue Service (SQS). Messages can be pulished via http API and  "pushed" to multiple subscribers.

The architechture is as follow:

images/architecture.png


1.The demo is based on Springboot framework.
2.If you want to run the demo on EC2，pls attach role on your instance first. 
3.Pls customize the message body by adding parameters to the com.example.snssqs.controller/SnsController/snsPub. By default there is no parameter and the demo uses a hard code string as message body.
