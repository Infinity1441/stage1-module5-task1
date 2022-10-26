package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings.stream().allMatch(s -> s.matches("^[A-Z].+"));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            int i=0,l=integers.size();
            while (i<l){
                if (integers.get(i) % 2 == 0)
                    integers.add(integers.get(i));
                i++;
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> res = new ArrayList<>();
            for (String value : values) {
                if (value.matches("^[A-Z].+")&&value.endsWith(".")&&value.split(" ").length>3) {
                    res.add(value);
                }
            }
            return res;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x->{
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                map.put(s,s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
