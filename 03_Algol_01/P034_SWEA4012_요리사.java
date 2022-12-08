package 양주연;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P034_SWEA4012_요리사 {
	
	static int N;
	static int[][] sngArr;
	
	static boolean[] isSelected;
	
	static int minVal;
	
	static void permut(ArrayList<Integer> selectedIdx, ArrayList<Integer> nonSelectedIdx) { //순열
		
		int[] curSngArr = new int[2];
		
		for (int i = 0; i < selectedIdx.size(); i++) { 
			for (int j = 0; j < selectedIdx.size(); j++) {
				if (i==j) {
					continue;
				}
				curSngArr[0] += sngArr[selectedIdx.get(i)][selectedIdx.get(j)];
				 
				
			}
		}
		
		for (int i = 0; i < nonSelectedIdx.size(); i++) {
			for (int j = 0; j < nonSelectedIdx.size(); j++) {
				if (i==j) {
					continue;
				}
				
				curSngArr[1] += sngArr[nonSelectedIdx.get(i)][nonSelectedIdx.get(j)];
			}
		}
		
		int curDiff = Math.abs(curSngArr[0] - curSngArr[1]);
		
		if (minVal > curDiff) {
			minVal = curDiff;
		}

	}
	
	static void combi (int lev, int start) { //조합
		if (lev == N/2) {
			ArrayList<Integer> selectedIdx = new ArrayList<>();
			ArrayList<Integer> nonSelectedIdx = new ArrayList<>();
			
			for (int i = 0; i < isSelected.length; i++) {
				if (isSelected[i]) {
					// 골라졌으면
					selectedIdx.add(i);
				}else {
					// 안골라진 애들 자동으로 나온다
					nonSelectedIdx.add(i);
				}
			}
			permut(selectedIdx, nonSelectedIdx);
		}else {
			for (int i = start; i < N; i++) {
				isSelected[i] = true;
				combi(lev+1, i+1);
				isSelected[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// 입력: 테케, N, 배열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int cNum = 1; cNum <= TC; cNum++) {
			
			minVal = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine()); // 식재료 갯수
			
			sngArr = new int[N][N];
			isSelected = new boolean[N];
			
			//시너지 배열 받기
			for (int i = 0; i < N; i++) {
				String[] strArr = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					sngArr[i][j] = Integer.parseInt(strArr[j]);
				}
			}
			
			combi(0,0);
			
			bw.write("#"+cNum + " " + minVal+"\n");
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
