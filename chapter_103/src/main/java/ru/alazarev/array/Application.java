package ru.alazarev.array;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
/**
 * Class StoreSQL решение задачи части 003. Урок 4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Aleksey Lazarev
 * @since 14.04.2019
 */
public class Application {
    final static String base = "c:/projects/db/";
    final static long start = System.currentTimeMillis();
    static File xml = new File(base + "file.xml");
    static File xsl = new File(base + "schema.xsl");
    static File newXml = new File(base + "nextxml.xml");

    /**
     * Method get time.
     *
     * @param stage Stage name.
     */
    public static void getTime(String stage) {
        long timeWorkCode = System.currentTimeMillis() - start;
        int sec = (int) (timeWorkCode / 1000);
        int min = sec / 60;
        System.out.println("До " + stage + " прошло: " + min + "мин " + sec % 60 + " сек " + timeWorkCode % 1000 + " мс");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Program started...");
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.init();
        storeSQL.generate(1000000);
        getTime("созднания записей");
        StoreXML storeXML = new StoreXML(xml);
        storeXML.save(storeSQL.load());
        getTime("созднания XML");
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.createXsl(xsl);
        convertXSQT.convert(xml, newXml, xsl);
        getTime("созднания newXML");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXPars saxp = new SAXPars();
        parser.parse(newXml, saxp);
        getTime("парсинга");

    }
}
