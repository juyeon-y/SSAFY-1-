package 양주연;

import java.io.*;

public class P023_SWEA1861_정사각형방 {

	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1}; //이동방향 배열 {위, 오른쪽, 아래, 왼쪽}
    static int[][] rooms; //방에 적힌 숫자들 저장할 이차원 배열 rooms
    static int cnt, n; //이동한 방의 개수 저장할 cnt, 방들이 nxn으로 늘어서있다고 할 때 n값 저장할 변수 n
    
    static void dfs(int x, int y){ //dfs 메서드 (x: 현재 행, y: 현재 열)
        cnt++; //이동한 방의 개수 1 증가
        for(int i=0; i<4; i++){ //4번 반복
            int nx = x+dx[i]; //다음 이동할 방의 행 
            int ny = y+dy[i]; //다음 이동할 방의 열
            if(nx>=0 && nx<n && ny>=0 && ny<n && rooms[nx][ny]==rooms[x][y]+1){ //새 행과 열이 배열 범위 안이고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 크다면
                dfs(nx, ny); //다음 방으로 이동
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수 입력받음
		String[] input;
		for(int tc=1; tc<=T; tc++){ //테스트케이스 수만큼 반복
		    n = Integer.parseInt(br.readLine()); //방들이 nxn으로 늘어서있다고 할 때 n값 입력 받음
		    rooms = new int[n][n]; //방에 적힌 숫자들 저장할 이차원 배열 rooms nxn으로 생성
		    for(int i=0; i<n; i++){ 
		        input=br.readLine().split(" ");
		        for(int j=0; j<n; j++){ 
		            rooms[i][j] = Integer.parseInt(input[j]); //방에 적힌 숫자들 입력받음
		        }
		    }
		    int maxCnt=0, roomNum=0; //최대 이동할 수 있는 방의 개수 저장할 변수 maxCnt, 처음에 출발해야 하는 방 번호 저장할 변수 roomNum 0으로 초기화
		    for(int i=0; i<n; i++){
		        for(int j=0; j<n; j++){
		            cnt=0;
		            dfs(i,j); //i행 j열에서 출발하여 이동할 수 있는 방의 개수 세 봄
		            if(cnt>maxCnt){ //세 본 방의 개수가 maxCnt보다 클 경우
		                maxCnt=cnt; //maxCnt 업데이트
		                roomNum=rooms[i][j]; //roomNum에 i행 j열의 방 번호 저장함.
		            }
		            else if(cnt==maxCnt && roomNum>rooms[i][j]){ 
		                roomNum=rooms[i][j]; //이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 방에 적힌 수가 가장 작은 것을 roomNum에 저장함
		            }
		        }
		    }
		    bw.write("#"+tc+" "+roomNum+" "+maxCnt+"\n"); //처음에 출발해야 하는 방 번호, 최대 이동할 수 있는 방의 개수 출력
		}
	    br.close();
	    bw.flush();
	    bw.close();
	}
}
