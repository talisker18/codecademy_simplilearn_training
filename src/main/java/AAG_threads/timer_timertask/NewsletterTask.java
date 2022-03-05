package AAG_threads.timer_timertask;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 
 * Timer and TimerTask are java util classes used to schedule tasks in a background thread. In a few words – TimerTask is the task to perform and Timer is the scheduler.
 * 
 * */

public class NewsletterTask extends TimerTask{
	private final long duration;
	private final long startTime;
	static Timer timer = null;
	
	public NewsletterTask(final long duration) {
		this.startTime = System.currentTimeMillis();
		this.duration = duration;
	}

	//send every second a email. so the run method will be executed every second with the help of timertask
	@Override
	public void run() {
		
		if(System.currentTimeMillis() >= startTime+duration) {
			System.out.println("timer will be cancelled and thread will be killed");
			//this.cancel(); -> this will stop the run() method but not the thread. to stop the entire thread, cancel the timer instance and purge it. in the end, return
			timer.cancel();
			timer.purge();
			return;
		}
		
		System.out.println("Email sent at: " 
		          + LocalDateTime.ofInstant(Instant.ofEpochMilli(scheduledExecutionTime()), 
		          ZoneId.systemDefault()));
	}
	
	public static void main(String[] args) throws InterruptedException {
		timer = new Timer();
		NewsletterTask newsletterTask = new NewsletterTask(10000);
		timer.schedule(newsletterTask, 0, 1000); //send every second an email, for 10 seconds duration (duration of newsletterTask)
		System.out.println("test after schedule()");
	}

}
