package 양주연;

import java.io.*;
import java.util.*;

public class P045_BJ1260_DFS와BFS {

	static int N, M, V;
    static int chk[];
    static int[][] adjMat;
    static StringBuilder sb;
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        chk[V]=1;
        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp+" ");
            for(int i=1; i<=N; i++){
                if(adjMat[tmp][i]==1 && chk[i]==0){
                    q.offer(i);
                    chk[i]=1;
                }
            }
        }
        
    }
	static void dfs(int v){
        chk[v]=1;
        sb.append(v+" ");
        for(int i=1; i<=N; i++){
            if(adjMat[v][i]==1 && chk[i]==0){
                chk[v]=1;
                dfs(i);
            }
        }
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
	    M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		sb = new StringBuilder();
		adjMat = new int[N+1][N+1];
		chk = new int[N+1];
		for(int i=0; i<M; i++){
		    input = br.readLine().split(" ");
		    int v1 = Integer.parseInt(input[0]);
		    int v2 = Integer.parseInt(input[1]);
		    adjMat[v1][v2]=1;
		    adjMat[v2][v1]=1;
		}
		dfs(V);
		sb.append("\n");
		chk = new int[N+1];
		bfs();
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
