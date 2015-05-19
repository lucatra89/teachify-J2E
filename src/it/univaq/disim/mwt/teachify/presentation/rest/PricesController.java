package it.univaq.disim.mwt.teachify.presentation.rest;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.EducationService;
import it.univaq.disim.mwt.teachify.business.model.Price;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/rest/prices")

public class PricesController {
	@Autowired
	private EducationService service;
		
	@RequestMapping (method = RequestMethod.GET, produces= "application/json")
	public @ResponseBody List<Price> findAll () {
		return service.findAllPrices();
	}
	
	@PreAuthorize("hasRole('admin')")
	@RequestMapping (method = RequestMethod.POST , consumes="application/json", produces="text/plain")
	public ResponseEntity<String> create(RequestEntity<Price> request ) {
		
		Price price = request.getBody();
		service.createPrice(price);
	
		URI uri = request.getUrl();
	    String id = Long.toString(price.getId());
	    
	    URI location = 	UriComponentsBuilder.fromUri(uri).path("/{id}").build().expand(id).toUri();
	    	    
	    return ResponseEntity.created(location).body(id);
	}
	
	@PreAuthorize("hasRole('admin')")
	@RequestMapping (value="/{id:[0-9]+}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id) {
		
		Price price = new Price();
		price.setId(id);
		
		service.deletePrice(price);
	    	    	    
	    return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BusinessException.class})
    public void handle(){}
}
