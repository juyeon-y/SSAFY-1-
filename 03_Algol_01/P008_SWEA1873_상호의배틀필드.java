package 양주연;

import java.io.*;

public class P008_SWEA1873_상호의배틀필드 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferdReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		int T = Integer.parseInt(br.readLine()), tankX=-1, tankY=-1, tankIdx=-1, H, W, N; //테스트케이스 T, 전차의 현재위치 저장할 tankX, tankY, 전차 방향 인덱스 tankIdx, 높이H, 너비W, 입력개수N 선언 및 초기화.
		int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1}; //전차 이동방향 배열 생성 {위, 오른쪽, 아래, 왼쪽}
		char[] tank = {'^', '>', 'v', '<'}; //전차 문자 배열 생성 {위, 오른쪽, 아래, 왼쪽}
		for(int tc=1; tc<=T; tc++){ //테스트케이스만큼 반복
		    String[] input = br.readLine().split(" "); //한 줄 입력받음
		    H = Integer.parseInt(input[0]); //높이 입력받음
		    W = Integer.parseInt(input[1]); //너비 입력받음
		    char[][] map = new char[H][W]; //게임 맵 입력받을 이차웜 배열 map 생성
		    for(int i=0; i<H; i++){
		        String s = br.readLine();
		        for(int j=0; j<W; j++){
		            map[i][j] = s.charAt(j); //게임 맵 입력받음
		            for(int k=0; k<4; k++){
		                if(map[i][j]==tank[k]){ //전차 차리일 경우
		                    tankIdx=k; //전차 방향 인덱스 저장
		                    tankX=i; //전차 X좌표 저장
		                    tankY=j; //전차 Y좌표 저장
		                }
		            }
		        }
		    }
		    N = Integer.parseInt(br.readLine()); //입력개수 N 저장
		    String cmd = br.readLine(); //사용자가 넣은 입력 문자열에 저장
		    for(char c : cmd.toCharArray()){
		        if(c=='U'){ //입력이 Up이라면
		            tankIdx=0; //전차 방향 인덱스를 0으로 변경
		            map[tankX][tankY]=tank[tankIdx]; //게임 맵에서 전차 방향 위쪽으로 바꿈
		            int newX = tankX+dx[tankIdx]; //한 칸 위의 칸 X좌표 newX에 저장
		            int newY = tankY+dy[tankIdx]; //한 칸 위의 칸 Y좌표 newY에 저장
		            if(newX>=0 && map[newX][newY]=='.'){ //한 칸 위의 칸이 맵 범위를 벗어나지 않았고 평지라면
		                map[tankX][tankY]='.'; //원래 전차가 있던 자리를 평지로 변경
		                tankX=newX; //전차 위치 새 X좌표로 저장
		                tankY=newY; //전차 위치 새 Y좌표로 저장
		                map[newX][newY]=tank[tankIdx]; //게임 맵에서 한 칸 위의 칸으로 전차 이동
		            }
		        }
		        else if(c=='D'){ //입력이 Down이라면
		            tankIdx=2; //전차 방향 인덱스를 2로 변경
		            map[tankX][tankY]=tank[tankIdx]; //게임 맵에서 전차 방향 아래쪽으로 바꿈
		            int newX = tankX+dx[tankIdx]; //한 칸 아래의 칸 X좌표 newX에 저장
		            int newY = tankY+dy[tankIdx]; //한 칸 아래의 칸 Y좌표 newY에 저장
		            if(newX<H && map[newX][newY]=='.'){ //한 칸 아래의 칸이 맵 범위를 벗어나지 않았고 평지라면
		                map[tankX][tankY]='.'; //원래 전차가 있던 자리를 평지로 변경
		                tankX=newX; //전차 위치 새 X좌표로 저장
		                tankY=newY; //전차 위치 새 Y좌표로 저장
		                map[newX][newY]=tank[tankIdx]; //게임 맵에서 한 칸 아래의 칸으로 전차 이동
		            }
		        }
		        else if(c=='L'){ //입력이 Left이라면
		            tankIdx=3; //전차 방향 인덱스를 3으로 변경
		            map[tankX][tankY]=tank[tankIdx]; //게임 맵에서 전차 방향 왼쪽으로 바꿈
		            int newX = tankX+dx[tankIdx]; //한 칸 왼쪽의 칸 X좌표 newX에 저장
		            int newY = tankY+dy[tankIdx]; //한 칸 왼쪽의 칸 Y좌표 newY에 저장
		            if(newY>=0 && map[newX][newY]=='.'){ //한 칸 왼쪽의 칸이 맵 범위를 벗어나지 않았고 평지라면
		                map[tankX][tankY]='.'; //원래 전차가 있던 자리를 평지로 변경
		                tankX=newX; //전차 위치 새 X좌표로 저장
		                tankY=newY; //전차 위치 새 Y좌표로 저장
		                map[newX][newY]=tank[tankIdx]; //게임 맵에서 한 칸 왼쪽의 칸으로 전차 이동
		            }
		        }
		        else if(c=='R'){ //입력이 Right이라면
		            tankIdx=1; //전차 방향 인덱스를 1로 변경
		            map[tankX][tankY]=tank[tankIdx]; //게임 맵에서 전차 방향 오른쪽으로 바꿈
		            int newX = tankX+dx[tankIdx]; //한 칸 오른쪽의 칸 X좌표 newX에 저장
		            int newY = tankY+dy[tankIdx]; //한 칸 오른쪽의 칸 Y좌표 newY에 저장
		            if(newY<W && map[newX][newY]=='.'){ //한 칸 오른쪽의 칸이 맵 범위를 벗어나지 않았고 평지라면
		                map[tankX][tankY]='.'; //원래 전차가 있던 자리를 평지로 변경
		                tankX=newX; //전차 위치 새 X좌표로 저장
		                tankY=newY; //전차 위치 새 Y좌표로 저장
		                map[newX][newY]=tank[tankIdx]; //게임 맵에서 한 칸 오른쪽의 칸으로 전차 이동
		            }
		        }
		        else{ //입력이 Shoot이라면
		            int cannonX=tankX, cannonY=tankY; //포탄 위치 전차 위치로 초기화
		            while(true){ //break로 빠져나올 때까지 반복
		                cannonX = cannonX+dx[tankIdx]; //전차가 바라보는 방향의 다음 좌표로 포탄 위치 X좌표 이동
		                cannonY = cannonY+dy[tankIdx]; //전차가 바라보는 방향의 다음 좌표로 포탄 위치 Y좌표 이동
		                if(cannonX<0 || cannonX>=H || cannonY<0 || cannonY>=W) break; //포탄 위치가 맵 범위를 벗어나면 break
		                if(map[cannonX][cannonY]=='*'){ //포탄이 벽돌로 만들어진 벽에 위치하면
		                    map[cannonX][cannonY]='.'; //해당 위치 평지로 변경
		                    break; //break로 빠져나옴
		                }
		                else if(map[cannonX][cannonY]=='#') break; //포탄이 강철로 만들어진 벽에 위치하면 break로 빠져나옴
		            }
		        }
		    }
		    bw.write("#"+tc+" "); //테스트케이스 번호 출력
		    for(int i=0; i<H; i++){ 
		        for(int j=0; j<W; j++){
		            bw.write(String.valueOf(map[i][j])); //맵 출력
		        }
		        bw.write("\n");
		    }
		}
		
		br.close(); //BufferdReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}

}
