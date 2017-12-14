
package org.me.auction;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CalculatorWS", targetNamespace = "http://auction.me.org/", wsdlLocation = "http://localhost:8080/CalculatorWS/AuctionWS?wsdl")
public class CalculatorWS
    extends Service
{

    private final static URL CALCULATORWS_WSDL_LOCATION;
    private final static WebServiceException CALCULATORWS_EXCEPTION;
    private final static QName CALCULATORWS_QNAME = new QName("http://auction.me.org/", "CalculatorWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/CalculatorWS/AuctionWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCULATORWS_WSDL_LOCATION = url;
        CALCULATORWS_EXCEPTION = e;
    }

    public CalculatorWS() {
        super(__getWsdlLocation(), CALCULATORWS_QNAME);
    }

    public CalculatorWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALCULATORWS_QNAME, features);
    }

    public CalculatorWS(URL wsdlLocation) {
        super(wsdlLocation, CALCULATORWS_QNAME);
    }

    public CalculatorWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCULATORWS_QNAME, features);
    }

    public CalculatorWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuctionWS
     */
    @WebEndpoint(name = "AuctionWSPort")
    public AuctionWS getAuctionWSPort() {
        return super.getPort(new QName("http://auction.me.org/", "AuctionWSPort"), AuctionWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuctionWS
     */
    @WebEndpoint(name = "AuctionWSPort")
    public AuctionWS getAuctionWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://auction.me.org/", "AuctionWSPort"), AuctionWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALCULATORWS_EXCEPTION!= null) {
            throw CALCULATORWS_EXCEPTION;
        }
        return CALCULATORWS_WSDL_LOCATION;
    }

}