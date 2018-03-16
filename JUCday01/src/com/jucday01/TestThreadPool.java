package com.jucday01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * �̳߳� ���ṩһ���̶߳��У������б��������еȴ�״̬���̣߳������˴��������ٵĶ��⿪���������Ӧ���ٶ�
 * 
 * ��ϵ�ṹ
 * java.util.concurrent.Executor�������̳߳ص�ʹ�ú͵��ȵĸ����
 * ---**ExecutorService �ӽӿڣ��̳߳ص���Ҫ�ӿ�
 * ---**ThreadPoolExecutor :�̳߳ص�ʵ����
 * ---** ScheduledExecutorService���ӽӿڣ������̵߳ĵ���
 * ----** ScheduledThreadPoolExecutor���̳С�ThreadPoolExecutor��ʵ��ScheduledExecutorService
 * 
 * ������Executors
 * ExecutorService newFixedThreadPool() :�����̶���С���̳߳�
 * ExecutorService newCachedThreadPool() :�����̳߳�
 * ExecutorService newSingleThreadPool() :�����������̳߳�
 * 
 * ExecutorService newScheduledThreadPool() :�����̶���С���̳߳أ������ӳٻ�ʱִ������
 */
public class TestThreadPool {
  public static void main(String[] args) {
		//1�����̳߳�
		ExecutorService pool=Executors.newFixedThreadPool(5);
//		
//		ThreadPoolDemo tpd=new ThreadPoolDemo();
//	
//		//2��Ϊ�̳߳����̵߳ķ�������
//		for(int i=0;i<10;i++) {
//			pool.submit(tpd);
//		}
//		
//		//3�ر��̳߳�
//		pool.shutdown();
	  
		Future<Integer> future=pool.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum=0;
				for(int i=0;i<=100;i++) {
					sum+=i;
				}
				return sum;
			}
			
		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
class ThreadPoolDemo implements Runnable{
	private int i=0;
	


	@Override
	public void run() {
		while(i<=100) {
			System.out.println(Thread.currentThread().getName()+":"+i++);
		}
	}
	
}
