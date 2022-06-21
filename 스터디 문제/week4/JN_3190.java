package D0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3190 {
    static int[][] board; // 맵
    static int n, sec=0, count=400; // 맵 크기, 초, 현재 방향
    static Deque<int[]> snake=new LinkedList<>(); // 뱀의 위치 저장
    static int[] move_x={0, 1, 0, -1 }; // 뱀 이동하기, count%4=index, 오른쪽 방향은 ++, 왼쪽방향은 --
    static int[] move_y={1, 0, -1, 0};
    static Queue<int[]> move=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        board=new int[n+1][n+1]; // 입력값이 1부터 시작함
        int apple_num=Integer.parseInt(br.readLine()); // 사과의 갯수
        for(int i=0;i<apple_num;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=-1; // 사과는 -1
        }
        int move_num=Integer.parseInt(br.readLine());
        for(int i=0;i<move_num;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int second=Integer.parseInt(st.nextToken());
            String rotation=st.nextToken();
            if(rotation.equals("D")){ // 오른쪽이면 1
                move.add(new int[]{second, 1});
            }
            else if(rotation.equals("L")){ // 왼쪽이면 -1
                move.add(new int[]{second, -1});
            }
        }
        // 맨앞에 넣고, 맨뒤에서 삭제한다.
        snake.addFirst(new int[]{1,1});
        board[1][1]=1;
        // 이동
        while(true){
            // 새로 이동할 뱀의 머리
//            System.out.println("=========="+sec+"============");
//            print_board();
            int n_x=move_x[count%4]+snake.peek()[0];
            int n_y=move_y[count%4]+snake.peek()[1];

            // 범위가 맞는지?
            if(n_x>n||n_x<1||n_y>n||n_y<1)
                break;
            // 뱀이랑 안만나는지?
            if(board[n_x][n_y]==1)
                break;
            ++sec;
            // 이동한다면 사과의 여부? 있으면 먹고 그대로, 없으면 queue tail 빼기
            if(board[n_x][n_y]!=-1){
                int[] tail=snake.pollLast();
                board[tail[0]][tail[1]]=0; // 뱀을 삭제
            }
            // 이동하고 board에 1로 표시한다.
            snake.addFirst(new int[]{n_x, n_y});
            board[n_x][n_y]=1;
            // 회전해야하는지?
            int[] move_info=move.peek();
            if(move_info!=null){
                if(sec==move_info[0]){ // 회전해야하면, 회전정보 count 업데이트
                    if(move_info[1]==1) { // 오르쪽이면
                        ++count;
                    }
                    else if(move_info[1]==-1){ // 왼쪽이면
                        --count;
                    }
                    move.poll();
                }
            }
        }
        System.out.println(sec+1);

    }
//    static void print_board(){
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n;j++)
//                System.out.print(board[i][j]+" ");
//            System.out.println();
//        }
//    }
}
