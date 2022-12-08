package 양주연;

import java.io.*;
import java.util.*;

public class P005_SWEA1210_Ladder1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferdReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		int[][] map = new int[100][100]; //100 x 100 크기의 2차원 배열로 주어진 사다리값 담을 2차원 배열 생성
		StringTokenizer st; //StringTokenizer 선언
		for(int tc=1; tc<=10; tc++){ //10개의 테스트케이스만큼 반복
		    int curX=-1, curY=-1; //도착점에서부터 시작해서 사다리를 타고 올라갈건데 현재 위치를 curX, curY라는 변수에 저장할 예정. 둘 다 -1로 초기화.
		    int tcNum = Integer.parseInt(br.readLine()); //테스트 케이스의 번호 입력받아 tcNum에 저장.
		    for(int j=0; j<100; j++){ //100X100이므로 100번 반복. 문제에서 행과 열이 바뀌어 주어져있으므로 j먼저.
		        st = new StringTokenizer(br.readLine()); //100X100 사다리의 한 줄 StringTokenizer에 입력받음
		        for(int i=0; i<100; i++){ //100X100이므로 100번 반복
		            map[i][j] = Integer.parseInt(st.nextToken()); //map이라는 이차원 배열 변수에 사다리 값 입력받은 것 저장
		            if(map[i][j]==2){ //값이 2일 경우 도착점 위치이므로 curX, curY에 도착점의 좌표를 저장해둠.
		                curX=i;
		                curY=j;
		            }
		        }
		    }
		    while(curY>0){ //curY>0일 동안 반복(도착점부터 시작해서 위로 쭉 올라가다 시작점에 도착하면 반복이 끝남)
		        if(curX-1>0 && map[curX-1][curY]==1){ //왼쪽에 길이 있을 경우
		            while(curX-1>0 && map[curX-1][curY]!=0){ //길이 끝날때까지 쭉 왼쪽으로 이동
		                curX--;
		            }
		            curY--; //한칸 위로 이동
		        }
		        else if(curX+1<100 && map[curX+1][curY]==1){ //오른쪽에 길이 있을 경우
		            while(curX+1<100 && map[curX+1][curY]!=0){ //길이 끝날때까지 쭉 오른쪽으로 이동
		                curX++;
		            }
		            curY--; //한칸 위로 이동
		        }
		        else{
		            curY--; //한칸 위로 이동
		        }
		    }
		    bw.write("#"+tc+" "+curX+"\n"); //시작점의 X좌표 출력
		}
		br.close(); //BufferedReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}
}
