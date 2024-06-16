package com.example.kthu_nang_cao.lab3_15th3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    @Test
    public void testGetName() {
        Profile emptyProfile = new Profile(null);
        assertThrows(NullPointerException.class, emptyProfile::getName);
    }

    @Test
    public void testGetNameNon() {
        Profile nonEmptyProfile = new Profile("John Doe");
        String name = nonEmptyProfile.getName();
        assertEquals("John Doe", name);
    }

}