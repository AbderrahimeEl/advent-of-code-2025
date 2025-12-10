import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part1{
    public static void main(String[] a) throws IOException{

        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        List<long[]> intervals = new ArrayList<>();
        List<Long> ids = new ArrayList<>();

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
        
        for(int j = i+1; j < l; j++){
            String line = lines.get(j);
            ids.add(Long.parseLong(line));
        }
        
        int freshs = 0;
        i =0;
        for(i=0; i < ids.size(); i++){
            for(int j=0; j< intervals.size(); j++){
                long fN = intervals.get(j)[0];
                long sN = intervals.get(j)[1];

                if(ids.get(i) >= fN && ids.get(i) <= sN)
                {
                    freshs++;
                    break;
                }
            }
        }

        System.out.println(freshs);
    }

}
