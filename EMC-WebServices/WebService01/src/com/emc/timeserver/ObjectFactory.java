
package com.emc.timeserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.timeserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTimeFromServerResponse_QNAME = new QName("http://timeserver.emc.com/", "getTimeFromServerResponse");
    private final static QName _GetTicketFare_QNAME = new QName("http://timeserver.emc.com/", "getTicketFare");
    private final static QName _GetTimeAsString_QNAME = new QName("http://timeserver.emc.com/", "getTimeAsString");
    private final static QName _GetTimeFromServer_QNAME = new QName("http://timeserver.emc.com/", "getTimeFromServer");
    private final static QName _GetTicketFareResponse_QNAME = new QName("http://timeserver.emc.com/", "getTicketFareResponse");
    private final static QName _GetTimeAsStringResponse_QNAME = new QName("http://timeserver.emc.com/", "getTimeAsStringResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.timeserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTicketFareResponse }
     * 
     */
    public GetTicketFareResponse createGetTicketFareResponse() {
        return new GetTicketFareResponse();
    }

    /**
     * Create an instance of {@link GetTimeAsStringResponse }
     * 
     */
    public GetTimeAsStringResponse createGetTimeAsStringResponse() {
        return new GetTimeAsStringResponse();
    }

    /**
     * Create an instance of {@link GetTimeAsString }
     * 
     */
    public GetTimeAsString createGetTimeAsString() {
        return new GetTimeAsString();
    }

    /**
     * Create an instance of {@link GetTimeFromServer }
     * 
     */
    public GetTimeFromServer createGetTimeFromServer() {
        return new GetTimeFromServer();
    }

    /**
     * Create an instance of {@link GetTicketFare }
     * 
     */
    public GetTicketFare createGetTicketFare() {
        return new GetTicketFare();
    }

    /**
     * Create an instance of {@link GetTimeFromServerResponse }
     * 
     */
    public GetTimeFromServerResponse createGetTimeFromServerResponse() {
        return new GetTimeFromServerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeFromServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://timeserver.emc.com/", name = "getTimeFromServerResponse")
    public JAXBElement<GetTimeFromServerResponse> createGetTimeFromServerResponse(GetTimeFromServerResponse value) {
        return new JAXBElement<GetTimeFromServerResponse>(_GetTimeFromServerResponse_QNAME, GetTimeFromServerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketFare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://timeserver.emc.com/", name = "getTicketFare")
    public JAXBElement<GetTicketFare> createGetTicketFare(GetTicketFare value) {
        return new JAXBElement<GetTicketFare>(_GetTicketFare_QNAME, GetTicketFare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeAsString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://timeserver.emc.com/", name = "getTimeAsString")
    public JAXBElement<GetTimeAsString> createGetTimeAsString(GetTimeAsString value) {
        return new JAXBElement<GetTimeAsString>(_GetTimeAsString_QNAME, GetTimeAsString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeFromServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://timeserver.emc.com/", name = "getTimeFromServer")
    public JAXBElement<GetTimeFromServer> createGetTimeFromServer(GetTimeFromServer value) {
        return new JAXBElement<GetTimeFromServer>(_GetTimeFromServer_QNAME, GetTimeFromServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketFareResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://timeserver.emc.com/", name = "getTicketFareResponse")
    public JAXBElement<GetTicketFareResponse> createGetTicketFareResponse(GetTicketFareResponse value) {
        return new JAXBElement<GetTicketFareResponse>(_GetTicketFareResponse_QNAME, GetTicketFareResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeAsStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://timeserver.emc.com/", name = "getTimeAsStringResponse")
    public JAXBElement<GetTimeAsStringResponse> createGetTimeAsStringResponse(GetTimeAsStringResponse value) {
        return new JAXBElement<GetTimeAsStringResponse>(_GetTimeAsStringResponse_QNAME, GetTimeAsStringResponse.class, null, value);
    }

}
