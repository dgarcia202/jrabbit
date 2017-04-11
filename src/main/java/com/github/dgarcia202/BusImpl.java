package com.github.dgarcia202;

import com.rabbitmq.client.*;

public class BusImpl implements Bus
{
  private Connection connection;

  private Channel channel;

  private String bindedQueue;

  public BusImpl(String uri) throws Exception
  {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setUri(uri);
    this.connection = factory.newConnection();
    this.channel = this.connection.createChannel();
  }

  public void bind(String queueName) throws Exception
  {
    this.channel.queueDeclare(queueName, true, false, false, null);
    this.bindedQueue = queueName;
  }

  public void send(Object message) throws Exception
  {
    this.channel.basicPublish("", this.bindedQueue, null, message.toString().getBytes());
  }

  public void dispose() throws Exception
  {
    this.channel.close();
    this.connection.close();
  }
}
