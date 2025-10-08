
package com.servicio.ServiciosWebProyecto.resources;

import com.entidades.Cliente;
import com.entidades.LoginRequest;
import com.modelo.ClienteDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
    private final ClienteDao dao = new ClienteDao();
    
    @GET
    public Response listarClientes(){
        List<Cliente> lista = dao.listarClientes();
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
    }
    
    @GET
    @Path("buscarid")
    public Response buscarClienteId(@QueryParam("p_idCliente") Integer p_idCliente){
        List<Cliente> lista = dao.buscarCliente(p_idCliente);
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista.get(0)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
        }
    }
    
    @POST
    @Path("login")
    public Response login(LoginRequest consulta){
        List<Cliente> lista = dao.loginCliente(consulta);
        if(lista != null && !lista.isEmpty()){
            return Response.ok(lista.get(0)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario o contraseña incorrectos").build();
        }
    }
    
    @POST
    public Response insertarCliente(Cliente cli){
        try {
            dao.insertarCliente(cli);
            return Response.status(Response.Status.CREATED).entity("Cliente insertado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al insertar el cliente: " + e.getMessage()).build();
        }
    }
    
    @PUT
    public Response actualizarCliente(Cliente cli){
        try {
            dao.actualizarCliente(cli);
            return Response.ok("Cliente actualizado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al actualizar el cliente: " + e.getMessage()).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarCliente(@PathParam("id") int id){
        try {
            dao.eliminarCliente(id);
            return Response.ok("Cliente eliminado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al eliminar el cliente: " + e.getMessage()).build();
        }
    }
}
