const amqp = require('amqplib');

const consumeFromQueue = async (queueName) => {
  try {
    // Establish a connection to RabbitMQ
    const connection = await amqp.connect('amqp://localhost');
    const channel = await connection.createChannel();

    // Ensure the specified queue exists
    await channel.assertQueue(queueName);

    console.log(`[x] Listening for messages in ${queueName}`);

    // Consume messages from the queue
    channel.consume(queueName, (message) => {
      if (message !== null) {
        console.log(`[x] Message received: ${message.content.toString()}`);
        channel.ack(message); // Acknowledge the processed message
      }
    });
  } catch (err) {
    console.error('Error in consumer process:', err);
  }
};

// Example usage
consumeFromQueue('orderQueue');