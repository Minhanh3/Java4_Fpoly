package com.example.kthu_nang_cao.lab3_15th3;

public class ArrayUtils {
    public static int GetElementAtIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return array[index];
    }
}
