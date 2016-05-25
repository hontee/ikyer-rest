package com.ikyer.master.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.ikyer.master.api.auto.config.WebFetchClient;
import com.ikyer.master.api.auto.config.WebInfo;

@Path("fetch")
@Produces(MediaType.APPLICATION_JSON)
public class WebFetchRest {
	
	@Autowired
	private WebFetchClient client;
	
	@GET
	public Response webFetch(@QueryParam("url") String url) {
		WebInfo webInfo = client.fetch(url);
		return Response.ok(webInfo).build();
	}
	

}
