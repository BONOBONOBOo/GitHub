package algorithm.stack;

import java.util.Scanner;

public class stack1 {

	public static void main(String[] args) {
		/*
		push X: 정수 X를 스택에 넣는 연산이다.
		pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		size: 스택에 들어있는 정수의 개수를 출력한다.
		empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
		top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.   
		*/
				
		String command =null;
		
		command = "14\r\n" + 
				"push 1\r\n" + 
				"push 2\r\n" + 
				"top\r\n" + 
				"size\r\n" + 
				"empty\r\n" + 
				"pop\r\n" + 
				"pop\r\n" + 
				"pop\r\n" + 
				"size\r\n" + 
				"empty\r\n" + 
				"pop\r\n" + 
				"push 3\r\n" + 
				"empty\r\n" + 
				"top";
		
		
		String command_split[] = command.split("\\r\n");

		
		int size = Integer.parseInt(command_split[0]);
		
		int stack[] = new int[size];
		int point = -1;	
		for(int i = 1;i <= size;i++) {
			
			//System.out.print("command_split = "+command_split[i]+"\t\n");
			
			if(command_split[i].contains("push")){
				String line[] = new String[2];
				line = command_split[i].split(" ");
				point++;
				stack[point] = Integer.parseInt(line[1]);
				
				
			}
			else if(command_split[i].contains("pop")){
				
				if(point>-1) {
					System.out.println(stack[point]);
					point--;
				}
				else if(point==-1) {
					System.out.println(point);
				}
					
			}
			else if(command_split[i].contains("size")){
				System.out.println(point+1);
			}
			else if(command_split[i].contains("empty")){
				if(point==-1) 
					System.out.println(1);
				else 
					System.out.println(0);
			}
			else if(command_split[i].contains("top")){
				if(point==-1)
					System.out.println(point);
				else
					System.out.println(stack[point]);
			}
			
		}

	}

}
