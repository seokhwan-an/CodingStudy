
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21918 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String 읽기
        String s = br.readLine();
        // 공백 단위로 데이터를 가공하고자 StringTokenizer 사용한다.
        StringTokenizer st = new StringTokenizer(s);
        // N개의 전구
        int N = Integer.parseInt(st.nextToken());
        // M개의 명령
        int M = Integer.parseInt(st.nextToken());
        // 상태
        int[] status = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            status[i] = Integer.parseInt(st.nextToken());
        }
        // 명령
        int[][] command = new int[M][3];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                command[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1 i x : i번째 전구의 상태를 x로 변경
        // 2 l r : l~r 번째까지의 전구의 상태를 변경한다
        // 3 l r : l~r 번째까지의 전구를 끈다.
        //4 l r : l~r번째까지의 전구를 킨다.


        int index = 0;
        while(true){
            if(index >=M) break;
            switch(command[index][0]){
                case 1:
                    status[command[index][1]-1] = command[index][2];
                    break;
                case 2:
                    for(int i=command[index][1]-1; i<=command[index][2]-1;i++){
                        status[i] = turn(status[i]);
                    }
                    break;
                case 3:
                    for(int i=command[index][1]-1; i<=command[index][2]-1;i++){
                        status[i] = 0;
                    }
                    break;
                case 4:
                    for(int i=command[index][1]-1; i<=command[index][2]-1;i++){
                        status[i]=1;
                    }
                    break;
            }
            index ++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i< status.length; i++){
            bw.write(String.valueOf(status[i]));
            bw.write(" ");
        }
        bw.flush();

    }
    public static int turn(int s){
        if(s==0) return 1;
        else return 0;
    }
}
