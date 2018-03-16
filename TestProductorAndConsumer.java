package com.jucday01;
/*
 * �����ߺ������߰���
 */
public class TestProductorAndConsumer {
public static void main(String[] args) {
	Clerk clerk=new Clerk();
	Productor pro=new Productor(clerk);
	Consumer con=new Consumer(clerk);
	new Thread(pro,"������A").start();
	new Thread(con,"������A").start();
	
	new Thread(pro,"������B").start();
	new Thread(con,"������B").start();
}
}

class Clerk{
	private int product=10;
	public synchronized void get() {
		while(product>=20) {
			System.out.println("��Ʒ����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName()+":"+ ++product);
			this.notifyAll();
		
	}
	public synchronized void sale() {
		while(product<=0) {
			System.out.println("��Ʒȱ��");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName()+":"+ --product);
			this.notifyAll();
		
	}
}
class Productor implements Runnable{
	private Clerk clerk;

	public Productor(Clerk clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.get();
		}
		
	}
	
}
class Consumer implements Runnable{
	private Clerk clerk;
	public Consumer(Clerk clerk) {
		this.clerk=clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			clerk.sale();
		}
		
	}
	
}