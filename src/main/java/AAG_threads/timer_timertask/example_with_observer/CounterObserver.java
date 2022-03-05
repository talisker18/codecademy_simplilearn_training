package AAG_threads.timer_timertask.example_with_observer;

import java.util.Timer;

public class CounterObserver extends Observer{
	
	public CounterObserver(Subject subject, Timer timer) {
		super.subject = subject;
		super.timer = timer;
		super.subject.attach(this);
	}

	@Override
	public void checkCounter(int maxCounter) {
		if(super.subject.getCounter() == maxCounter) {
			System.out.println("maxCounter = "+maxCounter+" reached. timer will be cancelled and app will be terminated");
			super.timer.cancel();
			super.timer.purge();
		}
		
	}

}
