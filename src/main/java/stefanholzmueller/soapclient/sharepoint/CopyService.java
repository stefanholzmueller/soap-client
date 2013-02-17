package stefanholzmueller.soapclient.sharepoint;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.commons.beanutils.BeanUtils;

import stefanholzmueller.soapclient.sharepoint.copy.CopyIntoItems;
import stefanholzmueller.soapclient.sharepoint.copy.CopyResultCollection;
import stefanholzmueller.soapclient.sharepoint.copy.CopySoap;
import stefanholzmueller.soapclient.sharepoint.copy.DestinationUrlCollection;
import stefanholzmueller.soapclient.sharepoint.copy.FieldInformationCollection;

public class CopyService implements CopySoap {

    @Override
    @WebMethod(operationName = "CopyIntoItemsLocal", action = "http://schemas.microsoft.com/sharepoint/soap/CopyIntoItemsLocal")
    @RequestWrapper(localName = "CopyIntoItemsLocal", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", className = "stefanholzmueller.soapclient.sharepoint.copy.CopyIntoItemsLocal")
    @ResponseWrapper(localName = "CopyIntoItemsLocalResponse", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", className = "stefanholzmueller.soapclient.sharepoint.copy.CopyIntoItemsLocalResponse")
    public void copyIntoItemsLocal(
            @WebParam(name = "SourceUrl", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/") String sourceUrl,
            @WebParam(name = "DestinationUrls", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/") DestinationUrlCollection destinationUrls,
            @WebParam(name = "CopyIntoItemsLocalResult", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", mode = Mode.OUT) Holder<Long> copyIntoItemsLocalResult,
            @WebParam(name = "Results", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", mode = Mode.OUT) Holder<CopyResultCollection> results) {
        // TODO Auto-generated method stub

    }

    @Override
    @WebMethod(operationName = "CopyIntoItems", action = "http://schemas.microsoft.com/sharepoint/soap/CopyIntoItems")
    @RequestWrapper(localName = "CopyIntoItems", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", className = "stefanholzmueller.soapclient.sharepoint.copy.CopyIntoItems")
    @ResponseWrapper(localName = "CopyIntoItemsResponse", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", className = "stefanholzmueller.soapclient.sharepoint.copy.CopyIntoItemsResponse")
    public void copyIntoItems(
            @WebParam(name = "SourceUrl", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/") String sourceUrl,
            @WebParam(name = "DestinationUrls", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/") DestinationUrlCollection destinationUrls,
            @WebParam(name = "Fields", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/") FieldInformationCollection fields,
            @WebParam(name = "Stream", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/") byte[] stream,
            @WebParam(name = "CopyIntoItemsResult", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", mode = Mode.OUT) Holder<Long> copyIntoItemsResult,
            @WebParam(name = "Results", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", mode = Mode.OUT) Holder<CopyResultCollection> results) {

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("sourceUrl", sourceUrl);
        properties.put("destinationUrls", destinationUrls);
        properties.put("fields", fields);
        properties.put("stream", stream);

        try {
            CopyIntoItems copyIntoItems = new CopyIntoItems();
            BeanUtils.populate(copyIntoItems, properties);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @WebMethod(operationName = "GetItem", action = "http://schemas.microsoft.com/sharepoint/soap/GetItem")
    @RequestWrapper(localName = "GetItem", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", className = "stefanholzmueller.soapclient.sharepoint.copy.GetItem")
    @ResponseWrapper(localName = "GetItemResponse", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", className = "stefanholzmueller.soapclient.sharepoint.copy.GetItemResponse")
    public void getItem(
            @WebParam(name = "Url", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/") String url,
            @WebParam(name = "GetItemResult", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", mode = Mode.OUT) Holder<Long> getItemResult,
            @WebParam(name = "Fields", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", mode = Mode.OUT) Holder<FieldInformationCollection> fields,
            @WebParam(name = "Stream", targetNamespace = "http://schemas.microsoft.com/sharepoint/soap/", mode = Mode.OUT) Holder<byte[]> stream) {
        // TODO Auto-generated method stub

    }

}
