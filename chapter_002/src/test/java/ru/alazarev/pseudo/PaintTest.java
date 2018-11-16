package ru.alazarev.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфур для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        StringBuilder ex = new StringBuilder();
        ex.append("*******\n");
        ex.append("*     *\n");
        ex.append("*     *\n");
        ex.append("*******\n");
        String result = new String(out.toByteArray());
        assertThat(result, is(ex.toString()));
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}