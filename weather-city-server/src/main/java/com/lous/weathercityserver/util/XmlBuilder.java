package com.lous.weathercityserver.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @ClassName : XmlBuilder
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
 
public class XmlBuilder {

    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // XML 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (reader != null) {
            reader.close();
        }
        return xmlObject;
    }

}
