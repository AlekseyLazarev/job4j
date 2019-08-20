package ru.alazarev.tdd;


import ru.alazarev.tdd.exception.ExtraKeysInMapException;
import ru.alazarev.tdd.exception.KeyNotFoundException;
import ru.alazarev.tdd.exception.MapIsEmptyException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class SimpleGenerator решение задачи части 4 6.1. Исправить код класс SimpleGenerator. [#855]
 *
 * @author Aleksey Lazarev
 * @since 19.08.2019
 */
public class SimpleGenerator {
    private final Pattern keys = Pattern.compile("\\$\\{.+?}");

    /**
     * Method check extra keys in map and throw ExtraKeyInMapException.
     *
     * @param usageKeys Used keys.
     * @param values    Received keys.
     */
    private void checkExtraKeys(Set<String> usageKeys, Set<String> values) {
        if (usageKeys.size() != values.size()) {
            List<String> extraKeys = new ArrayList<>();
            for (String k : values) {
                if (!usageKeys.contains(k)) {
                    extraKeys.add(k);
                }
            }
            throw new ExtraKeysInMapException(extraKeys);
        }
    }

    /**
     * Method generates a new line replacing keywords.
     *
     * @param string String for replacing.
     * @param values Substitution map.
     * @return Result string.
     */
    public String generate(String string, Map<String, String> values) {
        Matcher matcher = keys.matcher(string);
        Set<String> usageKeys = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        String temp;
        if (values.isEmpty()) {
            throw new MapIsEmptyException();
        }
        while (matcher.find()) {
            temp = string.substring(matcher.start() + 2, matcher.end() - 1);
            usageKeys.add(temp);
            temp = values.get(temp);
            if (temp == null) {
                throw new KeyNotFoundException();
            } else {
                matcher.appendReplacement(sb, temp);
            }
        }
        checkExtraKeys(usageKeys, values.keySet());
        matcher.appendTail(sb);
        return sb.toString();
    }
}
