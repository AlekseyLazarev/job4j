package ru.alazarev.profession;

/**
 * Class Doctor extends class Profession решение задачи части 002. Урок 1. Реализация профессий в коде [#6837].
 *
 * @author Aleksey Lazarev
 * @since 14.11.2018
 */
public class Doctor extends Profession {
    /**
     * Constructor class Doctor.
     *
     * @param name       Name of doctor.
     * @param profession Profession of specialist.
     */
    public Doctor(String name, String profession) {
        super(name, profession);
    }

    /**
     * Healing patient.
     *
     * @param patient Person who need help.
     */
    public void healPatient(Patient patient) {
    }
}