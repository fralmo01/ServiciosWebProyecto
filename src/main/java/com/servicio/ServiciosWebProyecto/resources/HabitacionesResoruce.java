
package com.servicio.ServiciosWebProyecto.resources;

import com.entidades.Habitaciones;
import com.modelo.HabitacionesDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("habitaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabitacionesResoruce {
    private final HabitacionesDao dao = new HabitacionesDao();
    
    @GET
    public Response listarHabitaciones(){
        List<Habitaciones> lista = dao.listarHabitaciones();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @GET
    @Path("basico")
    public Response listarHabitacionesBasico(){
        List<Habitaciones> lista = dao.listarHabitacionesBasico();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @POST
    public Response insertarHabitacion(Habitaciones habitacion){
        try {
            dao.insertarHabitacion(habitacion);
            return Response.status(Response.Status.CREATED).entity("habitacion insertada correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @PUT
    public Response actualizarHabitacion(Habitaciones habitacion){
        try {
            dao.actualizarHabitacion(habitacion);
            return Response.ok("habitacion actualizada correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @DELETE
    @Path("/id")
    public Response eliminarHabitacion(@PathParam("id") int id){
        try {
            dao.eliminarHabitacion(id);
            return Response.ok("Habitacion Eliminada Correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
}
