package algorithm.stack;

import java.util.Stack;

public class stack6 {

	public static void main(String[] args) {
String command =null;
		
		command="4\r\n" + 
				"3\r\n" + 
				"5\r\n" + 
				"2\r\n" + 
				"7\r\n";	
		
		String command_split[] = command.split("\\r\n");			
		int size = Integer.parseInt(command_split[0]);
		int int_split[] = new int[size];
		
		for(int p = 0;p <size;p++) {		
			int_split[p] = Integer.parseInt(command_split[p+1]);
		}
			  for(int i = 0;i<size;i++) {
				  
				  Stack<Integer> stack = new Stack();
				  
				  for(int j = size-1; j>i ;j--) {					 
					  if(int_split[i] < int_split[j]) {
						  stack.push(int_split[j]);
					  }
				  }
				  if(stack.empty()) {
					  System.out.println("-1");
				  }
				  else {
					  System.out.print(stack.pop()+"\t");
					}
				  }
}}
