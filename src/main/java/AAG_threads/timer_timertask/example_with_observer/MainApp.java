package AAG_threads.timer_timertask.example_with_observer;

import java.util.Timer;

public class MainApp {
	
	public static void main(String[] args) {
		Subject subject = new Subject();
		Timer timer = new Timer();
		new CounterObserver(subject, timer);
		
		int maxCounter = 10;
		System.out.println("max counter will be 10");
		
		timer.schedule(new SomeTimerTask(subject, maxCounter), 0, 2000);
	}

}
