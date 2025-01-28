const amqp = require('amqplib');

const sendMessageToQueue = async (queueName, msg) => {
  try {
    // Connect to RabbitMQ server
    const connection = await amqp.connect('amqp://localhost');
    const channel = await connection.createChannel();

    // Ensure the target queue exists
    await channel.assertQueue(queueName);

    // Send a message to the queue
    channel.sendToQueue(queueName, Buffer.from(msg));
    console.log(`[x] Message sent: ${msg}`);

    // Gracefully close the connection after a short delay
    setTimeout(() => {
      connection.close();
    }, 500);
  } catch (err) {
    console.error('Error in producer process:', err);
  }
};

// Example usage
sendMessageToQueue('orderQueue', 'Order Created');