package 양주연;

import java.io.*;
import java.util.*;
public class P083_BJ15961_회전초밥
{
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); //벨트에 놓인 접시 수 N
		int d = Integer.parseInt(input[1]); //초밥의 가짓수 d
		int k = Integer.parseInt(input[2]); //연속해서 먹는 접시 수 k
		int c = Integer.parseInt(input[3]); //쿠폰의 초밥 번호 c
		int[] arr = new int[N];
		for(int i=0; i<N; i++){
		    arr[i] = Integer.parseInt(br.readLine());
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int size;
		//슬라이딩 윈도우
		for(int i=0; i<k; i++){ //처음 연속된 k개 일단 map에 담음
		    map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		    if(map.getOrDefault(c, 0)>0) size=map.size(); //쿠폰 초밥 먹었으면 초밥 가짓수 그대로
		    else size=map.size()+1; //쿠폰 초밥 안 먹었으면 초밥 가짓수+1
		    if(max<size) max=size; //max 업데이트
		}
	    for(int i=0; i<N-1; i++){ //담긴 연속된 k개에서 맨 앞의 하나 제거하고 k개 바로 다음의 하나 새로 추가
	        map.put(arr[(i+k)%N], map.getOrDefault(arr[(i+k)%N], 0)+1);
	        int tmp = map.getOrDefault(arr[i], 0); //맨 앞의 숫자가 저장된 k개 중에 몇 개 존재하는지 tmp에 저장.(예로 7이면 7, 9, 7, 30 에서 7은 2개)
	        if(tmp==1) map.remove(arr[i]); //한 개 존재하면 -1하면 0개이므로 map에서 remove
	        else map.put(arr[i], tmp-1); //두 개 이상 존재하면 map에서 value값-1
		    if(map.getOrDefault(c, 0)>0) size=map.size(); //쿠폰 초밥 먹었으면 초밥 가짓수 그대로
		    else size=map.size()+1; //쿠폰 초밥 안 먹었으면 초밥 가짓수+1
		    if(max<size) max=size; //max 업데이트
	    }
	    bw.write(max+"\n"); //최댓값 출력
		br.close();
		bw.flush();
		bw.close();
	}
}