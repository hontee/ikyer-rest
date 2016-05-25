package com.ikyer.master.api.rest;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ikyer.master.api.data.domain.Menu;
import com.ikyer.master.api.data.form.MenuForm;
import com.ikyer.master.api.service.MenuService;

@Path("menus")
@Produces(MediaType.APPLICATION_JSON)
public class MenuRest {
	
	@Inject
	private MenuService menuS;
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") Long id) {
		return Response.ok(menuS.findOne(id)).build();
	}
	
	@POST
	@Path("create")
	public Response addMenu(@BeanParam MenuForm form) {
		return Response.ok(menuS.addMenu(form)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		menuS.delete(id);
		return Response.ok("删除成功").build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") Long id, @BeanParam MenuForm form) {
		Menu menu = menuS.update(id, form);
		return Response.ok(menu).build();
	}
	
	@GET
	@Path("/list")
	public Response findAll() {
		return Response.ok(menuS.findAll()).build();
		
	}
	
	@GET
	@Path("/list/{page}")
	public Response listPages(@PathParam("page") Integer page) {
		Page<Menu> pages = menuS.findAll(new PageRequest(page, 20));
		return Response.ok(pages).build();
	}

}
