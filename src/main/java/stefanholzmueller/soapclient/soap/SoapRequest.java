package stefanholzmueller.soapclient.soap;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import stefanholzmueller.soapclient.util.Jaxb;

public class SoapRequest {

    public static String fromObject(Object object) throws JAXBException {
        if (isXmlRootElement(object)) {
            String start = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body>";
            String fragment = Jaxb.marshalFragment(object);
            String end = "</soapenv:Body></soapenv:Envelope>";

            return start + fragment + end;
        } else {
            throw new IllegalArgumentException("object is no XmlRootElement");
        }
    }

    private static boolean isXmlRootElement(Object object) {
        return object.getClass().getAnnotation(XmlRootElement.class) != null;
    }
}
