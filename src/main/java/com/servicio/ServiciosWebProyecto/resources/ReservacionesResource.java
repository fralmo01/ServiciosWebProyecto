
package com.servicio.ServiciosWebProyecto.resources;

import com.entidades.Reservaciones;
import com.modelo.ReservacionesDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("reservaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservacionesResource {
    private final ReservacionesDao dao = new ReservacionesDao();
    
    @GET
    public Response listarReservaciones(){
        List<Reservaciones> lista = dao.listarReservas();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @POST
    public Response insertarReservaciones(Reservaciones reservacion){
        try {
            dao.insertarReserva(reservacion);
            return Response.status(Response.Status.CREATED).entity("Reservacion insertada correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @PUT
    public Response actualizarReservacion(Reservaciones reservacion){
        try {
            dao.actualizarReserva(reservacion);
            return Response.ok("Reservacion actualizada correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @DELETE
    @Path("/id")
    public Response eliminarReservacion(@PathParam("id") int id){
        try {
            dao.eliminarReserva(id);
            return Response.ok("Reservacion Eliminada Correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
}
