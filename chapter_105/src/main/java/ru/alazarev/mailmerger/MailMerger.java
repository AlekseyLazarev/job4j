package ru.alazarev.mailmerger;

import org.apache.commons.collections4.CollectionUtils;

import java.io.*;
import java.util.*;

/**
 * Требуется написать работающий код, решающий задачу, и приложить
 * инструкцию, как код собрать и запустить.
 * Также надо написать unittest-ы.
 * Задачу реализовать на Java (достаточно как консольное JAVA приложение).
 * Код выложить на любой репозиторий (GitHub, GitLab, Butbucket)
 * <p>
 * Имеется n пользователей, каждому из них соответствует список email-ов
 * (всего у всех пользователей m email-ов).
 * Например:
 * user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
 * user2 ->foo@gmail.com,ups@pisem.net
 * user3 ->xyz@pisem.net,vasya@pupkin.com
 * user4 ->ups@pisem.net,aaa@bbb.ru
 * user5 ->xyz@pisem.net
 * <p>
 * Считается, что если у двух пользователей есть общий email, значит это
 * один и тот же пользователь. Требуется построить
 * и реализовать алгоритм, выполняющий слияние пользователей. На выходе
 * должен быть список пользователей с их email-ами (такой же как на
 * входе).
 * В качестве имени объединенного пользователя можно брать любое из
 * исходных имен. Список email-ов пользователя должен содержать только
 * уникальные email-ы.
 * Параметры n и m произвольные, длина конкретного списка email-ов никак
 * не ограничена.
 * Требуется, чтобы асимптотическое время работы полученного решения было
 * линейным, или близким к линейному.
 * <p>
 * Возможный ответ на задачу в указанном примере:
 * user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
 * user3 ->xyz@pisem.net,vasya@pupkin.com
 */
public class MailMerger {
    private HashSet<User> users = new HashSet<>();
    private final String divider = " ->";
    private final String emailDivider = ",";

    /**
     * Method return sorted user list.
     *
     * @return sorted user list.
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> cur = new ArrayList<>();
        cur.addAll(this.users);
        Comparator<User> comparator = (User o1, User o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
        Collections.sort(cur, comparator);
        return cur;
    }

    /**
     * Method parses the input data to the user and his emails.
     *
     * @param input Input stream data.
     */
    public void inputData(InputStream input) {
        String current = new Scanner(input).nextLine();
        String userName = current.substring(0, current.indexOf(this.divider));
        String emailLine = current.substring(current.indexOf(this.divider) + this.divider.length());
        String[] emails = emailLine.split(this.emailDivider);
        merge(userName, Arrays.asList(emails));
    }

    /**
     * Method write users and his emails unto output stream.
     *
     * @param output Output stream.
     */
    public void outputData(OutputStream output) {
        for (User user : this.users) {
            try {
                StringBuilder sb = new StringBuilder();
                user.getEmails().forEach(email -> sb.append(email).append(this.emailDivider));
                String result = user.getName() + this.divider + sb.deleteCharAt(sb.length() - this.emailDivider.length()).toString() + System.lineSeparator();
                output.write(result.getBytes());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * The method looks if there is a user with at least 1 of the emails,
     * if so, writes all the emails to it, if not then creates a new one.
     *
     * @param newUserName User name.
     * @param userList    User emails.
     */
    private void merge(String newUserName, Collection<String> userList) {
        boolean newest = true;
        for (User current : this.users) {
            if (CollectionUtils.retainAll(current.getEmails(), userList).size() != 0) {
                current.addList(CollectionUtils.subtract(userList, current.getEmails()));
                newest = false;
                break;
            }
        }
        if (newest) {
            this.users.add(new User(newUserName, userList));
        }
    }

    /**
     * Method get information from file.
     *
     * @param path Path to file.
     */
    public void getFromFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String currentLine = br.readLine();
            while (currentLine != null) {
                inputData(new ByteArrayInputStream(currentLine.getBytes()));
                currentLine = br.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Main method.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        MailMerger mailMerger = new MailMerger();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input emails.txt path");
        String path = scanner.nextLine();
        mailMerger.getFromFile(path);
        System.out.println("Input result.txt path");
        path = scanner.nextLine();
        try (FileWriter fileWriter = new FileWriter(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            mailMerger.outputData(baos);
            fileWriter.write(baos.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
