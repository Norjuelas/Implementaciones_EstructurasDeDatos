package sequential;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Arraylist2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        (List<Integer>) Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                System.out.println(arr.get(i).get(j));
            }

        }
        System.out.println(arr.toString());
        bufferedReader.close();
    }
}
