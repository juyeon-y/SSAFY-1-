package 양주연;

import java.io.*;
import java.util.*;
public class P078_BJ9205_맥주마시면서걸어가기
{
    static int n;
    static ArrayList<ArrayList<Integer>> adjList; //인접리스트
    
    static class Coor{ //좌표 클래스
        int x, y;
        Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static int getManhattan(Coor c1, Coor c2){ //맨해튼 거리 구하는 함수
        return Math.abs(c1.x-c2.x)+Math.abs(c1.y-c2.y);
    }
    
    static boolean bfs(){
        boolean[] chk = new boolean[n+2];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        chk[0]=true;
        while(!q.isEmpty()){
            Integer tmp = q.poll();
            for(int i : adjList.get(tmp)){
                if(!chk[i]){
                    chk[i] = true;
                    if(i==n+1) return true; //락페 도착하면 true 리턴
                    q.offer(i);
                }
            }
        }
        return false; //락페 도착 실패하면 false 리턴
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    n = Integer.parseInt(br.readLine());
		    ArrayList<Coor> coorList = new ArrayList<>();
		    for(int i=0; i<n+2; i++){
		        String[] input = br.readLine().split(" ");
		        int x = Integer.parseInt(input[0]);
		        int y = Integer.parseInt(input[1]);
		        coorList.add(new Coor(x, y));
		    }
		    adjList = new ArrayList<>();
		    for(int i=0; i<n+2; i++) adjList.add(new ArrayList<>());
		    for(int i=0; i<n+2; i++){
		        for(int j=i+1; j<n+2; j++){
		            if(getManhattan(coorList.get(i), coorList.get(j))<=1000){
		                adjList.get(i).add(j);
		                adjList.get(j).add(i);
		            }
		        }
		    }
		    if(bfs()) bw.write("happy\n"); 
		    else bw.write("sad\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}