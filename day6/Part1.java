import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part1{
    public static void main(String[] arg) throws IOException{

        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        int h = lines.size();
        int w = lines.get(0).split("\\s+").length;

        int[][] matrix = new int[h][];

        for(int i = 0; i < h; i++){
            matrix[i] = new int[w];
        }

        for(int i = 0; i < h-1; i++){
            String[] line = lines.get(i).trim().split("\\s+");
            for(int j=0; j < w; j++){
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] operators = lines.get(h-1).trim().split("\\s+");
        
        long sum = 0;
        for(int i = 0; i < w; i++){
            boolean op = operators[i].equals("*");
            long cur = op?1L:0L;
            for(int j=0; j < h-1; j++){
                if(op){
                    cur = cur * matrix[j][i];
                }
                else
                    cur = cur + matrix[j][i];
            }
            sum += cur;
        }

        System.out.println(sum);

    }
}