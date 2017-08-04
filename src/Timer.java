import org.apache.commons.lang3.time.StopWatch;

public class Timer {
	
	public static void main(String args[]) throws InterruptedException
	{
		System.out.println("hello");
		
		StopWatch timer = new StopWatch();
		timer.start();
		Thread.sleep(500);
		timer.stop();
		
		double pageLoadTime_ms = timer.getTime();
	    double pageLoadTime_Seconds = pageLoadTime_ms / 1000;
	    System.out.println("Total Page Load Time in ms: " + pageLoadTime_ms + " milliseconds");
	    System.out.println("Total Page Load Time in secs: " + pageLoadTime_Seconds + " seconds");

	}
	

}
