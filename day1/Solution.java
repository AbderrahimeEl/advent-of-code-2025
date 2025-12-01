import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Solution{
    public static void main(String[] a) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        int result = 0, c = 50;
        for(String line : lines) {
            int nb = Integer.parseInt(line.substring(1));
                result += nb/100;
                nb = nb%100;
            if(line.charAt(0) == 'L'){
                if(c-nb<0){
                    if(c!=0)
                    result++;
                    c = 100 + c -nb;
                }
                else 
                c = c -nb;
            }
            else{
                if(c+nb >= 100){
                    c = c + nb - 100;
                    if(c!=0)
                    result++;
                }
                else
                c = c + nb;
            }
            if(c==0) result++;
        }
        System.out.println(result);
    }
}