package com.jucday01;
//Test volatile,������̵߳��ù�������,�ڴ����
public class TestJUC01 {
public static void main(String[] args) {
	ThreadDemo td=new ThreadDemo();
	new Thread(td).start();
	System.out.println("flag="+td.isFlag());
	while(true) {
		//synchronized(td) {
			if(td.isFlag()) {
				System.out.println("---+++-");
				
				break;
			}
		//}
	}
}
}

class ThreadDemo implements Runnable{
	private volatile boolean flag=false;

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag=true;
		System.out.println("flag="+isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}