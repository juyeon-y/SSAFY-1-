package 양주연;

import java.io.*;
import java.util.*;

public class P058_SWEA1251_하나로_프림인접리스트 {

	static class Node{
        int vertex;
        long weight;
        Node next;

        public Node(int vertex, long weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
        
        
    }
    static class Island{
        int x, y;
        
        public Island(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    // PQ에 넣을 클래스 생성
    static class Vertex implements Comparable<Vertex>{
        int no; 
        long weight;

        public Vertex(int no, long weight) {
            this.no = no;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Vertex o){
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int V = Integer.parseInt(br.readLine()); //섬의 개수
            Node[] adjList = new Node[V];
            Island[] islandList = new Island[V];
            String[] input = br.readLine().split(" ");
            for(int i=0; i<V; i++){
                islandList[i] = new Island(0,0);
                islandList[i].x = Integer.parseInt(input[i]);
            }
            input = br.readLine().split(" ");
            for(int i=0; i<V; i++){
                islandList[i].y = Integer.parseInt(input[i]);
            }
            double E = Double.parseDouble(br.readLine()); //세율
            for(int i=0; i<V; i++){
                for(int j=0; j<V; j++){
                    if(i==j) continue;
                    long xDist = Math.abs(islandList[i].x-islandList[j].x);
                    long yDist = Math.abs(islandList[i].y-islandList[j].y);
                    adjList[i] = new Node(j, xDist*xDist+yDist*yDist, adjList[i]);
                }
            }
            
            // 프림 알고리즘에 필요한 자료구조
            long[] minEdge = new long[V]; // 각 정점 입장에서 신장 트리에 포함된 정점과의 간선 비용을 최소 비용으로
            boolean[] visited = new boolean[V]; // 신장트리에 포함 여부
    
            Arrays.fill(minEdge, Long.MAX_VALUE);
    
            // 1. 임의의 시작점 처리
            minEdge[0] = 0; // 처음은 나 자신과 거리니까 제로
            long result = 0; // 최소 신장트리 비용 누적
    
            PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
            pQueue.offer(new Vertex(0, minEdge[0])); // 시작점을 큐에 넣기
    
            int cnt = 0; // 신장 트리에 추가된 정점 수
            while (true) {
                // step1. 신장 트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
                Vertex minVertex = pQueue.poll();
    
                if (visited[minVertex.no]) continue;
    
                /*
                step2. 신장트리에 추가
                 */
    
                visited[minVertex.no] = true;
                result += minVertex.weight;
                if (++cnt == V) {
                    break;
                }
    
                /*
                step3. 신장 트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은
                        정점들의 기존 최소 비용과 비교해서 갱신
    
                        신장 트리에 새롭게 추가되는 정점의 모든 인접 정점 들여다 보며 처리
                 */
    
                for (Node tmp = adjList[minVertex.no]; // 방금 찍은
                     tmp != null;
                     tmp = tmp.next) {
                    // 방문 x &&
                    if (!visited[tmp.vertex] &&
                            minEdge[tmp.vertex] > tmp.weight) {
                        minEdge[tmp.vertex] = tmp.weight; // 비용 갱신
                        pQueue.offer(new Vertex(tmp.vertex, minEdge[tmp.vertex]));
                    }
                }
            }
    
            System.out.println("#"+tc+" "+Math.round(result*E));   
        }
    }

}
