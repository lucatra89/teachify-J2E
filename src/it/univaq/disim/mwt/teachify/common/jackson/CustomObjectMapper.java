package it.univaq.disim.mwt.teachify.common.jackson;

import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public CustomObjectMapper() {
		super();
		this.addMixIn(Lesson.class, LessonMixIn.class);
		this.addMixIn(Availability.class, AvailabilityMixIn.class);
		this.addMixIn(User.class, UserMixIn.class);
	}

}
