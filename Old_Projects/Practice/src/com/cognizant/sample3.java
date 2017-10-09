package com.cognizant;
/*

class sample3 extends Thread
	{
	public void run()
	{
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Thread.currentThread().isAlive())
			{
		System.out.println("Thread started......."+i);
		}
		}
	}
	public static void main(String args[]) throws InterruptedException
	{
		sample3 s1=new sample3();
	
	s1.run();
	
	
	s1.setDaemon(false);*/
	//System.out.println(s1.MIN_PRIORITY);
		  /*s1.run();
		  s1.run();*/
//}

	/*static {
	 *  final int data;//static blank final variable  
sample3() {
	System.out.println("in c");
		// TODO Auto-generated constructor stub
	}
	  static{ data=50;
	  System.out.println("in static");}  
	  public static void main(String args[]){  
		  sample3 s=new sample3();
	    System.out.println(sample3.data);  */
	//}  


public class sample3 extends Thread {
	
	public void run() {
		try {
			Sample1.Table(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]) {
		sample2 s2=new sample2();
	 sample3 s3=new sample3();
	 s2.start();
	 s3.start();
	 
		
	}
}

