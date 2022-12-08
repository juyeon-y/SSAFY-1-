package 양주연;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P037_JO1828_냉장고 {

    static int N;
    static int[][] inputArr;

    static int refCnt;

    static ArrayList<Chem> chemLst = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        refCnt=N;

        for (int i = 0; i < N; i++) {
            String[] minmax = br.readLine().split(" ");
            chemLst.add(new Chem(Integer.parseInt(minmax[0]), Integer.parseInt(minmax[1])));
        }

        Collections.sort(chemLst); // 오름차순 정렬
        int maxT = chemLst.get(0).maxT;
        for (int i = 1; i < N; i++) {
        	int curMin = chemLst.get(i).minT;
            if(curMin<=maxT) {
            	refCnt--;
            }
            else {
            	maxT = chemLst.get(i).maxT;
            }
        }
        bw.write(refCnt+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static class Chem implements Comparable<Chem> {

        int minT;
        int maxT;

        public Chem(int minT, int maxT) {
            this.minT = minT;
            this.maxT = maxT;
        }

        @Override
        public int compareTo(Chem o) {
            return this.maxT==o.maxT ? this.minT-o.minT : this.maxT-o.maxT;
        }
    }
}

