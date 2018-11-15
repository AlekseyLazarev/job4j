package ru.alazarev.profession;

/**
 * Class Doctor extends class Profession решение задачи части 002. Урок 1. Реализация профессий в коде [#6837].
 *
 * @author Aleksey Lazarev
 * @since 14.11.2018
 */
public class Teacher extends Profession {
    /**
     * Constructor class Teacher.
     *
     * @param name       Name of teacher.
     * @param profession Profession of specialist.
     */
    public Teacher(String name, String profession) {
        super(name, profession);
    }

    /**
     * Teaching student.
     *
     * @param student Student who need teaching.
     */
    public void teachStudent(Student student) {
    }
}