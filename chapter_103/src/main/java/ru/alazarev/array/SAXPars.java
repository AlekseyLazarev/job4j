package ru.alazarev.array;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Class SAXPars решение задачи части 003. Урок 4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Aleksey Lazarev
 * @since 14.04.2019
 */
public class SAXPars extends DefaultHandler {
    private long sum = 0;

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("entry")) {
            sum += Integer.valueOf(atts.getValue("href"));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Арифметическая сумма значений всех атрибутов field :" + this.sum);
    }
}
