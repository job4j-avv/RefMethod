package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {10, 20, 30};
        var ref = new Object() {
            int total = 0;
        };
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            ref.total = add(
                    () -> ref.total + num
            );
        }
        System.out.println(ref.total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}