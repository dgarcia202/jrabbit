package com.github.dgarcia202;

/**
 * Smoke signals.
 */
public class App
{
  public static void main(String[] args)
  {
    System.out.println("Send smoke signal...");

    try
    {
      /*
      SmokeSignaler ss = new SmokeSignaler();
      boolean success = ss.send();

      System.out.println(success ? "Smoke signal sent!!!" : "Smoke signal failed :(");
      */

      Bus bus = new BusImpl("amqp://guest:guest@localhost:5672");
      bus.bind("binded.queue");
      bus.send("hola");
      bus.dispose();
    }
    catch (Exception e)
    {
      e.printStackTrace(System.out);
    }

    System.out.println("bye");
  }
}
