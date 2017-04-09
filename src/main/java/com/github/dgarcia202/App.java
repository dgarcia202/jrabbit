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
      SmokeSignaler ss = new SmokeSignaler();
      boolean success = ss.send();

      System.out.println(success ? "Smoke signal sent!!!" : "Smoke signal failed :(");
    }
    catch (Exception e)
    {
      e.printStackTrace(System.out);
    }

    System.out.println("bye");
  }
}
