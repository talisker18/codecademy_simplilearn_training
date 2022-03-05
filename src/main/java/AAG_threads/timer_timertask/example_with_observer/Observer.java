package AAG_threads.timer_timertask.example_with_observer;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Observer {
	protected Subject subject;
	protected Timer timer;
	public abstract void checkCounter(int counter);
}
