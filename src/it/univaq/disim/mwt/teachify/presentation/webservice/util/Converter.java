package it.univaq.disim.mwt.teachify.presentation.webservice.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestList;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TStatusRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser;

public class Converter {

	public static User toUser(TUser tUser) {
		User user = new User();
		user.setId(tUser.getId());
		user.setName(tUser.getName());
		user.setSurname(tUser.getSurname());
		return user;
	}

	public static TUser fromUser(User user) {
		TUser tUser = new TUser();
		tUser.setId(user.getId());
		tUser.setName(user.getName());
		tUser.setSurname(user.getSurname());
		return tUser;
	}

	public static Tutor toTutor(TTutor tTutor) {
		Tutor tutor = new Tutor();
		tutor.setId(tTutor.getId());
		tutor.setName(tTutor.getName());
		tutor.setSurname(tTutor.getSurname());
		return tutor;
	}

	public static TTutor fromTutor(Tutor tutor) {
		TTutor tTutor = new TTutor();
		tTutor.setId(tutor.getId());
		tTutor.setName(tutor.getName());
		tTutor.setSurname(tutor.getSurname());
		return tTutor;
	}

	public static TRequestList fromRequestList(List<Request> requests) {
		TRequestList tRequestList = new TRequestList();

		for (Request request : requests) {
			tRequestList.getRequests().add(fromRequest(request));
		}

		return tRequestList;
	}

	private static TRequest fromRequest(Request request) {
		TRequest tRequest = new TRequest();
		tRequest.setId(request.getId());
		tRequest.setStatus(TStatusRequest.fromValue(request.getStatus().name()));
		tRequest.setDescription(request.getDescription());
		Date date = request.getCreatedAt();
		tRequest.setCreatedAt(toXMLGregorianCalendar(date));
		tRequest.setUser(fromUser(request.getUser()));
		tRequest.setTutor(fromTutor(request.getTutor()));
		return tRequest;
	}

	private static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		} catch (DatatypeConfigurationException ex) {
		}
		return xmlCalendar;
	}
}
