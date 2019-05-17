package ru.alazarev.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class SqlParser решение задачи Парсер вакансий на sql.ru [#1731].
 *
 * @author Aleksey Lazarev
 * @since 30.04.2019
 */
public class SqlParser {
    private long last = 0;
    private String url = "https://www.sql.ru/forum/job-offers/";
    private String countTrigger = "Показываются темы: 1 - 50 из ";
    private int vacOnPage = 50;
    private static final String FORMAT = "d MMM yy, hh:mm";
    private static SimpleDateFormat sdf;
    private static SqlDataBase sdb;
    private static final String[] MONTHS = {"янв", "фев", "мар", "апр", "май", "июн",
            "июл", "авг", "сен", "окт", "ноя", "дек"};

    /**
     * Method set russian locale format with months short names.
     */
    private void setSimpleDateFormat() {
        Locale rus = new Locale("ru");
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(rus);
        dfs.setShortMonths(MONTHS);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, rus);
        sdf = (SimpleDateFormat) df;
        sdf.setDateFormatSymbols(dfs);
    }

    /**
     * Method convert string date to long format.
     *
     * @param date String date.
     * @return Long date format.
     */
    private long dateConverter(String date) {
        long result = 0;
        try {
            result = date.length() != 0 ? new SimpleDateFormat(FORMAT).parse(date).getTime() : 0;
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    /**
     * Constructor.
     *
     * @param sqlDataBase Sql database.
     */
    public SqlParser(SqlDataBase sqlDataBase) {
        sdb = sqlDataBase;
    }

    public SqlParser init() {
        setSimpleDateFormat();
        this.last = sdb.getLastDate();
        return this;
    }

    /**
     * Method return Matcher object using pattern and text.
     *
     * @param text    Text to match.
     * @param pattern Pattern to match.
     * @return Match object.
     */
    private Matcher checker(String text, String pattern) {
        Pattern checkPat = Pattern.compile(pattern);
        return checkPat.matcher(text);
    }

    /**
     * Method parse vacancies on sql.ru.
     */
    public void parse() {
        try {
            Document document = Jsoup.connect(url).get();
            String s = document.getElementsContainingText(countTrigger).last().text();
            int pageCount = 1 + Integer.valueOf(s.substring(countTrigger.length())) / vacOnPage;
            HashSet<Vacancy> vacancy = new HashSet<>();
            boolean cont = true;
            int i = 1;
            do {
                Document currentPage = Jsoup.connect(url + i).get();
                Elements ft = currentPage.getElementsByClass("forumTable");
                Elements stringsInside = ft.first().getElementsByTag("tr");
                for (Element currentStringInside : stringsInside) {
                    String link = "";
                    String name = "";
                    String date = "";
                    Elements cv = currentStringInside.getElementsByClass("postslisttopic");
                    if (cv.size() > 0) {
                        Element themeWithLink = cv.first().getElementsByTag("a").first();
                        name = themeWithLink.text();
                        if (checker(name.toLowerCase(), "(?!java\\W*script)(java)").find()) {
                            link = themeWithLink.getElementsByAttributeStarting("href").attr("href");
                            Document innerTheme = Jsoup.connect(link).get();
                            String text = innerTheme.getElementsByClass("msgBody").get(1).text();
                            date = currentStringInside.getElementsByClass("altCol").last().text();
                            Matcher dateMatch = checker(date, "\\d{1,2}\\s\\D{3}\\s\\d{1,2},\\s\\d{1,2}:\\d{1,2}");
                            if (dateMatch.find()) {
                                date = dateMatch.group();
                            } else {
                                Calendar calendar = new GregorianCalendar();
                                dateMatch = checker(date, "\\d{1,2}:\\d{1,2}");
                                dateMatch.find();
                                date = String.format("%d %s %d, %s",
                                        calendar.get(Calendar.DAY_OF_MONTH),
                                        MONTHS[calendar.get(Calendar.MONTH)],
                                        calendar.get(Calendar.YEAR),
                                        dateMatch.group());
                            }
                            long convertedDate = dateConverter(date);
                            if (convertedDate > this.last) {
                                vacancy.add(new Vacancy(name, text, link, dateConverter(date)));
                            } else {
                                cont = false;
                                break;
                            }
                        }
                    }
                }
                i++;
            } while (cont && i <= pageCount);
            sdb.load(vacancy);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
