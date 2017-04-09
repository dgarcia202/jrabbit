package com.github.dgarcia202;

import java.io.*;
import java.net.*;
import java.security.*;
import java.util.concurrent.*;

import com.rabbitmq.client.*;

/**
 * Publish a message!
 */
public class SmokeSignaler
{
  public boolean send()
    throws URISyntaxException, NoSuchAlgorithmException, TimeoutException, KeyManagementException
  {
    try
    {
      ConnectionFactory factory = new ConnectionFactory();
      factory.setUri("amqp://guest:guest@localhost:5672");

      Connection conn = factory.newConnection();
      Channel channel = conn.createChannel();

      channel.exchangeDeclare("my.test.exchange", "direct", true);
      channel.queueDeclare("my.test.queue", true, false, false, null);
      channel.queueBind("my.test.queue", "my.test.exchange", "routingKey");

      byte[] messageBodyBytes = "Hello, world!".getBytes();
      channel.basicPublish("my.test.exchange", "routingKey", null, messageBodyBytes);

      channel.close();
      conn.close();

      return true;
    }
    catch (IOException e) {
      System.out.println("Caught IOException: " + e.getMessage());
      return false;
    }
  }
}
