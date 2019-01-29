package ru.alazarev.iostream;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;

public class Answers {

    /**
     * Contains destinations.
     */
    private final Map<String, Function<String, Boolean>> dispatch = new HashMap<>();
    PrintStream output;
    String pathToAnswers;
    List<String> answers = new ArrayList<>();

    public Answers(PrintStream output, String pathToAnswers) {
        this.output = output;
        this.pathToAnswers = pathToAnswers;
        setAnswers();
    }

    public void setAnswers() {
        try {
            FileReader fr = new FileReader(this.pathToAnswers);
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                this.answers.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public Function<String, Boolean> isFinish() {
        return enterLine -> {
            output.println(enterLine);
            return true;
        };
    }

    public Function<String, Boolean> isStop() {
        return enterLine -> {
            Answers inner = this;
            while (inner.sent(enterLine)) {
                output.println(enterLine);
                System.out.println(enterLine);
            }
            return false;
        };
    }

    public Function<String, Boolean> isPause() {
        return enterLine -> {
            output.println(enterLine);
            System.out.println(enterLine);
            return false;
        };
    }


    /**
     * Init's dispatch.
     *
     * @return current object.
     */
    public Answers init() {
        this.load("закончить", this.isFinish());
        this.load("стоп", this.isStop());
        this.load("продолжить", this.isPause());
        return this;
    }

    /**
     * Load handlers for destinations.
     *
     * @param type   Message type.
     * @param handle Handler.
     */
    public void load(String type, Function<String, Boolean> handle) {
        this.dispatch.put(type, handle);
    }

    /**
     * Sent message to dispatch.
     *
     * @param str message
     * @return true if it finds in a dispatch.
     */
    public boolean sent(final String str) {
        boolean result = false;
        if (this.dispatch.get(str) != null) {
            result = this.dispatch.get(str).apply(str);
        } else {
            String phrase = this.answers.get((int) (Math.random() * this.answers.size()));
            System.out.println(phrase);
            output.println(phrase);
        }
        return result;
    }
}

