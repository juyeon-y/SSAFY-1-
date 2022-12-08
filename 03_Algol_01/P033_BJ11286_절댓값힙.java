package 양주연;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P033_BJ11286_절댓값힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 양수만 넣는 pq
		PriorityQueue<Integer> nq = new PriorityQueue<>(); // 음수만 넣는 pq
		
		int N = Integer.parseInt(br.readLine());
		
		int printVal = 0 ;
		
		for (int i = 0; i < N; i++) {
			int curVal = Integer.parseInt(br.readLine());
			
			if (curVal > 0) { //양수일 때 양수pq에 삽입
				pq.add(curVal);
			}else if (curVal < 0) {
				nq.add(Math.abs(curVal)); //음수일 때 음수pq에 마이너스 떼고 절댓값으로 삽입
			} else { // 출력 구현 
				
				printVal = 0;
				
				if(pq.isEmpty() && nq.isEmpty()) {
					
					
				}else if(pq.isEmpty()) { //양수 넣어둔 pq가 비어있을 때는
					printVal = (-1)*nq.poll(); //음수 넣어둔 pq에서 꺼냄
					
					
				}else if(nq.isEmpty()) { //음수 넣어둔 pq가 비어있을 때는
					printVal = pq.poll(); //양수 넣어둔 pq에서 꺼냄
					
				}else {
					// 두 pq 다 비어있지 않을 때는
					int pqPeek = pq.peek();
					int nqPeek = nq.peek();
					
					if(pqPeek >= nqPeek) { //음수 넣어둔 pq에서 나온 최솟값이 양수 넣어둔 pq에서 나온 최솟값보다 작거나 같을 경우
						printVal = (-1)*nq.poll(); //음수 넣어둔 pq에서 꺼내 마이너스 붙여서 저장
					}else {
						printVal = pq.poll(); //양수 넣어둔 pq에서 꺼내 저장.
					}
					
				}
				
				bw.write(printVal + "\n");
			}

		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
