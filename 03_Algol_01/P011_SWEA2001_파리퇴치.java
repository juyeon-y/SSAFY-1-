package 양주연;

import java.io.*;

public class P011_SWEA2001_파리퇴치 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		int T = Integer.parseInt(br.readLine()); //테스트케이스 개수 입력
		for(int tc=1; tc<=T; tc++){ //테스트케이스만큼 반복
		    String[] input = br.readLine().split(" "); //한 줄 입력
		    int n = Integer.parseInt(input[0]); //n 입력받음
		    int m = Integer.parseInt(input[1]); //m 입력받음
		    int[][] nums = new int[n+1][n+1]; //파리의 개수 저장할 이차원 배열 nums 생성
		    int[][] sums = new int[n+1][n+1]; //파리의 누적합 저장할 이차원 배열 sums 생성
		    for(int i=1; i<=n; i++){
		        input = br.readLine().split(" ");
		        for(int j=1; j<=n; j++){
		            nums[i][j] = Integer.parseInt(input[j-1]); //파리의 개수 저장
		        }
		    }
		    for(int i=1; i<=n; i++){
		        for(int j=1; j<=n; j++){
		            sums[i][j] = nums[i][j]+sums[i][j-1]+sums[i-1][j]-sums[i-1][j-1]; //파리의 누적합 저장
		        }
		    }
		    int max=0; //죽은 파리의 최대 개수 저장할 변수 max 초기화 
		    for(int i=m; i<=n; i++){
		        for(int j=m; j<=n; j++){
		            int sum = sums[i][j]-sums[i-m][j]-sums[i][j-m]+sums[i-m][j-m]; //해당 파리채 구간의 파리합 구해 sum에 저장
		            if(max<sum) max=sum; //파리합이 max보다 크면 max 갱신
		        }
		    }
		    bw.write("#"+tc+" "+max+"\n"); //max 출력
		}
		br.close(); //BufferedReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}

}
