package com.ikyer.master.api.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikyer.master.api.service.RecommendService;

@Path("recommends")
@Produces(MediaType.APPLICATION_JSON)
public class RecommendRest {
	
	@Inject
	private RecommendService recommendS;
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") Long id) {
		return Response.ok(recommendS.findOne(id)).build();
	}

}
