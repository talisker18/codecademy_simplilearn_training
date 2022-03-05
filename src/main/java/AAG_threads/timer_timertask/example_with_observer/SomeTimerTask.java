package AAG_threads.timer_timertask.example_with_observer;

import java.util.TimerTask;

public class SomeTimerTask extends TimerTask{
	
	private Subject subject;
	private int maxCounter;
	
	public SomeTimerTask(Subject subject, int maxCounter) {
		this.subject=subject;
		this.maxCounter=maxCounter;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.subject.increaseCounter(maxCounter);
		
	}

}
