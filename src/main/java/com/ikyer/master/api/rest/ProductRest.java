package com.ikyer.master.api.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikyer.master.api.service.ProductService;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
public class ProductRest {
	
	@Inject
	private ProductService productS;
	
	@GET
    @Path("{id}")
	public Response findById(@PathParam("id") Long id) {
		return Response.ok(productS.findOne(id)).build();
	}

}
