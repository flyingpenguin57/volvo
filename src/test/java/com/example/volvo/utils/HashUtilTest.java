package com.example.volvo.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashUtilTest {

    @Test
    public void test() {
        String s = HashUtil.hashWithGuava("12323232");
        assertEquals(s, "32aec05686f0c4db3042f33496b705c82f4b68a42f428effdfdd25c755e87efc");
    }
}
