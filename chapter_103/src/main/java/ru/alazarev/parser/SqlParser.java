package ru.alazarev.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

/**
 * Class SqlParser решение задачи Парсер вакансий на sql.ru [#1731].
 *
 * @author Aleksey Lazarev
 * @since 30.04.2019
 */
public class SqlParser {
    String url = "https://www.sql.ru/forum/job-offers/";
    String countTrigger = "Показываются темы: 1 - 50 из ";
    String forFind = "java";
    String without = "script";
    int vacOnPage = 50;
    private static SqlDataBase sdb;

    /**
     * Constructor.
     *
     * @param sqlDataBase Sql database
     */
    public SqlParser(SqlDataBase sqlDataBase) {
        sdb = sqlDataBase;
    }

    /**
     * Method parse vacancies on sql.ru.
     */
    public void parse() {
        try {
            int pageCount = 2;
            if (!sdb.getConfig().getProperty("last.update").matches("[\\d]+")) {
                Document document = Jsoup.connect(url).get();
                String s = document.getElementsContainingText(countTrigger).last().text();
                pageCount = 1 + Integer.valueOf(s.substring(countTrigger.length())) / vacOnPage;
            }
            HashSet<Vacancy> vacancy = new HashSet<>();
            for (int i = 1; i <= pageCount; i++) {
                Document currentPage = Jsoup.connect(url + i).get();
                Elements currents = currentPage.getElementsByClass("postslisttopic");
                for (Element e : currents) {
                    String currentText = e.text().toLowerCase();
                    if (currentText.contains(forFind) && !currentText.contains(without)) {
                        int indexClose = e.html().indexOf("\">");
                        String link = e.html().substring(e.html().indexOf("=\"") + 2, indexClose);
                        String name = e.getElementsByTag("a").first().text();
                        String text = Jsoup.connect(link).get().getElementsByClass("msgBody").get(1).text();
                        vacancy.add(new Vacancy(name, text, link));
                    }
                }
            }
            sdb.load(vacancy);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
