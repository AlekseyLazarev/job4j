package ru.alazarev.array;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

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
            if (scheme.exists()) {
                Transformer transformer = factory.newTransformer(new StreamSource(scheme));
                transformer.transform(new StreamSource(source), new StreamResult(dest));
            } else {
                System.out.println("Scheme file not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
