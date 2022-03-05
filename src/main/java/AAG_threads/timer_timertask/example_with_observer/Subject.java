package AAG_threads.timer_timertask.example_with_observer;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private int counter;
	
	public int getCounter() {
	      return counter;
   }

   public void increaseCounter(int maxCounter) {
	   System.out.println("from subject.class: counter = "+counter+" will be increased");
      this.counter++;
      notifyAllObservers(maxCounter);
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(int maxCounter){
      for (Observer observer : observers) {
    	  observer.checkCounter(maxCounter);
      }
   } 

}
