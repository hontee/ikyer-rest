package com.ikyer.master.api.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.service.TopicService;

@Path("topics")
@Produces(MediaType.APPLICATION_JSON)
public class TopicRest {
	
	@Inject
	private TopicService topicS;
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") Long id) {
		Topic topic = topicS.findOne(id);
		return Response.ok(topic).build();
	}

}
