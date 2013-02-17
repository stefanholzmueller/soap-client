package stefanholzmueller.soapclient.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import stefanholzmueller.soapclient.sharepoint.copy.CopyIntoItems;
import stefanholzmueller.soapclient.sharepoint.copy.DestinationUrlCollection;
import stefanholzmueller.soapclient.sharepoint.copy.FieldInformation;
import stefanholzmueller.soapclient.sharepoint.copy.FieldInformationCollection;
import stefanholzmueller.soapclient.sharepoint.copy.FieldType;

public class JaxbTest {

    @Test
    public void marshalNull() throws Exception {

        String xml = Jaxb.marshalFragment(null);

        assertThat(xml, is(""));
    }

    @Test
    public void marshalCopyIntoItems() throws Exception {
        CopyIntoItems copyIntoItems = buildExampleObject();

        String xml = Jaxb.marshalFragment(copyIntoItems);
        String expected = stringFromFile("CopyIntoItems.xml");

        assertThat(xml, is(expected));
    }

    private CopyIntoItems buildExampleObject() {
        DestinationUrlCollection destinationUrlCollection = buildDestinationUrlCollection();

        FieldInformationCollection fieldInformationCollection = buildFieldInformationCollection();

        CopyIntoItems copyIntoItems = new CopyIntoItems();
        copyIntoItems.setDestinationUrls(destinationUrlCollection);
        copyIntoItems.setFields(fieldInformationCollection);
        copyIntoItems.setSourceUrl("mySourceUrl");
        copyIntoItems.setStream(new byte[] { 40, 45, 50 });

        return copyIntoItems;
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
