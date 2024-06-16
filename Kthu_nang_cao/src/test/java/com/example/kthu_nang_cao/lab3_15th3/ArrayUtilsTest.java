package com.example.kthu_nang_cao.lab3_15th3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void getElementAtIndex() {

    }

    @Test
    public void testGetElementAtIndex() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(3, ArrayUtils.GetElementAtIndex(array, 2));
    }

    @Test
    public void testGetElementAtIndex1() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(3, ArrayUtils.GetElementAtIndex(array, 4));
    }

}