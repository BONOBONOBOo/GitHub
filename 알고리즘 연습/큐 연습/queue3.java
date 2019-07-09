package algorithm.queue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class queue3 {

	public static void main(String[] args) {
		/*
			첫 줄에 test case의 수가 주어진다.
			각 test case에 대해서 문서의 수 N(100이하)와 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue의 어떤 위치에 있는지를 알려주는 M(0이상 N미만)이 주어진다.
			다음줄에 N개 문서의 중요도가 주어지는데, 중요도는 1 이상 9 이하이다.
			중요도가 같은 문서가 여러 개 있을 수도 있다. 위의 예는 N=4, M=0(A문서가 궁금하다면), 중요도는 2 1 4 3이 된다.
		*/
		
		String command =null;
		
		
		
		command ="3\r\n"+ 
				"1 0\r\n"+ 
				"5\r\n"+ 
				"4 2\r\n"+ 
				"1 2 3 4\r\n"+ 
				"6 0\r\n"+ 
				"1 1 9 1 1 1";
				
				
				String command_split[] = command.split("\\r\n");
		
				
				int size = Integer.parseInt(command_split[0]);
				for(int i = 0;i<size;i++) {
					int count = 0;
					String want=" ";//원하는 값
					int forSize = 0;//사이즈
					Queue<HashMap<String, Integer>> queue = new LinkedList<HashMap<String,Integer>>();//큐
					
					
					int important[] = new int[10];//중요도
					
					
					for(int k = (i*2)+1;k<=(i*2)+2;k++) {
						//System.out.println(command_split[k]);
						if(k%2==1) {//첫줄
							String com[] = command_split[k].split(" ");
							forSize = Integer.parseInt(com[0]);//사이즈
							want = com[1];//원하는 노드 번호
		
							//System.out.print("forSize = "+ forSize);
							//System.out.println("  want = "+want);
						}
						else if (k%2==0) {//두번째 줄 중요도
							String importantS[] = command_split[k].split(" ");//중요도 나누기
							for(int t = 0;t<importantS.length;t++) {
								HashMap<String, Integer> node = new HashMap<String, Integer>();//중요도와 노드 번호를 담을 해쉬맵
								important[Integer.parseInt(importantS[t])]++;
								node.put(t+"", Integer.parseInt(importantS[t]));//노드에 값 넣기
								
								queue.add(node);//큐에 노드 넣기
							}
						}
					}
					int rank = 0;
					int rankStart = 0;
					while(!queue.isEmpty()){ //무한히 반복할 와일문 내부에 우선순위를 정할 와일문 넣기
						
						//System.out.println("무한루프 어디서 걸리노");
						
				/*
				 * System.out.println("중요도 배열"); for(int le = 0;le<important.length;le++) {
				 * System.out.printf("important[%d] = %d\n",le,important[le]); }
				 */
						
						
						
						for(rankStart=9;rankStart>0;rankStart--) {//우선순위를 정했음
							if(important[rankStart]>0) {
								rank=rankStart;
								//System.out.println("rank = "+rank);
								break;
							}
						}
						
						Set<String> pp = queue.peek().keySet();
						Iterator<String> ppp = pp.iterator();
						String key = ppp.next();
						//System.out.println("want = "+want);
						
						
						Collection<Integer> tt = queue.peek().values();
						Iterator<Integer> ttt = tt.iterator();
						int value = ttt.next();
						
						//System.out.println("key = "+key);
						//System.out.println("node value = "+value);
						
						if(rank==value) {
							if(key.equals(want)) {
								count++;
								break;
							}
							queue.poll();
							count ++;
							important[rankStart]--;
						}
						else {
							queue.offer(queue.poll());
						}
						
					}

			/*
			 * System.out.println("중요도 배열"); for(int le = 0;le<important.length;le++) {
			 * System.out.printf("important[%d] = %d\n",le,important[le]); }
			 */
					System.out.println(count+"번째로 나옴");
					
			/* System.out.println("============================="); */
					
					
				}
	}

}
