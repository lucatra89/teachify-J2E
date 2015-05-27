/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mwt.teachify.presentation.webservice;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TError;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestList;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestTutors;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TStatusRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutorInfoList;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.Error;
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
	
    private Error createErrorFromException(Exception e) {
        TError info = new TError();
        info.setCode(1);
        info.setMessage(e.getMessage());
        return new Error("Exception", info, e);
    }
    
    public long createTutor(TTutor tutor) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorDescription(TTutor tutor) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorLocation(TTutor tutor) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorPrice(TTutor tutor) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateTutorContact(TTutor tutor) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public TTutorInfoList searchTutors(TRequestTutors requestTutors) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public long createRequest(TRequest tRequest) throws Error {
    	Request request = null;
    	try{
    		request = Converter.toRequest(tRequest);
    		service.createRequest(request);
    	}catch(Exception e){
    		throw createErrorFromException(e);
    	}
        return request.getId();
    }

    public void updateStatusRequest(TRequest request) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public TRequestList findWaitingRequestsByTutor(TTutor tutor) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public TRequestList findRequestsByUser(TUser user) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public TStatusRequest statusOfRequest(TUser user, TTutor tutor) throws Error {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public TTutor findTutorByPK(long id) throws Error {
    	try {
        	return Converter.fromTutor(service.findTutorByPk(id));
		} catch (Exception e) {
			throw createErrorFromException(e);
		}
    }
    
}
