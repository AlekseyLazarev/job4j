package ru.alazarev.iostream;

import java.io.*;
import java.util.Arrays;

/**
 * Class Abuses решение задачи части 002. 2. Удаление запрещенных слов [#859].
 *
 * @author Aleksey Lazarev
 * @since 17.01.2019
 */
public class Abuses {
    /**
     * Method drop abuses.
     *
     * @param in    InputStream.
     * @param out   OutputStream.
     * @param abuse Abuse words.
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(in));
             PrintStream output = new PrintStream(out)) {
            input.lines().map(s -> Arrays.stream(abuse)
                    .reduce(s, ((s1, s2) -> s1.replaceAll(s2 + "[^А-я]", "")
                            .replaceAll(" {2}", " ")))).forEach(output::print);
        } catch (Exception ex) {
        }
    }
}