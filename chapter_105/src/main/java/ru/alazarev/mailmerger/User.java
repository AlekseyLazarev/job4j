package ru.alazarev.mailmerger;

import java.util.*;

public class User {
    private String name;
    private HashSet<String> emails = new HashSet<>();

    /**
     * Constructor.
     *
     * @param name   User name.
     * @param emails Emails this user.
     */
    public User(String name, Collection<String> emails) {
        this.name = name;
        this.emails.addAll(emails);
    }

    /**
     * Method return this user name.
     *
     * @return User name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method return collection of emails.
     *
     * @return Collection of emails.
     */
    public Collection<String> getEmails() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.addAll(this.emails);
        Collections.sort(stringList);
        return stringList;
    }

    /**
     * Method add List into this emails.
     *
     * @param emailList Newest emails.
     */
    public void addList(Collection emailList) {
        this.emails.addAll(emailList);
    }
}
