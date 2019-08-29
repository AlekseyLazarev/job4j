package ru.alazarev.tictactoe;

import ru.alazarev.tictactoe.interfaces.IInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Input решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 28.08.2019
 */
public class Input implements IInput {
    /**
     * Method get input from keyboard.
     *
     * @param message Message for user.
     * @return user response.
     */
    private int input(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        while (number == 0) {
            try {
                System.out.println(message);
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
     * Method get number.
     *
     * @return Number.
     */
    @Override
    public int getNumber() {
        return input("Choose free cell and enter it's number") - 1;
    }

    /**
     * Method get pole size.
     *
     * @return Pole size.
     */
    @Override
    public int getPoleSize() {
        return input("Input pool size");
    }

    /**
     * Method return who starts the game.
     *
     * @return who starts the game.
     */
    @Override
    public boolean pcFirst() {
        return input("If the first you, enter - 1, if computer - any number.") != 1;
    }
}
