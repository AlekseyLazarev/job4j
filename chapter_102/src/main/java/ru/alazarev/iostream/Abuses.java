package ru.alazarev.iostream;

import java.io.*;
import java.util.Scanner;

//Реализовать сервис
//void dropAbuses(InputStream in, OutputStream out, String[] abuse)
//задан символьным поток. и символьный выходной поток. надо удалить все слова abuse.
//Важно все преобразования нужно делать в потоке. нельзя зачитать весь поток в память,
//удалить слова и потом записать. нужно все делать в потоке.
public class Abuses {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (Scanner scanner = new Scanner(in);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out)){
            while (scanner.hasNext()) {
                String value = scanner.next();
                for(int index = 0; index < abuse.length; index++) {
                    String abuseValue = abuse[index];
                    if (value.equals(abuseValue)) {
                        break;
                    } else if(index == abuse.length - 1){
                        outputStreamWriter.write(value+" ");
                    }
                }
            }
        } catch (IOException a) {
            System.out.println("GG");
        }
    }
}
