package com.threading;

class MyThread extends Thread
{
	public void run()
	{
		for(int i = 1 ; i< 5 ; i++)
		{
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(500); // it throws Unhandled exception type InterruptedException and it is checked exception so we need to handle it 
			}catch(InterruptedException e)
			{
				System.out.println("Thread interrupted!");
			}
			  
		}
	}
}

public class Program {
public static void main(String[] args) {
	MyThread t1 = new MyThread();
	MyThread t2 = new MyThread();
	
	t1.setName("Thread - Onkar");
    t2.setName("Thread - Akash");
	
	t1.start();
	t2.start();
	
	System.out.println("Main thread completed");
}
}
