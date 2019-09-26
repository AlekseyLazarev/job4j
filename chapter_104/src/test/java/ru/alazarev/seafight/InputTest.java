package ru.alazarev.seafight;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InputTest {

    @Test
    public void whenIntInputTenThenGetTen() {
        Input in = new Input();
        int cell = 10;
        byte[] intToByteArray = String.valueOf(cell).getBytes();
        InputStream is = new ByteArrayInputStream(intToByteArray);
        System.setIn(is);
        int receivedInt = in.intInput();
        assertThat(receivedInt, is(cell));
    }

    @Test
    public void whenStringInputHThenGetH() {
        Input in = new Input();
        String inputString = "h";
        byte[] stringToByteArray = inputString.getBytes();
        InputStream is = new ByteArrayInputStream(stringToByteArray);
        System.setIn(is);
        String receivedString = in.stringInput();
        assertThat(receivedString, is(inputString));
    }
}