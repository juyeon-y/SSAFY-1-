package 양주연;

import java.io.*;

public class P006_SWEA2805_농작물수확하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수 T에 입력받음
		for(int tc=1; tc<=T; tc++){ //테스트케이스 수만큼 반복
            //농장을 위아래로 반으로 나눠서 첫줄부터 중간줄까지 더하고, 중간줄 다음줄부터 끝줄까지 더함.
		    int N = Integer.parseInt(br.readLine()), profit=0; //농장의 크기 N 입력받고, 수익 저장할 profit 변수 0으로 초기화. 
		    for(int i=0; i<=N/2; i++){ //첫줄부터 농장 중간줄까지 반복 (마름모가 1, 3, 5, 3, 1이라면 1, 3, 5로 3번 반복)
		        String tmp = br.readLine(); //농작물의 가치 한 줄 문자열로 입력받음
		        for(int j=N/2-i; j<=N/2+i; j++){ //마름모 한줄의 칸 수 동안 반복(1, 3, 5)
		            profit+=tmp.charAt(j)-48; //마름모 한줄의 농작물 가치 profit에 더함.
		        }
		    }
		    for(int i=N/2-1; i>=0; i--){ //농장 중간줄 다음 줄부터 농장 끝 줄까지 반복 (마름모가 1, 3, 5, 3, 1이라면 3, 1로 2번 반복)
		        String tmp = br.readLine(); //농작물의 가치 한 줄 문자열로 입력받음
		        for(int j=N/2-i; j<=N/2+i; j++){ //마름모 한줄의 칸 수 동안 반복(3, 1)
		            profit+=tmp.charAt(j)-48; //마름모 한줄의 농작물 가치 profit에 더함.
		        }
		    }
		    bw.write("#"+tc+" "+profit+"\n"); //수익 출력
		    
		}
		br.close(); //BufferdReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}
}
