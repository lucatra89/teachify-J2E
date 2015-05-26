
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TeachifyInterface", targetNamespace = "http://www.univaq.t/mwt/soa/teachify")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TeachifyInterface {


    /**
     * 
     * @param tutor
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#createTutor")
    public void createTutor(
        @WebParam(name = "tutor", partName = "tutor")
        TTutor tutor)
        throws Error
    ;

    /**
     * 
     * @param description
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#updateTutorDescription")
    public void updateTutorDescription(
        @WebParam(name = "description", partName = "description")
        String description)
        throws Error
    ;

    /**
     * 
     * @param location
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#updateTutorLocation")
    public void updateTutorLocation(
        @WebParam(name = "location", partName = "location")
        TLocation location)
        throws Error
    ;

    /**
     * 
     * @param price
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#updateTutorPrice")
    public void updateTutorPrice(
        @WebParam(name = "price", partName = "price")
        TPrice price)
        throws Error
    ;

    /**
     * 
     * @param contact
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#updateTutorContact")
    public void updateTutorContact(
        @WebParam(name = "contact", partName = "contact")
        TContact contact)
        throws Error
    ;

    /**
     * 
     * @param requestTutors
     * @return
     *     returns t.univaq.mwt.soa.teachify.TTutorInfoList
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#searchTutors")
    @WebResult(name = "tutorInfoList", partName = "tutorInfoList")
    public TTutorInfoList searchTutors(
        @WebParam(name = "requestTutors", partName = "requestTutors")
        TRequestTutors requestTutors)
        throws Error
    ;

    /**
     * 
     * @param request
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#createRequest")
    public void createRequest(
        @WebParam(name = "request", partName = "request")
        TRequest request)
        throws Error
    ;

    /**
     * 
     * @param status
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#updateStatusRequest")
    public void updateStatusRequest(
        @WebParam(name = "status", partName = "status")
        TStatusRequest status)
        throws Error
    ;

    /**
     * 
     * @param tutor
     * @return
     *     returns t.univaq.mwt.soa.teachify.TRequestList
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#findWaitingRequestsByTutor")
    @WebResult(name = "requests", partName = "requests")
    public TRequestList findWaitingRequestsByTutor(
        @WebParam(name = "tutor", partName = "tutor")
        TTutor tutor)
        throws Error
    ;

    /**
     * 
     * @param user
     * @return
     *     returns t.univaq.mwt.soa.teachify.TRequestList
     * @throws Error
     */
    @WebMethod(action = "findRequestsByUser")
    @WebResult(name = "requests", partName = "requests")
    public TRequestList findRequestsByUser(
        @WebParam(name = "user", partName = "user")
        TUser user)
        throws Error
    ;

    /**
     * 
     * @param user
     * @param tutor
     * @return
     *     returns t.univaq.mwt.soa.teachify.TStatusRequest
     * @throws Error
     */
    @WebMethod(action = "TeachifyInterface#statusOfRequest")
    @WebResult(name = "status", partName = "status")
    public TStatusRequest statusOfRequest(
        @WebParam(name = "user", partName = "user")
        TUser user,
        @WebParam(name = "tutor", partName = "tutor")
        TTutor tutor)
        throws Error
    ;

}