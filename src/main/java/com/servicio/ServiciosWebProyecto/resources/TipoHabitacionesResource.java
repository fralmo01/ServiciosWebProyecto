
package com.servicio.ServiciosWebProyecto.resources;

import com.entidades.TipoHabitaciones;
import com.modelo.TipoHabitacionesDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("tipohabitacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoHabitacionesResource {
    private final TipoHabitacionesDao dao = new TipoHabitacionesDao();
    
    @GET
    public Response listarTipoHabitacion(){
        List<TipoHabitaciones> lista = dao.listarTipoHabitaciones();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @GET
    @Path("basico")
    public Response listarTipoHabitacionesBasico(){
        List<TipoHabitaciones> lista = dao.listarTipoHabitacionesBasico();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @POST
    public Response insertarTipoHabitacion(TipoHabitaciones tipo){
        try {
            dao.insertarTipoHabitacion(tipo);
            return Response.status(Response.Status.CREATED)
                    .entity("Tipo de habitación insertado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al insertar el tipo de habitación: " + e.getMessage()).build();
        }
    }
    
    @PUT
    public Response actualizarTipoHabitacion(TipoHabitaciones tipo){
        try {
            dao.actualizarTipoHabitacion(tipo);
            return Response.ok("Tipo de habitación actualizado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al actualizar el tipo de habitación: " + e.getMessage()).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarTipoHabitacion(@PathParam("id") int id){
        try {
            dao.eliminarTipoHabitacion(id);
            return Response.ok("Tipo de habitación eliminada correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al eliminar el tipo de habitación: " + e.getMessage()).build();
        }
    }
}
