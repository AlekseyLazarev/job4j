package ru.alazarev.finder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Elector {
    private final Map<String, Function<String, Boolean>> elector = new HashMap<>();
    private final String search;

    public Elector(String search) {
        this.search = search;
    }

    Elector init() {
        this.load("m", this.mask());
        this.load("f", this.full());
        this.load("r", this.regex());
        return this;
    }

    public void load(String type, Function<String, Boolean> handle) {
        this.elector.put(type, handle);
    }

    private Function<String, Boolean> mask() {
        return searchFile -> {
            return searchFile.contains(this.search);
        };
    }

    private Function<String, Boolean> full() {
        return searchFile -> {
            return searchFile.equalsIgnoreCase(this.search);
        };
    }

    private Function<String, Boolean> regex() {
        return searchFile -> {
            Pattern pattern = Pattern.compile(this.search);
            Matcher matcher = pattern.matcher(searchFile);
            return matcher.matches();
        };
    }

    Boolean sent(final String element, final String type) {
        Boolean result = null;
        if (this.elector.get(type) != null) {
            result = this.elector.get(type).apply(element);
        }
        return result;
    }
}
