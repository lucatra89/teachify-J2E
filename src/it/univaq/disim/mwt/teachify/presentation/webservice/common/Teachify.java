
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

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
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Teachify", targetNamespace = "http://www.univaq.t/mwt/soa/teachify", wsdlLocation = "file:/Users/lucatraini/Developer/NetBeansProjects/teachify_ws/src/conf/xml-resources/web-services/NewWebServiceFromWSDL/wsdl/Teachify.wsdl")
public class Teachify
    extends Service
{

    private final static URL TEACHIFY_WSDL_LOCATION;
    private final static WebServiceException TEACHIFY_EXCEPTION;
    private final static QName TEACHIFY_QNAME = new QName("http://www.univaq.t/mwt/soa/teachify", "Teachify");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/Users/lucatraini/Developer/NetBeansProjects/teachify_ws/src/conf/xml-resources/web-services/NewWebServiceFromWSDL/wsdl/Teachify.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TEACHIFY_WSDL_LOCATION = url;
        TEACHIFY_EXCEPTION = e;
    }

    public Teachify() {
        super(__getWsdlLocation(), TEACHIFY_QNAME);
    }

    public Teachify(WebServiceFeature... features) {
        super(__getWsdlLocation(), TEACHIFY_QNAME, features);
    }

    public Teachify(URL wsdlLocation) {
        super(wsdlLocation, TEACHIFY_QNAME);
    }

    public Teachify(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TEACHIFY_QNAME, features);
    }

    public Teachify(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Teachify(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TeachifyInterface
     */
    @WebEndpoint(name = "TeachifySOAPPort")
    public TeachifyInterface getTeachifySOAPPort() {
        return super.getPort(new QName("http://www.univaq.t/mwt/soa/teachify", "TeachifySOAPPort"), TeachifyInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TeachifyInterface
     */
    @WebEndpoint(name = "TeachifySOAPPort")
    public TeachifyInterface getTeachifySOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.univaq.t/mwt/soa/teachify", "TeachifySOAPPort"), TeachifyInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TEACHIFY_EXCEPTION!= null) {
            throw TEACHIFY_EXCEPTION;
        }
        return TEACHIFY_WSDL_LOCATION;
    }

}
