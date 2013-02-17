package stefanholzmueller.soapclient.soap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import stefanholzmueller.soapclient.sharepoint.copy.CopyIntoItems;
import stefanholzmueller.soapclient.sharepoint.copy.DestinationUrlCollection;
import stefanholzmueller.soapclient.sharepoint.copy.FieldInformation;
import stefanholzmueller.soapclient.sharepoint.copy.FieldInformationCollection;
import stefanholzmueller.soapclient.sharepoint.copy.FieldType;

public class SoapRequestTest {

    @Test
    public void buildCopyIntoItems() throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("sourceUrl", "&");
        properties.put("destinationUrls", buildDestinationUrlCollection());
        properties.put("fields", buildFieldInformationCollection());
        properties.put("stream", "test äöüß &<".getBytes("UTF-8"));

        CopyIntoItems copyIntoItems = new CopyIntoItems();
        BeanUtils.populate(copyIntoItems, properties);

        String xml = SoapRequest.fromObject(copyIntoItems);
        String expected = stringFromFile("CopyIntoItems.xml");

        assertThat(xml, is(expected));
    }

    private DestinationUrlCollection buildDestinationUrlCollection() {
        DestinationUrlCollection destinationUrlCollection = new DestinationUrlCollection();
        destinationUrlCollection.getString().add("myDestinationUrl1");
        destinationUrlCollection.getString().add("myDestinationUrl2");
        return destinationUrlCollection;
    }

    private FieldInformationCollection buildFieldInformationCollection() {
        FieldInformation fieldInformation = new FieldInformation();
        fieldInformation.setDisplayName("field1displayName");
        fieldInformation.setInternalName("field1internalName");
        fieldInformation.setType(FieldType.NUMBER);
        fieldInformation.setValue("field1value");

        FieldInformationCollection fieldInformationCollection = new FieldInformationCollection();
        fieldInformationCollection.getFieldInformation().add(fieldInformation);
        return fieldInformationCollection;
    }

    private String stringFromFile(String fileName) throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
        return IOUtils.toString(resourceAsStream, "UTF-8");
    }
}
