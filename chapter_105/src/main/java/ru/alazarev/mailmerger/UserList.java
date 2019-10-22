package ru.alazarev.mailmerger;

import java.util.ArrayList;

/**
 * Class UserList решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 22.10.2019
 */
public class UserList {
    private ArrayList<User> users = new ArrayList<>();

    /**
     * Method add user to arraylist
     *
     * @param user User to add.
     * @return result add.
     */
    public boolean addUser(User user) {
        return this.users.add(user);
    }

    /**
     * Method find User by name.
     *
     * @param userName User name.
     * @return User.
     */
    public User find(String userName) {
        User result = null;
        for (User u : this.users) {
            if (userName.equals(u.getName())) {
                result = u;
            }
        }
        return result;
    }

    /**
     * Method return users array list.
     *
     * @return User array list.
     */
    public ArrayList<User> getUsers() {
        return this.users;
    }
}
