package algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		String jooo  = sc.nextLine();
		String joo[] = jooo.split(" ");

		
		int jo[] = new int[2];
		for(int i = 0;i<joo.length;i++) {
			jo[i] = Integer.parseInt(joo[i]);
		}
		
		for(int num = 0;num<jo[0];num++) {
			queue.offer(num+1);
		}
		
		while(!queue.isEmpty()) {
			
			for(int e = 1;e<jo[1];e++) {
				queue.offer(queue.poll());
			}
			System.out.println(queue.poll());
			
		}
		
	}
	

}
