package algorithm.stack;

public class stack51 {

	public static void main(String[] args) {
		String command =null;
		
		command="8\r\n" + 
				"4\r\n" + 
				"3\r\n" + 
				"6\r\n" + 
				"8\r\n" + 
				"7\r\n" + 
				"5\r\n" + 
				"2\r\n" + 
				"1\r\n" ;			
		String command_split[] = command.split("\\r\n");			
		int size = Integer.parseInt(command_split[0]);
		
		int stack[] = new int[size];
		
		int point = -1;	
		
		int start = 1;
		for(int j = 1; j<=size;j++) {
			  for(int k = start; k <= Integer.parseInt(command_split[j]); k++) {
				  point++;
				  stack[point] = k;
				  System.out.println("+");  
			  }
			  if(start < Integer.parseInt(command_split[j])) {
				  start = Integer.parseInt(command_split[j])+1;
			  }
			  point--;
			  System.out.println("-");
		}
}}
