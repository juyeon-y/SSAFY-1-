package 양주연;

import java.io.*;
import java.util.*;
public class P079_BJ17471_게리멘더링
{
    static ArrayList<ArrayList<Integer>> adjList;
    static int N, min = Integer.MAX_VALUE;
    static int[] population;
    static boolean[] selected;
    static void dfs(int lev){ //부분집합으로 두 선거구 나누는 함수
        if(lev==N+1){
            ArrayList<Integer> list1 = new ArrayList<>(); //선거구1
            ArrayList<Integer> list2 = new ArrayList<>(); //선거구2
            for(int i=1; i<=N; i++){
                if(selected[i]) list1.add(i);
                else list2.add(i);
            }
            if(list1.size()==N || list1.size()<(N+1)/2) return; //구역을 하나도 포함하고 있지 않은 선거구가 생기거나 두 선거구 조합 중복될 경우 리턴
            if(bfs(list1) && bfs(list2)){ //두 선거구에 포함되어 있는 구역들 모두 연결되어 있는 경우
                int p1=0, p2=0; 
                for(int i=1; i<=N; i++){
                    if(selected[i]) p1+=population[i];
                    else p2+=population[i];
                }
                int diff = Math.abs(p1-p2); //두 선거구에 포함된 인구의 차이 계산
                if(min>diff) min=diff; //최소값 업데이트
            }
        }else{
            selected[lev] = true; //해당 구역 선거구1에 포함 o
            dfs(lev+1);
            selected[lev] = false; //해당 구역 선거구1에 포함 x
            dfs(lev+1);
        }
    }
    static boolean bfs(ArrayList<Integer> list){ // 해당 선거구에 포함되어 있는 구역들 모두 연결되어 있는지 확인하는 함수
        boolean[] chk = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        int firstV = list.remove(0);
        q.offer(firstV);
        chk[firstV] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int x : adjList.get(tmp)){
                if(!chk[x]){
                    chk[x] = true;
                    if(list.remove(Integer.valueOf(x))) q.offer(x); //선거구에 포함된 구역일 경우에만 리스트에서 제거하고 큐에 삽입
                }
            }
        }
        if(list.size()==0) return true; //선거구에 포함된 구역들 모두 연결되어있으면 true 리턴
        else return false; //아니면 false 리턴
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		selected = new boolean[N+1];
		adjList = new ArrayList<>(); //인접리스트
		for(int i=0; i<=N; i++){
		    adjList.add(new ArrayList<>());
		}
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++){
		    population[i+1] = Integer.parseInt(input[i]);
		}
		for(int i=1; i<=N; i++){
		    input = br.readLine().split(" ");
		    int size = Integer.parseInt(input[0]);
		    for(int j=1; j<size+1; j++){
		        int v = Integer.parseInt(input[j]);
		        adjList.get(i).add(v);
		        adjList.get(v).add(i);
		    }
		}
		dfs(1); //부분집합 함수. 1번 구역부터라서 1부터 시작.
		if(min==Integer.MAX_VALUE) bw.write("-1\n"); //두 선거구로 나눌 수 없는 경우에는 -1을 출력
		else bw.write(min+"\n"); //나눌 수 있으면 최솟값 출력
		br.close();
		bw.flush();
		bw.close();
	}
}