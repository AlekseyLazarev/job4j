package ru.alazarev.array;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Class ConvertXSQT решение задачи части 003. Урок 4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Aleksey Lazarev
 * @since 14.04.2019
 */
public class ConvertXSQT {
    /**
     * Method convert xml file to newest xml file using scheme.
     *
     * @param source Original file.
     * @param dest   Newest file.
     * @param scheme Scheme for convert.
     */
    public void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method create scheme.
     *
     * @param file File for scheme.
     */
    public void createXsl(File file) {
        try (Writer writer = new FileWriter(file)) {
            writer.write("<?xml version=\"1.0\"?>\n"
                    + "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"
                    + "<xsl:template match=\"/\">\n"
                    + "<entries>\n"
                    + "   <xsl:for-each select=\"entries/entry\">\n"
                    + "       <entry>\n"
                    + "           <xsl:attribute name=\"href\">\n"
                    + "               <xsl:value-of select=\"field\"/>\n"
                    + "           </xsl:attribute>\n"
                    + "       </entry>\n"
                    + "   </xsl:for-each>\n"
                    + " </entries>\n"
                    + "</xsl:template>\n"
                    + "</xsl:stylesheet>\n");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
