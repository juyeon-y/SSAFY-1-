package 양주연;

import java.io.*;

public class P010_BJ11660_구간합구하기5 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferdReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		String[] input = br.readLine().split(" "); //한 줄 입력받음
		int n = Integer.parseInt(input[0]); //n입력
		int m = Integer.parseInt(input[1]); //m입력
		int[][] nums = new int[n+1][n+1]; //표에 채워져 있는 수들 저장할 nums 배열 생성
		int[][] sums = new int[n+1][n+1]; //누적합 저장할 nums 배열 생성 (ex. sums[3][3]은 (1,1)부터 (3,3)까지의 네모구간의 값을 더한 값)
		for(int i=1; i<=n; i++){
		    input = br.readLine().split(" "); //한 줄 입력받음
		    for(int j=1; j<=n; j++){
		        nums[i][j] = Integer.parseInt(input[j-1]); //표에 채워져 있는 수들 입력받음
		    }
		}
		for(int i=1; i<=n; i++){ //NXN만큼 반복
		    for(int j=1; j<=n; j++){
		        sums[i][j] = nums[i][j]+sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]; //누적합 저장
		    }
		}
		for(int i=0; i<m; i++){
		    input = br.readLine().split(" "); //한 줄 입력받음
		    int x1 = Integer.parseInt(input[0]); //x1 입력받음
		    int y1 = Integer.parseInt(input[1]); //y1 입력받음
		    int x2 = Integer.parseInt(input[2]); //x2 입력받음
		    int y2 = Integer.parseInt(input[3]); //y2 입력받음
		    int res = sums[x2][y2]-sums[x2][y1-1]-sums[x1-1][y2]+sums[x1-1][y1-1]; //(x1,y1)부터 (x2,y2)의 합 res에 저장
		    bw.write(res+"\n"); //출력
		}
		br.close(); //BufferdReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}

}
