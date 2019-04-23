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
    private static String BASE = null;
    private final static long START = System.currentTimeMillis();
    private static File xml = null;
    private static File xsl = null;
    private static File newXml = null;

    /**
     * Method get time.
     *
     * @param stage Stage name.
     */
    private static void getTime(String stage) {
        long timeWorkCode = System.currentTimeMillis() - START;
        int sec = (int) (timeWorkCode / 1000);
        int min = sec / 60;
        System.out.println("До " + stage + " прошло: " + min + " мин " + sec % 60 + " сек " + timeWorkCode % 1000 + " мс");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Program started...");
        Config config = new Config();
        config.init();
        BASE = config.get("path");
        if (new File(BASE + config.get("xsl")).exists()) {
            xml = new File(BASE + config.get("xml"));
            xsl = new File(BASE + config.get("xsl"));
            newXml = new File(BASE + config.get("generated"));
            StoreSQL storeSQL = new StoreSQL(config);
            storeSQL.init();
            storeSQL.generate(1000000);
            getTime("созднания записей");
            StoreXML storeXML = new StoreXML(xml);
            storeXML.save(storeSQL.load());
            getTime("созднания XML");
            ConvertXSQT convertXSQT = new ConvertXSQT();
            convertXSQT.convert(xml, newXml, xsl);
            getTime("созднания newXML");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXPars saxp = new SAXPars();
            parser.parse(newXml, saxp);
            getTime("парсинга");
        }
    }
}
