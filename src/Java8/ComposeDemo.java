package Java8;

import java.util.function.Function;

/**
 * Created by bupt on 4/29/17.
 */
public class ComposeDemo {

    public static void main(String[] args) {
        Function<Integer,Integer> times = e-> e * 2;
        Function<Integer,Integer> squared = e -> e * e;

        System.out.println(times.compose(squared).apply(2));
        System.out.println(times.andThen(squared).apply(2));
    }



}
