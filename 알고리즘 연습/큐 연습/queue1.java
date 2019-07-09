package algorithm.queue;

public class queue1 {

	public static void main(String[] args) {
		/*
		push X: 정수 X를 큐에 넣는 연산이다.
		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		size: 큐에 들어있는 정수의 개수를 출력한다.
		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		*/
String command =null;
		
		command = "15\r\n" + 
				"push 1\r\n" + 
				"push 2\r\n" + 
				"front\r\n" + 
				"back\r\n" +
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
				"front";
		
		
		String command_split[] = command.split("\\r\n");

		
		int size = Integer.parseInt(command_split[0]);
		
		int stack[] = new int[size];
		int front = -1;
		int back = -1;
		for(int i = 1;i <= size;i++) {
			
			System.out.print("command_split = "+command_split[i]+"\t\n");
			
			if(command_split[i].contains("push")){
				String line[] = new String[2];
				line = command_split[i].split(" ");
				
				back++;
				if(front==-1)
					front+=1;
				
				stack[back] = Integer.parseInt(line[1]);
				
				
			}
			else if(command_split[i].contains("pop")){
				
				if(front<back) {
					System.out.println(stack[front]);
					front++;
				}
				else if(front==back) {
					System.out.println("-1");
				}
					
			}
			
			else if(command_split[i].contains("size")){
				System.out.println(back-front+1);
			}
			
			else if(command_split[i].contains("empty")){
				if(back==front) 
					System.out.println(1);
				else 
					System.out.println(0);
			}
			
			else if(command_split[i].contains("front")){
				if(front == back || front == -1) 
					System.out.println("-1");
				else
					System.out.println(stack[front]);
			}
			
			else if(command_split[i].contains("back")){
				if(back == front || back == -1) 
					System.out.println("-1");
				else
					System.out.println(stack[back]);
			}
			
		}
		
		
		
	}

}
