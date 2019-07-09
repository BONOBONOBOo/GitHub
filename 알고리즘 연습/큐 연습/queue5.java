package algorithm.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class queue5 {

	public static void main(String[] args) {

		String command ="10 3\r\n" + 
				"1 2 3";
		String command_split[] = command.split("\\r\n");
		String sizeAndNum[];
		
		sizeAndNum = command_split[0].split(" ");
		
		int size = Integer.parseInt(sizeAndNum[0]);
		int num = Integer.parseInt(sizeAndNum[1]);
		
		int wantInt[] = new int[num];
		String wantStrng[] = command_split[1].split(" ");
		
		ArrayList<Integer> dque = new ArrayList<Integer>();
		
		for(int i = 1;i<=size;i++) {
			dque.add(i);
		}
		
		int select = 0;
		int count=0;
		for(int i = 0;i<num;i++) {
			
			if(dque.get(0)==wantInt[select]) {
				dque.remove(0);
				count ++;
				select++;
			}
			else {
				int diff = dque.get(0)-wantInt[select];				
				if(diff < 0) {
					diff = -diff;
				}
				
				
				
				
				
				
			}
		}
	}
}











