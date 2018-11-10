package ru.alazarev.сondition;

/**
 * Class DummyBot решение задачи части 001. Урок 4.1. Глупый бот. [#31323].
 * @author Aleksey Lazarev
 * @since 10.11.2018
 */
public class DummyBot {
    /**
     * Answer the question.
     * @param question Question from client.
     * @return Answer.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}