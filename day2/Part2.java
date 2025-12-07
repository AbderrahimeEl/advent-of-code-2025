import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part2{
    public static void main(String[] a) throws IOException{

        List<String> line = Files.readAllLines(Paths.get("input.txt"));
        
        String[] ranges = line.get(0).split(",");

        long result = 0;

        for(String range : ranges) {
            String[] nums = range.split("-");

            long firstN = Long.parseLong(nums[0]);
            long lastN = Long.parseLong(nums[1]);

            for(long i=firstN; i<=lastN; i++){
                String s_i = String.valueOf(i);
                int l = s_i.length();
                boolean invalid = false;

                for(int len=1; len <= l/2; len++){

                    if(l % len != 0) continue;

                    String sub = s_i.substring(0, len);

                    int repeat = l / len;
                    StringBuilder sb = new StringBuilder();
                    for(int r=0; r<repeat; r++) sb.append(sub);

                    if(sb.toString().equals(s_i)){
                        invalid = true;
                        break;
                    }
                }

                if(invalid){
                    result += i;
                }
            }
        }
        System.out.println(result); 
    }
}
