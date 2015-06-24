package it.univaq.disim.mwt.teachify.presentation.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Tutor;

public class AvailabilityResponse extends Availability {
	@JsonIgnore
	private Tutor tutor;

	public AvailabilityResponse() {
		super();
	}
	
	public AvailabilityResponse(Availability availability) {
		super(availability.getId() , availability.getDay() , availability.getFrom() , availability.getTo());
	}
	
	
}
