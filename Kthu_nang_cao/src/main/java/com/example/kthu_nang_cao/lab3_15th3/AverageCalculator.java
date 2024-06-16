package com.example.kthu_nang_cao.lab3_15th3;

import java.util.List;

public class AverageCalculator {
    public double calculateAverage(List<Integer> numbers) {
        if (numbers == null
//                || numbers.isEmpty()
        ) {
            throw new ArithmeticException("Danh sách trống");
        }

        int sum = 0;
        for (Integer num : numbers) {
            if (num == null) {
                throw new NullPointerException("Danh sách chứa giá trị null");
            }
            sum += num;
        }
        if (numbers.contains(0)) {
            throw new ArithmeticException("Chia cho 0");
        }
        return (double) sum / numbers.size();
    }
}
