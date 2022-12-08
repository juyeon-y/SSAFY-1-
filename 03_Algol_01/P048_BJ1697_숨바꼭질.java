package 양주연;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 5 17

public class P048_BJ1697_숨바꼭질 {
	
	static int N, K;
	
	static boolean[] visited;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		visited = new boolean[100005];
		dist = new int[100005];

		bfs();
		
		System.out.println(dist[K]);

	}

	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		visited[N] = true;
		q.add(N);
		while(!q.isEmpty()) {
			int v = q.poll();
			if(v==K) {
				break;
			}
			
			int[] tmpArr = new int[3];
			tmpArr[0] = v+1;
			tmpArr[1] = v-1;
			tmpArr[2] = v*2;
			
			for (int curV : tmpArr) {
				// i가 방문하지 않았으면서 정상 범위(0이상 10만 이하)일때 큐에 넣는다..
				if(curV>=0 && curV<=100000 &&!visited[curV]) {
					q.add(curV); 
					dist[curV] = dist[v] + 1;
					visited[curV] = true;
				}
			}
		}
		
	}

}
