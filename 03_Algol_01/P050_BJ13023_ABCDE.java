package 양주연;

import java.io.*;
import java.util.*;

public class P050_BJ13023_ABCDE {

	static int N;
    static boolean[] chk;
    static boolean flag = false;
    static ArrayList<ArrayList<Integer>> adjList;
    static void dfs(int v, int cnt){
        if(flag) return;
        if(cnt==4){
            flag=true;
        }
        chk[v]=true;
        for(int x : adjList.get(v)){
            if(!chk[x]){
                dfs(x, cnt+1);
                chk[x]=false;
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); //정점의 수
        int M = Integer.parseInt(input[1]); //간선의 수
        adjList = new ArrayList<>();
        for(int i=0; i<N; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        chk = new boolean[N];
        for(int i=0; i<N; i++){
            if(flag) break;
            chk = new boolean[N];
            dfs(i, 0);
        }
        if(flag) bw.write("1");
        else bw.write("0");
        br.close();
        bw.flush();
        bw.close();
	}

}
