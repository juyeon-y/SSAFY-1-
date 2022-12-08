package 양주연;

import java.io.*;

public class P009_BJ11659_구간합구하기4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferdReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		String[] input = br.readLine().split(" "); //한 줄 입력받음
		int n = Integer.parseInt(input[0]); //n입력
		int m = Integer.parseInt(input[1]); //m입력
		int[] sums = new int[n+1]; //누적합을 저장할 배열 생성 (ex. sums[3]는 1번, 2번, 3번 숫자를 합해놓은 누적합)
		input = br.readLine().split(" "); //한 줄 입력받음
		int sum=0; //누적합 저장할 sum변수
		for(int i=0; i<n; i++){ //n개의 수만큼 반복
		    sum+=Integer.parseInt(input[i]); //1번부터 누적합 계산
		    sums[i+1]=sum; //누적합 저장
		}
		for(int i=0; i<m; i++){ //m개의 줄만큼 반복
		    input = br.readLine().split(" "); //한 줄 입력받음
		    int from = Integer.parseInt(input[0]); //구간 i를 from 변수에 입력받음
		    int to = Integer.parseInt(input[1]); //구간 j를 to 변수에 입력받음
		    bw.write((sums[to]-sums[from-1])+"\n"); //누적합의 차로 구간합 구함(ex. 2번부터 4번까지의 누적합은 sums[4]-sums[2-1])
		}
		br.close(); //BufferdReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}

}
