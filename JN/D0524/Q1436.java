package BrouteForce_Easy;

import java.util.Scanner;

public class Q1436 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // 가능하나 어려움이 있을 수 있다.
        // 상위 버전은 가능하지만 ssafy 사무국에서 도와줄 수 없다.
        // 메뉴얼 잘 참고하라
        // 사이트 사용법 안내하기
        // 시작 시간: 안내창 뜸> ok> 문제풀기
        // 답안제출 횟수 제한 x, 종료 시간 시 제출 불가능
        // 응시 종료 버튼 클릭하면 안됌
        // 방해 금지 모드하기
        // 10분 내에 재접속 해라, 공지사항으로 안내가 온다. 손을 들고 감독관 바로 찾기
        // 핸드폰이 꺼져서 녹화를 할 수 없는 상황, 검정 불가능시 10분이내 검정시 가능함
        int num=666;
        int count=1;
        while(count!=n){
            num++;
            if(String.valueOf(num).contains("666"))
                ++count;
        }
        System.out.println(num);
    }
}
