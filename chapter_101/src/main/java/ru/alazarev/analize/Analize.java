package ru.alazarev.analize;

import java.util.Iterator;
import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int previousSize = previous.size();
        int changed = 0;
        int deleted = 0;
        Iterator<User> previousIterator = previous.iterator();
        while (previousIterator.hasNext()) {
            User previousUser = previousIterator.next();
            Iterator<User> currentIterator = current.iterator();
            while (currentIterator.hasNext()) {
                User currentUser = currentIterator.next();
                if (previousUser.id == currentUser.id && !previousUser.name.equals(currentUser.name)) {
                    changed++;
                } else if (!previousUser.equals(currentUser) && !currentIterator.hasNext()) {
                    deleted++;
                }
            }
        }
        return new Info(added, changed, deleted);

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
