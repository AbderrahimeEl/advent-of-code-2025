import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part2{
    public static void main(String[] a) throws IOException{

        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        int n =  lines.size();
        int m =  lines.get(0).length();

        char[][] result = readMatrixAndAddPoints(lines);

        int toRemove = 0;
        while(true){
            List<int[]> pairs = new ArrayList<>();
            for(int i=1; i< n+1; i++){
                for(int j=1; j < m+1; j++){

                    if(result[i][j] == '.')
                    continue;

                    int c = 0;
                    if(result[i-1][j-1] == '@') c++;
                    if(result[i+1][j+1] == '@') c++;
                    if(result[i][j-1] == '@') c++;
                    if(result[i-1][j] == '@') c++;
                    if(result[i+1][j] == '@') c++;
                    if(result[i][j+1] == '@') c++;
                    if(result[i-1][j+1] == '@') c++;
                    if(result[i+1][j-1] == '@') c++;

                    if(c<4){
                        toRemove++;
                        pairs.add(new int[]{i,j});
                    }
                }
            }

            if(pairs.size() == 0) break;
            else 
            removePapers(pairs, result);
        }
        
        System.out.println(toRemove);
    }

    public static void removePapers(List<int[]> pairs, char[][] grid){
        for(int[] pair: pairs){
            int p1 = pair[0];
            int p2 = pair[1];

            grid[p1][p2] = '.';
        }
    }



    public static char[][] readMatrixAndAddPoints(List<String> lines){

        int n =  lines.size();
        int m =  lines.get(0).length();

        // allocate 
        char[][] result = new char[n+2][];

        for(int i=0; i< n+2; i++)
            result[i] = new char[m+2];

        for(int i=1; i< n+1; i++){
            for(int j=1; j < m+1; j++){
                result[i][j] = lines.get(i-1).charAt(j-1);
            }
        }

        // add . lines 
        for(int i=0; i< n+2; i++){
            result[0][i] = '.';
            result[n+1][i] = '.';
        }

        for(int i=0; i< m+2; i++){
            result[i][0] = '.';
            result[i][m+1] = '.';
        }
        return result;
    }
}
