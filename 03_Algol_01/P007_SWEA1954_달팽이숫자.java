package 양주연;

import java.io.*;

public class P007_SWEA1954_달팽이숫자 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수 T에 입력받음
		int[] dx = {0, 1, 0, -1}; //행이동방향 배열
		int[] dy = {1, 0, -1, 0}; //열이동방향 배열
		for(int tc=1; tc<=T; tc++){
		    int N = Integer.parseInt(br.readLine()); //달팽이의 크기 N에 입력받음
		    int[][] snail = new int[N][N]; //달팽이 숫자 담을 이차원 배열 snail 생성
		    int num=1, x=0, y=0, idx=0; //1부터 시작할 변수 num, 이동방향 배열 인덱스값 담을 변수 idx, 현재 위치 담을 변수 x, y 초기화. 
		    while(num<=N*N){ //num이 N*N이 될때까지 반복
		        snail[x][y]=num++; //현재 위치에 달팽이 숫자 대입
		        if(x+dx[idx]>=N || x+dx[idx]<0 || y+dy[idx]>=N || y+dy[idx]<0 || snail[x+dx[idx]][y+dy[idx]]!=0){
		            idx=(idx+1)%4; //새로 얻어낸 위치가 이차원 배열 범위를 벗어나거나 이미 달팽이 숫자 값이 담겨있다면 방향 변경
		        }
		        x+=dx[idx]; //새 위치로 x값 업데이트
		        y+=dy[idx]; //새 위치로 y값 업데이트
		    }
		    bw.write("#"+tc+"\n"); //#과 테스트케이스 번호 출력
		    for(int i=0; i<N; i++){
		        for(int j=0; j<N; j++){
		            bw.write(snail[i][j]+" "); //달팽이 숫자 출력
		        }
		        bw.write("\n");
		    }
		}
		br.close(); //BufferedReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}
}
