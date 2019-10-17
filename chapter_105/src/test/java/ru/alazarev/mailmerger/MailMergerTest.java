package ru.alazarev.mailmerger;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MailMergerTest {
    private MailMerger mailMerger = new MailMerger();
    private static final String LS = System.lineSeparator();

    @Test
    public void whenInputUsersAndEmailsThenFiveInUser1AndTwoInUser3() {
        String[] strings = new String[]{"user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru",
                "user2 ->foo@gmail.com,ups@pisem.net",
                "user3 ->xyz@pisem.net,vasya@pupkin.com",
                "user4 ->ups@pisem.net,aaa@bbb.ru",
                "user5 ->xyz@pisem.net"};
        for (int i = 0; i < strings.length; i++) {
            this.mailMerger.inputData(new ByteArrayInputStream(strings[i].getBytes()));
        }
        ArrayList<User> users = this.mailMerger.getUsers();
        Collection<String> expectedUser1 = new ArrayList<>();
        expectedUser1.add("aaa@bbb.ru");
        expectedUser1.add("foo@gmail.com");
        expectedUser1.add("lol@mail.ru");
        expectedUser1.add("ups@pisem.net");
        expectedUser1.add("xxx@ya.ru");
        Collection<String> expectedUser3 = new ArrayList<>();
        expectedUser3.add("vasya@pupkin.com");
        expectedUser3.add("xyz@pisem.net");
        Collection<String> user1emails = users.get(0).getEmails();
        Collection<String> user3emails = users.get(1).getEmails();
        assertThat(user1emails, is(expectedUser1));
        assertThat(user3emails, is(expectedUser3));
    }
}