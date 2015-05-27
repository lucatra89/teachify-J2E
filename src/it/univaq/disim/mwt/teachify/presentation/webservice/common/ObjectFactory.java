
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.mwt.soa.teachify package. 
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

    private final static QName _EError_QNAME = new QName("http://www.univaq.it/mwt/soa/Teachify.xsd1", "EError");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.mwt.soa.teachify
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TError }
     * 
     */
    public TError createTError() {
        return new TError();
    }

    /**
     * Create an instance of {@link TRequestList }
     * 
     */
    public TRequestList createTRequestList() {
        return new TRequestList();
    }

    /**
     * Create an instance of {@link TPrice }
     * 
     */
    public TPrice createTPrice() {
        return new TPrice();
    }

    /**
     * Create an instance of {@link TRequestTutors }
     * 
     */
    public TRequestTutors createTRequestTutors() {
        return new TRequestTutors();
    }

    /**
     * Create an instance of {@link TLesson }
     * 
     */
    public TLesson createTLesson() {
        return new TLesson();
    }

    /**
     * Create an instance of {@link TTutorInfo }
     * 
     */
    public TTutorInfo createTTutorInfo() {
        return new TTutorInfo();
    }

    /**
     * Create an instance of {@link TTypeOfEducation }
     * 
     */
    public TTypeOfEducation createTTypeOfEducation() {
        return new TTypeOfEducation();
    }

    /**
     * Create an instance of {@link TTutor }
     * 
     */
    public TTutor createTTutor() {
        return new TTutor();
    }

    /**
     * Create an instance of {@link TRequest }
     * 
     */
    public TRequest createTRequest() {
        return new TRequest();
    }

    /**
     * Create an instance of {@link TAvailability }
     * 
     */
    public TAvailability createTAvailability() {
        return new TAvailability();
    }

    /**
     * Create an instance of {@link TLocation }
     * 
     */
    public TLocation createTLocation() {
        return new TLocation();
    }

    /**
     * Create an instance of {@link TUser }
     * 
     */
    public TUser createTUser() {
        return new TUser();
    }

    /**
     * Create an instance of {@link TTutorInfoList }
     * 
     */
    public TTutorInfoList createTTutorInfoList() {
        return new TTutorInfoList();
    }

    /**
     * Create an instance of {@link THour }
     * 
     */
    public THour createTHour() {
        return new THour();
    }

    /**
     * Create an instance of {@link TSubject }
     * 
     */
    public TSubject createTSubject() {
        return new TSubject();
    }

    /**
     * Create an instance of {@link TContact }
     * 
     */
    public TContact createTContact() {
        return new TContact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.univaq.it/mwt/soa/Teachify.xsd1", name = "EError")
    public JAXBElement<TError> createEError(TError value) {
        return new JAXBElement<TError>(_EError_QNAME, TError.class, null, value);
    }

}
