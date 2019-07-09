package algorithm.queue;

import java.util.ArrayList;

public class queue4 {

	public static void main(String[] args) {
		
		ArrayList<Integer> dque = new ArrayList<Integer>();
		String command =null;
		
		command = "15\r\n" + 
				"push_back 1\r\n" + 
				"push_front 2\r\n" + 
				"front\r\n" + 
				"back\r\n" + 
				"size\r\n" + 
				"empty\r\n" + 
				"pop_front\r\n" + 
				"pop_back\r\n" + 
				"pop_front\r\n" + 
				"size\r\n" + 
				"empty\r\n" + 
				"pop_back\r\n" + 
				"push_front 3\r\n" + 
				"empty\r\n" + 
				"front";
		
		
		String command_split[] = command.split("\\r\n");

		
		int size = Integer.parseInt(command_split[0]);
		
		for(int i = 1;i <= size;i++) {
			
			//System.out.print("command_split = " + command_split[i]+"\t\n");
			
			if(command_split[i].contains("push_back")){
				String line[] = new String[2];
				line = command_split[i].split(" ");
				
				dque.add(Integer.parseInt(line[1]));
			}
			else if(command_split[i].contains("pop_back")){
				String line[] = new String[2];
				line = command_split[i].split(" ");
				
				
				if(dque.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(dque.get(dque.size()-1));
					dque.remove(dque.size()-1);
				}
				
				
			}
			
			
			else if(command_split[i].contains("push_front")){
				String line[] = new String[2];
				line = command_split[i].split(" ");
				dque.add(0,Integer.parseInt(line[1]));
			}
			else if(command_split[i].contains("pop_front")){
				String line[] = new String[2];
				line = command_split[i].split(" ");
				
				if(dque.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(dque.get(0));
					dque.remove(0);
				}
				
			}
			
			else if(command_split[i].contains("size")){
				System.out.println(dque.size());
			}
			
			else if(command_split[i].contains("empty")){
				if(dque.size()==0) {
					System.out.println(1);
				}
				else
					System.out.println(0);
			}
			
			else if(command_split[i].contains("front")){
				if(dque.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(dque.get(0));
				}
			}
			else if(command_split[i].contains("back")){
				if(dque.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(dque.get(dque.size()-1));
				}
			}
			
		}


	}

}
