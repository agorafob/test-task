import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestCase {
    private static final List<Integer> data = new ArrayList<>();

    public TestCase(String fileAddress) throws IOException {
        setData(fileAddress);
    }

    private static void setData(String fileAddress) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileAddress))) {
            String str;
            while ((str = in.readLine()) != null) {
                data.add(Integer.parseInt(str));
            }
        }
    }

    public void getMax() {
        data.parallelStream().max(Comparator.comparing(Integer::intValue)).
                ifPresent(System.out::println);
    }

    public void getMin() {
        data.parallelStream().min(Comparator.comparing(Integer::intValue)).
                ifPresent(System.out::println);
    }

    public void getMedian() {
        long size = data.parallelStream().count();
        if (size % 2 != 0) {
            System.out.println(data.get((int) (size / 2) + 1));
        } else {
            System.out.println((data.get((int) (size / 2) + data.get((int) (size / 2) + 1))) / 2);
        }
    }


    public void maxIncrease() {
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        int outerCounter = 0;
        while (index != data.size()) {
            int innerCounter = 0;
            for (int i = index; i < data.size(); i++) {
                if (i + 1 == data.size()) {
                    if (data.get(i) > data.get(i - 1)) {
                        temp.add(data.get(i));
                        sequences.add(temp);
                    }
                    index = i + 1;
                    break;
                } else if (data.get(i) < data.get(i + 1)) {
                    temp.add(data.get(i));
                    innerCounter++;
                } else {
                    temp.add(data.get(i));
                    innerCounter++;
                    if (innerCounter > 1 && innerCounter >= outerCounter) {
                        sequences.add(List.copyOf(temp));
                        outerCounter = innerCounter;
                    }
                    index = i + 1;
                    temp = new ArrayList<>();
                    break;
                }
            }
        }
        sequences.parallelStream().max(Comparator.comparing(List::size)).ifPresent(System.out::println);
    }


    public void maxDecrease() {
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        int outerCounter = 0;
        while (index != data.size()) {
            int innerCounter = 0;
            for (int i = index; i < data.size(); i++) {
                if (i + 1 == data.size()) {
                    if (data.get(i) < data.get(i - 1)) {
                        temp.add(data.get(i));
                        sequences.add(temp);
                    }
                    index = i + 1;
                    break;
                } else if (data.get(i) > data.get(i + 1)) {
                    temp.add(data.get(i));
                    innerCounter++;
                } else {
                    temp.add(data.get(i));
                    innerCounter++;
                    if (innerCounter > 1 && innerCounter >= outerCounter) {
                        sequences.add(List.copyOf(temp));
                        outerCounter = innerCounter;
                    }
                    index = i + 1;
                    temp = new ArrayList<>();
                    break;
                }
            }
        }
        sequences.parallelStream().max(Comparator.comparing(List::size)).ifPresent(System.out::println);
    }

}
