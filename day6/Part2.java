import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part2{
    public static void main(String[] arg) throws IOException{

        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        int h = lines.size();
        int w = lines.get(0).split("").length;

        List<String[]> listOfNums = new ArrayList<>();

        for(int i=0; i < h-1; i++)
            listOfNums.add(lines.get(i).split(""));

        // operators 
        String[] operators = lines.get(h-1).trim().split("\\s+");
        List<String> nums = new ArrayList<>();
        
        for(int i=0; i < w; i++){
            String num = "";
            for(int j=0; j < h-1; j++){
                num += listOfNums.get(j)[i];
            }
            nums.add(num);
        }

        int c = 0;
        long res = 0;
        for(int i=0 ; i< operators.length ;i++){
            boolean isMulti = operators[i].equals("*");
            long s = isMulti ? 1 : 0;

            while(c<w && !nums.get(c).trim().equals("")){
                String curN = nums.get(c).trim();
                if(isMulti){
                    s *= Long.parseLong(curN);
                }
                else
                    s += Long.parseLong(curN);
                c++;
            }
            c++;
            res += s;
        }

        System.out.println(res);

    }
}