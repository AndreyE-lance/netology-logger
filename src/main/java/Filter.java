import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        AtomicReference<Integer> i = new AtomicReference<>(0);
        source.forEach(l -> {
            if (l < treshold) {
                logger.log("Элемент " + l + " проходит.");
                result.add(l);
                i.getAndSet(i.get() + 1);
            } else {
                logger.log("Элемент " + l + " не проходит.");
            }
        });
        logger.log("Подошло " + i.get() + " элементов из " + source.size());
        return result;
    }
}
