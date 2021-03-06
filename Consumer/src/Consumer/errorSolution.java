package Consumer;

import java.util.Stack;

public class errorSolution {
	public static void main(String[] args) {
		Stack<Character> stack=new Stack<>();
		Thread producer=new Thread(()->{
			char c;
			for(int i=0;i<10;i++) {
				c=(char)(Math.random()*26+'A');
				stack.push(c);
				System.out.println("生产："+c);
				try {
					Thread.sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		Thread consumer=new Thread(()->{
			char c;
			for(int i=0;i<10;i++) {
				c=stack.pop();
				System.out.println("消费："+c);
				try {
					Thread.sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		producer.start();
		consumer.start();
	}
}
