import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part1{
    public static void main(String[] a) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        int sum = 0;

        for(String s: lines){
            String[] numbers = s.split("");
            int firstIndex = 0;

            for(int i = 0; i < numbers.length-1 ; i++){
                if(Integer.parseInt(numbers[i]) > Integer.parseInt(numbers[firstIndex]))
                    firstIndex = i;
            }

            int secondIndex = firstIndex + 1;

            for(int j = firstIndex + 1; j < numbers.length ; j++){
                if(Integer.parseInt(numbers[j]) > Integer.parseInt(numbers[secondIndex]))
                    secondIndex = j;
            }
            System.out.println(numbers[firstIndex] + numbers[secondIndex]);
            sum += Integer.parseInt(numbers[firstIndex] + numbers[secondIndex]);
        }

        System.out.println(sum);

    }
}
