package ru.alazarev.analize;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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
        int equaled = 0;
        Iterator<User> previousIterator = previous.iterator();
        while (previousIterator.hasNext()) {
            int contain = 0;
            User previousUser = previousIterator.next();
            Iterator<User> currentIterator = current.iterator();
            while (currentIterator.hasNext()) {
                User currentUser = currentIterator.next();
                if (previousUser.id == currentUser.id) {
                    contain++;
                    equaled++;
                    if (!previousUser.name.equals(currentUser.name)) {
                        changed++;
                    }
                    break;
                }
            }
            if (contain == 0) {
                deleted++;
            }
        }
        return new Info(current.size() - equaled, changed, deleted);
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
