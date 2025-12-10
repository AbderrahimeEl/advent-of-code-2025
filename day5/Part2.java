import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part2{
    public static void main(String[] args) throws IOException{

        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        List<long[]> intervals = new ArrayList<>();

        int i=0;
        int l = lines.size();

        for(i=0; i< l;i++){
            String line = lines.get(i);

            if(line.equals("")) break;

            else {
                String[] interval = line.split("-");
                long firstN = Long.parseLong(interval[0]);
                long secondN = Long.parseLong(interval[1]);
                intervals.add(new long[]{firstN,secondN});
            }
        }

        Collections.sort(intervals, (a,b) -> Long.compare(a[0], b[0]));

        long freshs = intervals.get(0)[1] - intervals.get(0)[0] + 1;

        long[] prev = intervals.get(0);

        for(i = 1; i< intervals.size(); i++){
            long[] curr = intervals.get(i);

            if(curr[0] > prev[1]){
                freshs += + curr[1] - curr[0] + 1;
                prev = curr;
            }
            else{ 
                if(curr[1] > prev[1]){
                    freshs = freshs + curr[1] - prev[1];
                    prev = curr;
                }
            }
        }

        System.out.println(freshs);
    }

}
