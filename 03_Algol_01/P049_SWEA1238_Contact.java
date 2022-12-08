package 양주연;

import java.util.*;
import java.io.*;

public class P049_SWEA1238_Contact {

	static int[] dist;
    static boolean[] chk;
    static int[][] adjMat;
    static void bfs(int startV){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startV);
        chk[startV]=true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=1; i<adjMat[tmp].length; i++){
                if(adjMat[tmp][i] == 1 && !chk[i]){
                    chk[i]=true;
                    q.offer(i);
                    dist[i] = dist[tmp]+1;
                }
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1; tc<=10; tc++){
		    String[] input = br.readLine().split(" ");
    		int dataLen = Integer.parseInt(input[0]);
    		int startV = Integer.parseInt(input[1]);
    		adjMat = new int[101][101];
    		input = br.readLine().split(" ");
    		for(int i=0; i<input.length; i+=2){
    		    int from = Integer.parseInt(input[i]); 
    		    int to = Integer.parseInt(input[i+1]); 
    		    adjMat[from][to] = 1;
    		}
    		dist = new int[101];
    		chk = new boolean[101];
    		bfs(startV);
    		int max=0, maxIdx=0;
    		for(int i=1; i<dist.length; i++){
    		    if(dist[i]>=max){
    		        max = dist[i];
    		        maxIdx = i;
    		    }
    		}
    		bw.write("#"+tc+" "+maxIdx+"\n");
		}
		br.close(); 
		bw.flush(); 
		bw.close(); 
	}

}
