import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 1, 2, 2, 2, 3, 4, 5, 5);
        List<Character> characters = Lists.newArrayList('a', 'b', 'c', 'c', 'c', 'd');

        showMostPopular(integers);
        showMostPopular(characters);
    }

    private static <T> void showMostPopular(List<T> list) {
        Optional<T> o = list.stream()
                .collect(new MostPopular<>());

        System.out.println("Most popular element in [" + StringUtils.join(list, ",") + "]: ");
        o.ifPresent(System.out::println);
    }
}
