package ru.alazarev.seafight;

import ru.alazarev.seafight.interfaces.IInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Input решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 19.09.2019
 */
public class Input implements IInput {
    /**
     * Method getting a number.
     *
     * @return received number.
     */
    @Override
    public int intInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        while (number == 0) {
            try {
                System.out.println("Input cell number");
                number = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter the number");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return number;
    }

    /**
     * Method getting a string.
     *
     * @return received string.
     */
    @Override
    public String stringInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        while (string == "") {
            try {
                System.out.println("Input way to place ship, if Vertical - press \"v\", if Horizontal press \"h\"");
                string = reader.readLine();
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter the number");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return string;
    }
}
