package ru.alazarev.analize;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Analize {

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

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

}
