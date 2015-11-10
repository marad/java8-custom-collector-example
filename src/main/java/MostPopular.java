import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MostPopular<T> implements Collector<T, Map<T, Integer>, Optional<T>> {
    @Override
    public Supplier<Map<T, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<T, Integer>, T> accumulator() {
        return (acc, elem) -> acc.merge(elem, 1, (old, v) -> old + v);
    }

    @Override
    public BinaryOperator<Map<T, Integer>> combiner() {
        return (acc1, acc2) -> {
            throw new UnsupportedOperationException();
        };
    }

    @Override
    public Function<Map<T, Integer>, Optional<T>> finisher() {
        return (acc) -> acc.entrySet().stream()
            .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
            .map(Map.Entry::getKey);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
