package algorithm.stack;

public class stack4 {

	public static void main(String[] args) {
String command =null;
		
		command ="So when I die (the [first] I will see in (heaven) is a score list).\r\n"+
				"[ first in ] ( first out ).\r\n"+
				"Half Moon tonight (At least it is better than no Moon at all].\r\n"+
				"A rope may form )( a trail in a maze.\r\n"+
				"Help( I[m being held prisoner in a fortune cookie factory)].\r\n"+
				"([ (([( [ ] ) ( ) (( ))] )) ]).\r\n"+
				" .\r\n"+
				".\r\n";
				
				
				String command_split[] = command.split("\\r\n");
		
				
				int size =command_split.length;
				
				
				
				
				for(int i = 0;i < size;i++) {
					char stack[] = new char[command_split[i].length()];
					int point = -1;
					
					
					for(int j=0;j<command_split[i].length();j++) {
						
						if(command_split[i].charAt(j)=='(') {
							point++;
							stack[point] = '(';
						}
						else if(command_split[i].charAt(j)==')') {
							if(point>-1)
								if(stack[point]=='(') {
									point--;
								}
						}
						
						if(command_split[i].charAt(j)=='[') {
							point++;
							stack[point] = '[';
						}
						else if(command_split[i].charAt(j)==']') {
							if(point>-1)
								if(stack[point]=='[') {
									point--;
								}
						}
					}
					if(point!=-1) {
						System.out.println("NO");
					}
					else
						System.out.println("YES");
					
				}

}}

