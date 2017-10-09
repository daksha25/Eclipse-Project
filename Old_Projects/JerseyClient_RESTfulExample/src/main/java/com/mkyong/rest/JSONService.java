package com.mkyong.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.mkyong.Track;
import com.mkyong.Track1;
import com.mkyong.Track_List;

@Path("/json/metallica")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}

	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	//public Response createTrackInJSON(Track track) {
	
	public Response createTrackInJSON(Track1 tl) {
		
		List<Track_List> out= tl.getstudents();
	
		
		return Response.status(201).entity(out).build();
		
	}
	
}