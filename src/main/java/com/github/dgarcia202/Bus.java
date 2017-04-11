package com.github.dgarcia202;

public interface Bus
{
  public void bind(String queueName) throws Exception;

  public void send(Object message) throws Exception;

  public void dispose() throws Exception;
}
