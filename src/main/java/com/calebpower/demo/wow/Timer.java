package com.calebpower.demo.wow;

import java.util.concurrent.atomic.AtomicReference;

/**
 * A timer that executes an array of actions repeatedly until interrupted.
 * 
 * @author Caleb L. Power
 */
public class Timer implements Runnable {
  
  private AtomicReference<Thread> thread = new AtomicReference<>();
  private Runnable[] actions = null;
  private long delay;
  
  /**
   * Instantiates a timer.
   * 
   * @param delay the number of seconds to wait before repeating
   * @param actions an array of actions to execute
   */
  public Timer(int delay, Runnable... actions) {
    this.delay = delay * 1000L; // 1000ms = 1s
    this.actions = actions;
  }
  
  /**
   * Starts the timer if the timer is not already started.
   */
  public void start() {
    if(null == thread.get()) {
      Thread thread = new Thread(this);
      thread.setDaemon(false);
      this.thread.set(thread);
      thread.start();
    }
  }
  
  /**
   * Stops the timer if the timer has not already stopped.
   */
  public void stop() {
    Thread thread = null;
    if(null != (thread = this.thread.get())) {
      thread.interrupt();
      this.thread.set(null);
    }
  }
  
  @Override public void run() {
    try {
      Thread thread = this.thread.get();
      while(!thread.isInterrupted()) {
        for(Runnable action : actions)
          action.run(); // sequentially execute in this thread -- does not fork
        Thread.sleep(delay);
      }
    } catch(InterruptedException e) { }
  }
  
}
