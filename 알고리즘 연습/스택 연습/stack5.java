package algorithm.stack;

public class stack5 {

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
				int i=1;
				int num=1;
				
				
				
				boolean togle = true;
	
				/*
				while(true) {
					if(togle == true) { 
						point++; 
						stack[point] = num;
						num++;
						System.out.println("+"); 
						}
					if(Integer.parseInt(command_split[i])==stack[point]) {
						i++; point--;
					System.out.println("-"); 
					togle = false; 
					}
					else { 
						togle =true;
					}
					if(num==size) {
						break;
					}
				}
				*/
				
				
				
			
		
		  for(int j = 1; j<=size;j++) {
			  for(int k = 0;k<Integer.parseInt(command_split[j]);k++) {
				  
			  }
			 
		  }
		 
					
					
	}

}
