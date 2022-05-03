package mySemaphore;

public class MySemaphore {
	
	// Counter that will tell if the thread can execute
	private int count;
	
	// Constructor
	public MySemaphore(int count) {
		this.count = count;
	}
	
	// Method in which the thread tries to acquire the lock
	// Counter is decreased
	public synchronized void acquire() {
		
		while (this.count == 0) {
		
			try {
				wait(); // Blocking call.
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
        }
        
	 	this.count--;
	}
	
	// Method in which the thread release the lock
	// Counter is increased
	public synchronized void release() {
		count++;
        notify();
	}
}
