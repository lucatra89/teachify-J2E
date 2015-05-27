/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mwt.teachify.presentation.webservice;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.Error;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TError;
import it.univaq.disim.mwt.teachify.presentation.webservice.util.Converter;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author lucatraini
 */
@WebService(serviceName = "Teachify", portName = "TeachifySOAPPort", endpointInterface = "it.univaq.disim.mwt.teachify.presentation.webservice.common.TeachifyInterface", targetNamespace = "http://www.univaq.it/mwt/soa/teachify", wsdlLocation = "WEB-INF/wsdl/TeachifyWebService/Teachify.wsdl")
public class TeachifyWebService extends SpringBeanAutowiringSupport{
	@Autowired
	TutorService service;
	
    private Error createErrorFromBusinessException(BusinessException e) {
        TError info = new TError();
        info.setCode(1);
        info.setMessage(e.getMessage());
        return new Error("Exception", info, e);
    }

    public void createTutor(it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor tutor) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
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
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestList findRequestsByUser(it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser user) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public it.univaq.disim.mwt.teachify.presentation.webservice.common.TStatusRequest statusOfRequest(it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser user, it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor tutor) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor findTutorByPK(long id) throws it.univaq.disim.mwt.teachify.presentation.webservice.common.Error {
    	try {
        	return Converter.fromTutor(service.findTutorByPk(id));
		} catch (BusinessException e) {
			throw createErrorFromBusinessException(e);
		}
    }
    
}
