package algorithm.queue;

import java.util.Deque;
import java.util.Scanner;

public class queue2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();		
		
		int dqueue[] = new int[size];
		int copy[] = new int[size];
		int front = 0;
		int back = size-1;
		int tmp = 0;
		
		for( int i = size; i>0; i--) {
			dqueue[size-i] = i;
			copy[size-i] = i;
		};
				
		while(true) {
			if(front == back) {
				System.out.println(dqueue[back]);
				break;
			}
			else {
				back--;
				tmp = dqueue[back];
				for(int p = back;p>0;p--) {
					dqueue[p] = dqueue[p-1];
				}
				dqueue[front] = tmp;
				
			}
		}
	}
}
