import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        int M = Integer.parseInt(st.nextToken()); //도로의 개수
        int K = Integer.parseInt(st.nextToken()); //거리정보
        int X = Integer.parseInt(st.nextToken()); //출발도시
        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
        int[] check = new int[N+1];
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map.get(s).add(e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        int cnt = 1;
        while(!q.isEmpty()){
            int y = q.poll();
            for(int next : map.get(y)){
                if(check[next] == 0){
                    check[next] = cnt;
                }
                else{
                    if(check[next] > cnt){
                        check[next] = cnt;
                    }
                }
                q.offer(next);
            }
            cnt++;
        }
        int pr = 0;
        for(int i = 1; i <= N; i++){
            if(check[i] == K){
                System.out.println(i);
                pr++;
            }
        }
        if(pr == 0){
            System.out.println(-1);
        }
    }
}
