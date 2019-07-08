package algorithm.stack;

public class stack2 {

	public static void main(String[] args) {
		
		/*
			첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
			이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
			정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
		*/
		
		String command =null;
				
		command ="10\r\n" + 
				"1\r\n" + 
				"3\r\n" + 
				"5\r\n" + 
				"4\r\n" + 
				"0\r\n" + 
				"0\r\n" + 
				"7\r\n" + 
				"0\r\n" + 
				"0\r\n" + 
				"6\r\n";
				
				
				String command_split[] = command.split("\\r\n");
		
				
				int size = Integer.parseInt(command_split[0]);
				
				int stack[] = new int[size];
				int point = -1;	
				int sum = 0;
				for(int i = 1;i <= size;i++) {
					
					if(command_split[i].equals("0") && point != -1) {
						stack[point] = 0;
						point--;
					}
					else {
						point++;
						stack[point] = Integer.parseInt(command_split[i]);								
					}
				}
				if(point != -1) {
					for(int i = 0;i<=point;i++) {
						sum +=stack[i];
						
					}
				}
				System.out.println(sum);
			
	
	
	}

}
