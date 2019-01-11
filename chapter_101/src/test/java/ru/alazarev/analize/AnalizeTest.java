package ru.alazarev.analize;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void name(){
        Analize analize = new Analize();
        List<Analize.User> previous = new LinkedList<>();
        List<Analize.User> current = new LinkedList<>();
        for(int index = 0; index < 10; index++) {
            previous.add(new Analize.User(index, Integer.toString(index)));
            current.add(new Analize.User(index, Integer.toString(index)));
        }
        current.remove(0);
        current.remove(0);
        current.add(new Analize.User(0,"Name"));
        Analize.Info info = analize.diff(previous, current);
    }

}