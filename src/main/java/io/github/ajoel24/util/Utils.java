package io.github.ajoel24.util;

import java.util.regex.Pattern;

public final class Utils {
    public static final String SPACE_REGEX_PATTERN = Pattern.compile("\\s+").pattern();

    private Utils() {
        throw new UnsupportedOperationException("Class cannot be instantiated");
    }
}
