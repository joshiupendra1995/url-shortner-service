package com.url_shortner.service.utils;

public class Base62Util {
    private Base62Util(){}
    private static final String BASE62_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int BASE = BASE62_CHARSET.length();

    // Encode a number into Base62
    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62_CHARSET.charAt((int) (num % BASE)));
            num /= BASE;
        }
        return String.valueOf(sb.reverse());
    }

    // Decode a Base62 string back into a number
    public static long decode(String base62) {
        long num = 0;
        for (char c : base62.toCharArray()) {
            num = num * BASE + BASE62_CHARSET.indexOf(c);
        }
        return num;
    }
}

