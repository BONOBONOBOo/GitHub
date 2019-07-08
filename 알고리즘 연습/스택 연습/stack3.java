package algorithm.stack;

public class stack3 {

	public static void main(String[] args) {

		/*
		출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다. 
		*/
		String command =null;
		
		command ="6\r\n" + 
				"(())())\r\n" + 
				"(((()())()\r\n" + 
				"(()())((()))\r\n" + 
				"((()()(()))(((())))()\r\n" + 
				"()()()()(()()())()\r\n" + 
				"(()((())()(\r\n";
				
				
				String command_split[] = command.split("\\r\n");
		
				
				int size = Integer.parseInt(command_split[0]);
				
				int stack[] = new int[size];
				
				boolean tt = false;
				for(int i = 1;i <= size;i++) {
					int point = -1;	
					
					for(int j = 0;j<command_split[i].length();j++) {
						
						if(command_split[i].length()%2 != 0) {
							tt = true;
							break;
						}
						
						if(command_split[i].charAt(j)=='(') {
							point++;							
						}
						else if(command_split[i].charAt(j)==')') {
							point--;							
						}
						System.out.print(point+"\t");
					}
					if(tt == false) {
						if(point == -1) {
							System.out.println("YES");
						}
						else {
							System.out.println("NO");
						}
					}
					else {
						tt = false;
						System.out.println("NO");
					}
					
					
				}
				

	}

}
