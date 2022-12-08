package 양주연;

import java.io.*;
import java.util.*;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1; tc<=10; tc++){ //테스트케이스 수만큼 반복
		    int n = Integer.parseInt(br.readLine()); //원본 암호문의 길이 입력받음
		    String[] input = br.readLine().split(" "); 
		    LinkedList<Integer> list = new LinkedList<>(); //암호문 저장할 LinkedList 생성
		    for(int i=0; i<n; i++){
		        list.add(Integer.parseInt(input[i])); //LinkedList에 원본 암호문 저장
		    }
		    n = Integer.parseInt(br.readLine()); //명령어의 개수 입력받음
		    input = br.readLine().split(" ");
		    int idx=-1; 
		    for(int i=0; i<n; i++){ //명령어의 개수만큼 반복
		        idx++; //I 부분 건너뜀
		        int x = Integer.parseInt(input[++idx]); //x 입력받음
		        int y = Integer.parseInt(input[++idx]); //y 입력받음
		        for(int j=0; j<y; j++){ //y개만큼 반복
		            list.add(x++, Integer.parseInt(input[++idx])); //LinkedList에서 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입
		        }
		    }
		    bw.write("#"+tc+" "); 
		    for(int i=0; i<10; i++){
		        bw.write(list.get(i)+" "); //수정된 암호문의 처음 10개 항을 출력
		    }
		    bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
