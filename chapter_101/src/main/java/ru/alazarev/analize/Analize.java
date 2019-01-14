package ru.alazarev.analize;

import java.util.*;

/**
 * Class Analize решение задачи части 001. Статистику по коллекции. [#45889]
 *
 * @author Aleksey Lazarev
 * @since 13.01.2019
 */
public class Analize {
    /**
     * Method return difference of two User list.
     *
     * @param previous User list before actions.
     * @param current  User list after actions.
     * @return result Compare result.
     */
    public Info diff(List<User> previous, List<User> current) {
        if (previous == null || current == null) {
            throw new NoSuchElementException();
        }
        int changed = 0;
        int deleted = 0;
        HashMap<Integer, Analize.User> hashCurrent = new HashMap<>();
        for (int index = 0; index < current.size(); index++) {
            User currentUser = current.get(index);
            hashCurrent.put(currentUser.id, currentUser);
        }
        for (User previousUser : previous) {
            User currentUser = hashCurrent.remove(previousUser.id);
            if (currentUser == null) {
                deleted++;
            } else if (!previousUser.name.equals(currentUser.name)) {
                changed++;
            }
        }

        return new Info(hashCurrent.size(), changed, deleted);
    }

    /**
     * Class User.
     */
    public static class User {
        int id;
        String name;

        /**
         * Constructor.
         *
         * @param id   Id user.
         * @param name Name user.
         */
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * Class Info.
     */
    public static class Info {
        int added;
        int changed;
        int deleted;

        /**
         * Constructor.
         *
         * @param added   Added users count.
         * @param changed Changed users count.
         * @param deleted Deleted users count.
         */
        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

}
