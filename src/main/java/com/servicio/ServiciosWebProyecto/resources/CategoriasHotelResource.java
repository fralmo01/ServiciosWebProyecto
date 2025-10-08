
package com.servicio.ServiciosWebProyecto.resources;

import com.entidades.CategoriasHotel;
import com.modelo.CategoriasHotelDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriasHotelResource {
    private final CategoriasHotelDao dao = new CategoriasHotelDao();
    
    @GET
    public Response listarCategorias(){
        List<CategoriasHotel> lista = dao.listarCategoriasHotel();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("basico")
    public Response listarCategoriasBasico(){
        List<CategoriasHotel> lista = dao.listarCategoriasHotelBasico();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response insertarCategoria(CategoriasHotel categoria){
        try {
            dao.insertarCategoria(categoria);
            return Response.status(Response.Status.CREATED).entity("Categoria insertada correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @PUT
    public Response actualizarCategoria(CategoriasHotel categoria){
        try {
            dao.actualizarCategoria(categoria);
            return Response.ok("Categoria actualizada correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
    
    @DELETE
    @Path("/id")
    public Response eliminarCategoria(@PathParam("id") int id){
        try {
            dao.eliminarCategoria(id);
            return Response.ok("Categoria Eliminada Correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Categoria insertada correctamente").build();
        }
    }
}
