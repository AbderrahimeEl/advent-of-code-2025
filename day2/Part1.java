import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Solution{
    public static void main(String[] a) throws IOException{

        List<String> line = Files.readAllLines(Paths.get("input.txt"));
        
        String[] ranges = line.get(0).split(",");

        long result = 0;

        for(String range : ranges) {
            String[] nums = range.split("-");

            long firstN = Long.parseLong(nums[0]);
            long lastN = Long.parseLong(nums[1]);

            for(long i = firstN; i <= lastN; i++){
                String s_i = String.valueOf(i);
                int len = s_i.length();

                if(len % 2 != 0) continue;

                int half = len / 2;
                String firstHalf = s_i.substring(0, half);
                String secondHalf = s_i.substring(half);

                if(firstHalf.equals(secondHalf)){
                    result += i;
                }
            }
        }
        System.out.println(result); 
    }
}
