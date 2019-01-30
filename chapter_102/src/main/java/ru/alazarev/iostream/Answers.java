package ru.alazarev.iostream;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;

/**
 * Class Answers решение задачи части 002. 5. Создать программу консольный чат.  [#862].
 *
 * @author Aleksey Lazarev
 * @since 30.01.2019
 */
public class Answers {

    /**
     * Contains destinations.
     */
    Map<String, Function<String, Boolean>> dispatch = new HashMap<>();
    PrintStream output;
    String pathToAnswers;
    List<String> answers = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param output        Output stream.
     * @param pathToAnswers Path to answers.
     */
    public Answers(PrintStream output, String pathToAnswers) {
        this.output = output;
        this.pathToAnswers = pathToAnswers;
        setAnswers();
    }

    /**
     * Method load answers in list.
     */
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

    /**
     * Method when finish.
     *
     * @return Command for cycle.
     */
    public Function<String, Boolean> isFinish() {
        return enterLine -> {
            return true;
        };
    }

    /**
     * Method when stop.
     *
     * @return Command for cycle.
     */
    public Function<String, Boolean> isStop() {
        return enterLine -> {
            Answers inner = this;
            boolean exit = true;
            do {
                String newLine = new Scanner(System.in).nextLine();
                output.println(newLine);
                exit = !"продолжить".equals(newLine) ? inner.sent("_inStop") : inner.sent(newLine);
            } while (exit);
            return false;
        };
    }

    /**
     * Method when continue.
     *
     * @return Command for cycle.
     */
    public Function<String, Boolean> isPause() {
        return enterLine -> {
            return false;
        };
    }

    /**
     * Method when in cycle stop.
     *
     * @return Command for cycle.
     */
    public Function<String, Boolean> isInStop() {
        return enterLine -> {
            return true;
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
        this.load("_inStop", this.isInStop());
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

