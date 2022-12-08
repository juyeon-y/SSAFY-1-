package 양주연;

import java.io.*;
import java.util.*;
public class P080_BJ17472_다리만들기2
{
    static boolean[][] chk;
    static int N, M, islandCnt;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1}, parent;
    static int[][] map;
    static class Edge implements Comparable<Edge>{
        int v1, v2, w;
        Edge(int v1, int v2, int w){
            this.v1=v1;
            this.v2=v2;
            this.w=w;
        }
        public int compareTo(Edge e){
            return this.w-e.w;
        }
    }
    static class Coor{
        int x, y;
        Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void make(){
        parent = new int[islandCnt+1];
        for(int i=1; i<=islandCnt; i++){
            parent[i] = i;
        }
    }
    static int find(int v){
        if(parent[v]==v) return v;
        return parent[v] = find(parent[v]);
    }
    static boolean union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);
        if(v1==v2) return false;
        parent[v2] = v1;
        return true;
    }
    static void bfs(int x, int y, int num){ //섬 구분하기 쉽게 섬마다 map에 다른 숫자값(num) 저장해주는 함수.
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(x, y));
        chk[x][y] = true;
        map[x][y] = num;
        while(!q.isEmpty()){
            Coor tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !chk[nx][ny] && map[nx][ny]==1){
                    chk[nx][ny] = true;
                    map[nx][ny] = num;
                    q.offer(new Coor(nx, ny));
                }
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); //행
		M = Integer.parseInt(input[1]); //열
		map = new int[N][M];
		for(int i=0; i<N; i++){
		    input = br.readLine().split(" ");
		    for(int j=0; j<M; j++){
		        map[i][j] = Integer.parseInt(input[j]);
		    }
		}
		chk = new boolean[N][M];
		islandCnt=0;
		for(int i=0; i<N; i++){
		    for(int j=0; j<M; j++){
		        if(map[i][j]==1 && !chk[i][j]){
		            bfs(i, j, ++islandCnt);
		        }
		    }
		}
		int[][] dist = new int[islandCnt+1][islandCnt+1]; //두 섬을 연결하는 다리 길이 최솟값 저장할 배열 
		for(int i=1; i<=islandCnt; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		for(int i=0; i<N; i++){
		    for(int j=0; j<M; j++){
		        if(map[i][j]!=0){
		            int start = map[i][j]; //다리 시작하는 섬 번호
		            for(int k=0; k<4; k++){
		                int nx = i;
		                int ny = j;
		                int bridgeLen = 0;
		                while(true){
		                    nx = nx+dx[k];
		                    ny = ny+dy[k];
		                    if(nx<0 || nx>=N || ny<0 || ny>=M) break; //map 범위 벗어나면 break
		                    if(map[nx][ny]==0) bridgeLen++; //바다이면 다리길이++
		                    else if(map[nx][ny]<=start) break; //시작 섬이나, 시작 섬보다 번호 작은 다른 섬 도착하면(중복된 다리 놓는 것 피하기 위해) break;
		                    else if(map[nx][ny]>start){ //시작 섬 보다 번호 큰 다른 섬 도착하면
		                        if(bridgeLen<2) break; //다리 길이가 2 이상이 아니면 break
		                        int end = map[nx][ny]; //다리 도착하는 섬 번호
		                        if(dist[start][end]>bridgeLen) dist[start][end] = bridgeLen; //두 섬을 연결하는 다리 길이 최솟값 저장
		                        break;
		                    }
		                }
		            }
		        }
		    }
		}
		ArrayList<Edge> edgeList = new ArrayList<>(); //크루스칼 알고리즘 쓰기 위한 간선들 담을 ArrayList
		for(int i=1; i<=islandCnt; i++){
		    for(int j=i+1; j<=islandCnt; j++){
		        if(dist[i][j]!=Integer.MAX_VALUE){
		            edgeList.add(new Edge(i, j, dist[i][j]));
		        }
		    }
		}
		Collections.sort(edgeList); //간선들 오름차순 정렬
		//크루스칼
		make();
		int answer=0;
		int count=0;
		for(Edge e : edgeList){
		    if(union(e.v1, e.v2)){
		        answer+=e.w;
		        if(++count==islandCnt-1) break;
		    }
		}
		if(count==islandCnt-1) bw.write(answer+"\n"); //모든 섬을 연결하는 다리 길이의 최솟값을 출력
		else bw.write("-1\n"); //모든 섬을 연결하는 것이 불가능하면 -1을 출력
		br.close();
		bw.flush();
		bw.close();
	}
}