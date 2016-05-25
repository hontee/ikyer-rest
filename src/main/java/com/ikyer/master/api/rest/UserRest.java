package com.ikyer.master.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.ikyer.master.api.service.UserService;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {

	@Autowired
	private UserService userS;
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") Long id) {
		return Response.ok(userS.findOne(id)).build();
	}
}
