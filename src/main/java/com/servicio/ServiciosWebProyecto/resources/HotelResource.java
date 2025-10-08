
package com.servicio.ServiciosWebProyecto.resources;

import com.entidades.Hoteles;
import com.modelo.HotelesDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("hotel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HotelResource {
    private final HotelesDao dao = new HotelesDao();
    
    @GET
    public Response listarHoteles(){
        List<Hoteles> lista = dao.listarHoteles();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @GET
    @Path("basico")
    public Response listarHotelesBasico(){
        List<Hoteles> lista = dao.listarHotelesBasico();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @POST
    public Response insertarHotel(Hoteles hotel){
        try {
            dao.insertarHotel(hotel);
            return Response.status(Response.Status.CREATED).entity("Hotel insertado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @PUT
    public Response actualizarHotel(Hoteles hotel){
        try {
            dao.actualizarHotel(hotel);
            return Response.ok("Hotel actualizado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @DELETE
    @Path("/id")
    public Response eliminarHotel(@PathParam("id") int id){
        try {
            dao.eliminarHotel(id);
            return Response.ok("Hotel Eliminado Correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
}
