/*package com.cognizant;

public class sample2 extends Sample1 {
 static void result(Sample1 s)
 {
	 sample2 s2=(sample2)s;
	 
 }
	public static void main(String srgs[])
	{
		Sample1 s=new sample2();
		
		sample2.result(s);
	}
	}


*/
package com.cognizant;

import com.cognizant.Sample1;

public class sample2 extends Thread {
	
		public void run() {
			try {
				Sample1.Table(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}