package 양주연;

import java.io.*;
import java.util.*;
public class P070_SWEA5658_보물상자비밀번호

{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    String[] input = br.readLine().split(" ");
		    int N = Integer.parseInt(input[0]);
		    int K = Integer.parseInt(input[1]);
		    char[] str = br.readLine().toCharArray();
		    TreeSet<Long> set = new TreeSet<>(Collections.reverseOrder());
		    for(int i=0; i<N/4; i++){
		        for(int j=0; j<N; j+=N/4){
		            String substr = String.valueOf(str).substring(j, j+N/4); 
		            set.add(Long.parseLong(substr, 16)); //생성가능한 수 10진수로 바꿔서 TreeSet에 저장
		        }
                //회전
		        char tmp = str[N-1];
		        for(int j=N-1; j>0; j--){
		            str[j] = str[j-1];
		        }
		        str[0] = tmp;
		    }
		    Long[] answer = set.toArray(new Long[set.size()]);
		    bw.write("#"+tc+" "+answer[K-1]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}