/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mwt.teachify.presentation.webservice;

import java.util.List;

import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.impl.JDBCTutorService;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.Error;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TContact;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TLocation;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TPrice;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestList;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestTutors;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TStatusRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutorInfoList;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser;
import it.univaq.disim.mwt.teachify.presentation.webservice.util.Converter;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.serviceEndpointInterfaceMappingType;

/**
 *
 * @author lucatraini
 */
@WebService(serviceName = "Teachify", portName = "TeachifySOAPPort", endpointInterface = "it.univaq.disim.mwt.teachify.presentation.webservice.common.TeachifyInterface", targetNamespace = "http://www.univaq.t/mwt/soa/teachify", wsdlLocation = "WEB-INF/wsdl/NewWebServiceFromWSDL/Teachify.wsdl")
public class TeachifyWebService extends SpringBeanAutowiringSupport{
	@Autowired
	private TutorService tutorService ;

    public void createTutor(it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor tutor) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorDescription(java.lang.String description) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorLocation(it.univaq.disim.mwt.teachify.presentation.webservice.common.TLocation location) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorPrice(it.univaq.disim.mwt.teachify.presentation.webservice.common.TPrice price) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorContact(it.univaq.disim.mwt.teachify.presentation.webservice.common.TContact contact) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutorInfoList searchTutors(it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestTutors requestTutors) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void createRequest(it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequest request) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateStatusRequest(it.univaq.disim.mwt.teachify.presentation.webservice.common.TStatusRequest status) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestList findWaitingRequestsByTutor(it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor tutor) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        List<Request> requests =  tutorService.findWaitingRequestsByTutor(Converter.toTutor(tutor));
        return Converter.fromRequestList(requests);
    }

    public it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestList findRequestsByUser(it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser user) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public it.univaq.disim.mwt.teachify.presentation.webservice.common.TStatusRequest statusOfRequest(it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser user, it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor tutor) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
