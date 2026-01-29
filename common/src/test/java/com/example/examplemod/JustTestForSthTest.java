package com.example.examplemod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JustTestForSthTest {
    @Test
    @DisplayName("Test for 1 eq 1")
    void test() {
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("Test for 1 ne 2")
    void test2() {
        assertNotEquals(1, 2);
    }
}