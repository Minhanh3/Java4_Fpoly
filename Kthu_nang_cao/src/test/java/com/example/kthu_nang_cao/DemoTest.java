package com.example.kthu_nang_cao;

import com.example.kthu_nang_cao.lab1.Demo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DemoTest {
    Demo demo = new Demo();

    @Test
    public void congtest() { // c1 ct
        int re = demo.Sum(2, 3);
        int ex = 5;
        assertEquals(re, ex);
        // c2 Lua
        // Assertions.assertEquals(demo.Sum(2 , 3) ,5);
    }

    @Test
    public void trutest() {
        assertEquals(demo.Subtract(2 , 3), 5);
    }

    @Test
    public void nhantest() {
        assertEquals(demo.Multiply(3, 3), 9);
    }

    @Test
    public void chiatest() {
        assertEquals(demo.Divide(9, 3), 3);
    }


}