package ru.alazarev.cache;

/**
 * Class Cache решение задачи части 5.4. Реализации кеша на SoftReference.
 *
 * @author Aleksey Lazarev
 * @since 02.10.2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Создать структуру данных типа кеш. Кеш должен быть абстрактный. То есть необходимо, что бы можно было задать
 * ключ получения объекта кеша и в случае если его нет в памяти, задать поведение загрузки этого объекта в кеш.
 * <p>
 * Создать программу эмулирующее поведение данного кеша. Программа должна считывать текстовые файлы из системы
 * и выдавать текст при запросе имени файла. Если в кеше файла нет. Кеш должен загрузить себе данные.
 * По умолчанию в кеше нет ни одного файла. Текстовые файл должны лежать в одной директории.
 * Пример. Names.txt, Address.txt - файлы в системе.
 * При запросе по ключу Names.txt - кеш должен вернуть содержимое файла Names.txt.
 */
public class Cache {
    private HashMap<String, SoftReference<String>> cache = new HashMap();
    private final String filesPath;
    private static final String LS = System.lineSeparator();

    /**
     * Constructor.
     *
     * @param filesPath Path to all files.
     */
    public Cache(String filesPath) {
        this.filesPath = filesPath;
    }

    /**
     * Method return string from file in cache or add file to cache and get strings from file.
     *
     * @param fileName File name.
     * @return Strings from file.
     */
    public String readFromCache(String fileName) {
        if (cache.get(fileName) == null) {
            this.cache.put(fileName, new SoftReference<>(readFromFile(fileName)));
        }
        return readFromFile(fileName);
    }

    /**
     * Method read strings from file by his name.
     *
     * @param fileName File name.
     * @return Strings from file.
     */
    private String readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String filePath = this.filesPath.concat("\\" + fileName);
        File file = new File(filePath);
        try {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        sb.append(scanner.nextLine() + LS);
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        return sb.toString();
    }
}