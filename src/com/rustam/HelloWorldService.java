package com.rustam;

import java.io.File;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("/customers")
//@Path("/download")
public class HelloWorldService {

	
	@GET
	@Produces("text/html")
	public Response getLocalCust(@QueryParam("namekey")String name,@QueryParam("countrykey")String country){
		
		
		
		String output = "Customer Name "+name+" Country -"+country;
		
		return Response.status(200).entity(output).build();
		
	}
	@GET
	@Path("/nri")
	@Produces("text/html")
	public Response getNriCust(){
		
		String out = "I am from 'getNriCust' method";
		
		return Response.status(200).entity(out).build();
	}
	
	@GET
	@Path("{name}/{country}")
	@Produces("text/html")
	public Response getResultByPassingValue(@PathParam("name")String name, @PathParam("country")String country){		
		
		String output = "Customer Nmae "+name+" Country - "+country;
		
		return Response.status(200).entity(output).build();
		
	}
	
	
	@POST
	@Path("/addCustomer")
	@Produces("text/html")
	public Response getFormValue(@FormParam("name")String name,@FormParam("country")String country){
		
		String output = "Customer Name "+name+", Country "+country;
		
		return Response.status(200).entity(output).build();
	}
	
	
	
	@GET
	@Path("/data")
	@Produces("text/pain")
	
	public Response getCustomerDataFile(){
		
		String path = "C:\\Users\\hp\\Desktop\\command1.txt";
		File file = new File(path);
		
		ResponseBuilder rb = Response.ok((Object)file);
		
		rb.header("Content-Disposition","attachment; filename=java4sFileFromServer.txt");
		
		return rb.build();
		
	}
	
	@GET
	@Path("/{custNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer produceCustomerDetails(@PathParam("custNo")int no){
		
		Customer customer = new Customer();
		customer.setCustNo(no);
		customer.setCountryName("India");
		customer.setCustName("Rustam");
		
		return customer;
		
	}
	
	

}
