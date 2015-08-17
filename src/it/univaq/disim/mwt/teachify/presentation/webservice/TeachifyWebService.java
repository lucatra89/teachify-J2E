/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mwt.teachify.presentation.webservice;

import java.util.List;

import it.univaq.disim.mwt.teachify.business.TutorInfo;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.StatusRequest;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
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
    
    private Error createError() {
        TError info = new TError();
        info.setCode(2);
        info.setMessage("Richiesta inesistente");
        return new Error("Exception", info);
    }
    
    public long createTutor(TTutor tTutor) throws Error {
        Tutor tutor = null;
        try{
        	tutor = Converter.toTutor(tTutor);
        	service.createTutor(tutor);
        }catch(Exception e){
        	throw createErrorFromException(e);
        }
        
        return tutor.getId();
        
    }

    public void updateTutorDescription(TTutor tTutor) throws Error {
        try {
			service.updateTutorDescription(Converter.toTutor(tTutor));
		} catch (Exception e) {
			throw createErrorFromException(e);
		}
    }

    public void updateTutorLocation(TTutor tTutor) throws Error {
        try {
			service.updateTutorLocation(Converter.toTutor(tTutor));
		} catch (Exception e) {
			throw createErrorFromException(e);
		}
    }

    public void updateTutorPrice(TTutor tTutor) throws Error {
        try {
			service.updateTutorPrice(Converter.toTutor(tTutor));
		} catch (Exception e) {
			throw createErrorFromException(e);
		}
    }

    public void updateTutorContact(TTutor tTutor) throws Error {
        try {
			service.updateTutorContact(Converter.toTutor(tTutor));
		} catch (Exception e) {
			throw createErrorFromException(e);
		}
    }

    public TTutorInfoList searchTutors(TRequestTutors requestTutors) throws Error {
        try {
        	List<TutorInfo> infos = service.searchTutors(Converter.toRequestTutors(requestTutors));
        	for (TutorInfo tutorInfo : infos) {
				System.out.println("DDDDDDDDAAAAAIIIIIIII " + tutorInfo.getId());
			}
			return Converter.fromTutorInfoList(infos);
		} catch (Exception e) {
			throw createErrorFromException(e);
		}
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

    public void updateStatusRequest(TRequest tRequest) throws Error {
    	try {
        	service.updateStatusRequest(Converter.toRequest(tRequest));
		} catch (Exception e) {
    		throw createErrorFromException(e);
		}
    }

    public TRequestList findWaitingRequestsByTutor(TTutor tTutor) throws Error {
    	try {
    		return Converter.fromRequestList(service.findWaitingRequestsByTutor(Converter.toTutor(tTutor)));
		} catch (Exception e) {
    		throw createErrorFromException(e);
		}
    }

    public TRequestList findRequestsByUser(TUser tUser) throws Error {
    	try {
    		List<Request> list = service.findRequestsByUser(Converter.toUser(tUser));

    		return Converter.fromRequestList(list);
		} catch (Exception e) {
    		throw createErrorFromException(e);
		}
    }

    public TStatusRequest statusOfRequest(TUser tUser, TTutor tTutor) throws Error {
    	StatusRequest status = null;
    	try {
    		status = service.statusOfRequest(Converter.toUser(tUser),Converter.toTutor(tTutor));
		} catch (Exception e) {
    		throw createErrorFromException(e);
		}
    	if(status == null){
    		throw createError();
    	}
    	
    	return Converter.fromStatusRequest(status);
    }

    public TTutor findTutorByPK(long id) throws Error {
    	try {
        	return Converter.fromTutor(service.findTutorByPk(id));
		} catch (Exception e) {
			throw createErrorFromException(e);
		}
    }
    
}
