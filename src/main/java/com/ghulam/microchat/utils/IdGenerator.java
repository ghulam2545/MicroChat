package com.ghulam.microchat.utils;

import java.util.UUID;

public class IdGenerator {
    public static String next() {
        return UUID.randomUUID().toString();
    }
}
