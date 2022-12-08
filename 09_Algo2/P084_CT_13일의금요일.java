package 양주연;

//2022년 10월 13일. 드디어 코로나가 종식되었다. 참아왔던 여행을 가려고
//하는 지영이는 불길한 13일의 금요일을 피하려 한다. 2022년10월 13일로부터
//가장 빠르게 다가오는 13일의 금요일이 있는 달을 구하시오.
//(단, 2022년 10월 13일은 오늘이니까 목요일이다.)

public class P084_CT_13일의금요일 {
    public static void main(String[] args) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int m = 9;
        int day = 4;
        while(day != 5) {
            day = (day + month[m] % 7) % 7;
            m = (m + 1) % 12;
        }
        System.out.println(m+1);
    }
}
