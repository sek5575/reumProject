package com.kosmo.test;

class MyThread implements Runnable {//extends Thread {
	//public MyThread() {super();}
	String tname;
	public MyThread(String aa) {
		this.tname = aa;
	}
	
//	public void run() {
////		try {
//			for(int i=0; i<10; i++) {
////				Thread.sleep(500);
//				System.out.println("일하는 중...."+this.tname);
//				
//			}
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
//		
//	}
	
	@Override
	public void run() {
		try {
			for(int i=0; i<10; i++) {
				Thread.sleep(10);
				System.out.println("일하는 중...."+this.tname);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


public class Ch12TreadTest  {

	public static void main(String[] args) {
//		MyThread man1 = new MyThread("man11");
//		MyThread man2 = new MyThread("man22");
//		man1.start();
//		man2.start();
//		th.run();   XXXXXXXX
		
//		new MyThread("man11").start();  //위와 같다
		
		
//		Runnable man1 = new MyThread("man11");    //다형성
//		Thread t = new Thread(man1);
		Thread t = new Thread(new MyThread("man11"));
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
		
//		Runnable man2 = new MyThread("man22");
		Thread t2 = new Thread(new MyThread("man22"));
		t.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
		

		
		
		
		
	}

}
