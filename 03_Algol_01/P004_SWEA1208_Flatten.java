package 양주연;

import java.io.*;
import java.util.*;

public class P004_SWEA1208_Flatten {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferdWriter 객체 생성
		int[] boxes = new int[100]; //상자의 높이값들 담을 배열 boxes 생성
		StringTokenizer st; //StringTokenizer 선언
		for(int tc=1; tc<=10; tc++){ //테스트케이스만큼 반복문 돌림
		    int dump = Integer.parseInt(br.readLine()); //덤프 횟수 입력받아 int 변수 dump에 대입
		    st = new StringTokenizer(br.readLine()); // 상자의 높이값 스페이스를 구분자로 자르기 위해 StringTokenizer 생성
    		for(int i=0; i<100; i++){ //가로 길이는 항상 100이므로 100번 반복
    		    boxes[i] = Integer.parseInt(st.nextToken()); // 상자의 높이값들 boxes 배열에 대입
    		}
    		for(int i=0; i<dump; i++){ //덤프 횟수만큼 반복
    		    Arrays.sort(boxes); //boxes배열에 담긴 상자의 높이값들 오름차순 정렬
    		    boxes[99]--; //상자의 높이 최댓값에서 -1
    		    boxes[0]++; //상자의 높이 최솟값에서 +1
    		}
    		Arrays.sort(boxes); //boxes배열에 담긴 상자의 높이값들 오름차순 정렬
    		bw.write("#"+tc+" "+(boxes[99]-boxes[0])+"\n"); //최고점과 최저점의 높이 차를 반환
		}
		br.close(); //BufferedReader 닫음
		bw.flush(); //BufferdWriter에 남은 버퍼 비움
		bw.close(); //BufferedWriter 닫음
	}
}
