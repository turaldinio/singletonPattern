import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();

        return source.stream()
                .filter(x -> {
                    if (x < threshold) {
                        logger.log(String.format("Элемент %d не проходит", x));
                        return false;
                    } else {
                        logger.log(String.format("Элемент %d проходит", x));
                        return true;
                    }
                }).collect(Collectors.toList());
    }
}