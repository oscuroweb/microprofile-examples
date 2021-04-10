package oscuroweb.microprofile.speaker.controller;

import oscuroweb.microprofile.speaker.dao.SpeakerDAO;
import oscuroweb.microprofile.speaker.model.Speaker;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class ResourceSpeaker {

  @Context private UriInfo uriInfo;

  @Inject private SpeakerDAO speakerDAO;

  @GET
  public Collection<Speaker> retrieveAll() {
    return speakerDAO.retrieveAll();
  }

  @GET
  @Path("/{id}")
  public Speaker retrievebyId(@PathParam("id") final Long id) {
    return speakerDAO.retrieve(id).orElse(new Speaker(0l, "Unknown", "Unknown"));
  }

  @POST
  public Speaker add(final Speaker speaker) {
    return speakerDAO.add(speaker);
  }

  @DELETE
  @Path("/{id}")
  public void remove(@PathParam("id") final Long id) {
    speakerDAO.delete(id);
  }

  @PUT
  @Path("/{id}")
  public Speaker update(@PathParam("id") final String id, final Speaker speaker) {
    return speakerDAO.update(speaker);
  }
}
