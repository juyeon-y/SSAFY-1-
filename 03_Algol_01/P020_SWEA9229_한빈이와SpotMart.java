package 양주연;

import java.io.*;

public class P020_SWEA9229_한빈이와SpotMart {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine()); //테스트케이스 수 입력
		for(int tc=1; tc<=TC; tc++){ //테스트케이스만큼 반복
		    String[] input = br.readLine().split(" ");
		    int n = Integer.parseInt(input[0]); //과자 봉지 개수 입력
		    int m = Integer.parseInt(input[1]); //무게 합 제한 입력
		    int[] weight = new int[n]; //각 과자봉지 무게 입력받을 배열 weight 생성
		    input = br.readLine().split(" ");
		    for(int i=0; i<n; i++){
		        weight[i] = Integer.parseInt(input[i]); //각 과자봉지 무게 입력받음
		    }
		    int max=-1; //과자 봉지의 무게 합 최대 저장할 max 변수 -1로 초기화(두 과자 들고 갈 방법이 없는 경우에는 -1을 출력하므로)
		    for(int i=0; i<n; i++){ //과자 한 개 뽑음
		        for(int j=i+1; j<n; j++){ //뽑은 과자 다음부터 한 개 뽑음
		            int sum = weight[i]+weight[j]; //nC2하여 뽑은 과자 2개 무게 합함
		            if(sum<=m && max<sum) max = sum; //2개의 과자 봉지의 무게의 합이 무게 합 제한 이하이고 max보다 클 경우 max에 저장.
		        }
		    }
		    bw.write("#"+tc+" "+max+"\n"); //max(들고 다닐 수 있는 과자들의 최대 무게 합) 출력
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
