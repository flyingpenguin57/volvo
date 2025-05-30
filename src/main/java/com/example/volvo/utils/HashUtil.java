package com.example.volvo.utils;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class HashUtil {
    public static String hashWithGuava(String input) {
        return Hashing.sha256()
                .hashString(input, StandardCharsets.UTF_8)
                .toString();
    }
}
