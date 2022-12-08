package 양주연;

import java.io.*;

public class P024_BJ2563_색종이 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //색종이의 수 입력받음
		String[] input;
		int[][] paper = new int[101][101]; //흰색 도화지 영역만큼의 이차원 배열 생성
		for(int cp=0; cp<n; cp++){ //색종이 수만큼 반복
		    input = br.readLine().split(" ");
		    int x = Integer.parseInt(input[0]); //색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리 입력받음
		    int y = Integer.parseInt(input[1]); //색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리 입력받음
		    for(int i=x+1; i<=x+10; i++){
		        for(int j=y+1; j<=y+10; j++){
		            paper[i][j]=1; //색종이를 붙인 영역일 경우 흰생 도화지 이차원 배열에서의 해당 좌표에 1을 저장함 
		        }
		    }
		}
		int area=0; //검은색 영역의 넓이 저장할 변수 area를 0으로 초기화
		for(int i=1; i<=100; i++){
		    for(int j=1; j<=100; j++){
		        if(paper[i][j]==1) area++; //만약 해당 좌표에 저장된 값이 1일 경우 area++
		    }
		}
		bw.write(area+"\n"); //검은색 영역의 넓이 출력
	    br.close();
	    bw.flush();
	    bw.close();
	}

}
