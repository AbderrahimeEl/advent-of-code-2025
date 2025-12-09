import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part2{
    public static void main(String[] a) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        long sum = 0;

        for(String s: lines){
            String[] numbers = s.split("");
            int k = 11;
            int n = numbers.length;
            String result  = "";
            int i  = -1;

            while(i < n && k>=0){
                int idx = findNextIndex(numbers, i, n - k); 
                i = idx;
                k--;
                result += numbers[idx];
            }

            sum += Long.parseLong(result);
        }

        System.out.println(sum);

    }

    public static int findNextIndex(String[] nums, int start, int end){
        int idx = start+1;
        for(int i=start+1; i< end; i++){
            int maxN = Integer.parseInt(nums[idx]);
            int currN = Integer.parseInt(nums[i]);
            if(currN > maxN)
                idx = i;
        }
        return idx;
    }
}
