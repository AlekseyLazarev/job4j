package ru.alazarev.socket;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Class AnswersChecker решение задачи части 002. 2.1. Бот [#7921].
 *
 * @author Aleksey Lazarev
 * @since 29.01.2019
 */
public class AnswersChecker {

    /**
     * Contains destinations.
     */
    private final Map<String, Function<String, String>> dispatch = new HashMap<>();

    /**
     * Handle to say hello.
     *
     * @return handle.
     */
    public Function<String, String> sayHello() {
        return string -> {
            return "Hello, dear friend, I'm a oracle.";
        };
    }

    /**
     * Handle to say how are you.
     *
     * @return handle.
     */
    public Function<String, String> sayHowAreYou() {
        return string -> {
            return "I'm fine! U?";
        };
    }

    /**
     * Init's dispatch.
     *
     * @return current object.
     */
    public AnswersChecker init() {
        this.load("hello", this.sayHello());
        this.load("how are you?", this.sayHowAreYou());
        return this;
    }

    /**
     * Load handlers for destinations.
     *
     * @param string Message type.
     * @param handle Handler.
     */
    public void load(String string, Function<String, String> handle) {
        this.dispatch.put(string, handle);
    }

    /**
     * Sent message to dispatch.
     *
     * @param string message.
     * @return answer.
     */
    public String sent(final String string) {
        String result = "I don't understand ! =(";
        if (this.dispatch.get(string) != null) {
            result = this.dispatch.get(string).apply(string);
        }
        return result;
    }
}