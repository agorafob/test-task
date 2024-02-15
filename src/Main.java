import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TestCase t = new TestCase("D:\\10m.txt");
        t.getMax();
        t.getMin();
        t.getMedian();
        t.maxIncrease();
        t.maxDecrease();
    }
}
