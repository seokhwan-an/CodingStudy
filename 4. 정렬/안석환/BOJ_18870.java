import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        Map<Integer, Integer> arr1 = new HashMap<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int[] check = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr2.add(num);
            check[i] = num;
        }
        Collections.sort(arr2);
        for(int i = 0; i < arr2.size(); i++){
            if(arr1.keySet().contains(arr2.get(i))){
                continue;
            }
            else{
                arr1.put(arr2.get(i),cnt++);
            }
        }
        for(int key : check) {
            System.out.print(arr1.get(key) + " ");
        }
    }
}
