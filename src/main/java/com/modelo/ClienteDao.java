
package com.modelo;

import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List;
import com.entidades.Cliente;
import com.entidades.LoginRequest;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;
import jakarta.persistence.ParameterMode;

public class ClienteDao {
    public List<Cliente> listarClientes(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            List<Cliente> lista = sn.createQuery("from Cliente", Cliente.class).list();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar los clientes: " + e);
        }
        return null;
    } 
    
    public void insertarCliente(Cliente cli) {
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.persist(cli);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar el cliente: " + e);
        }
    }
    
    public void actualizarCliente(Cliente cli){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.merge(cli);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente: " + e);
        }
    }
    
    public void eliminarCliente(int idCliente){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            Cliente cli = sn.find(Cliente.class, idCliente);
            if(cli != null){
                sn.remove(cli);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e);
        }
    }
    
    public List<Cliente> loginCliente(LoginRequest consulta) {
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {

            ProcedureCall sp = sn.createStoredProcedureCall("sp_login", Cliente.class);

            sp.registerParameter(1, String.class , ParameterMode.IN);
            sp.registerParameter(2, String.class , ParameterMode.IN);

            sp.setParameter(1, consulta.getP_usuario());
            sp.setParameter(2, consulta.getP_pass());

            ProcedureOutputs salidas = sp.getOutputs();
            ResultSetOutput consultaSalida = (ResultSetOutput) salidas.getCurrent();

            @SuppressWarnings("unchecked")
            List<Cliente> lista = consultaSalida.getResultList();

            return lista;
            
        } catch (Exception e) {
            System.out.println("Error al logear al cliente: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Cliente> buscarCliente(Integer idCliente){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            ProcedureCall sp = sn.createStoredProcedureCall("sp_buscarCliente", Cliente.class);
            
            sp.registerParameter(1, Integer.class, ParameterMode.IN);
            sp.setParameter(1, idCliente);
            
            ProcedureOutputs salidas = sp.getOutputs();
            ResultSetOutput consultaSalida = (ResultSetOutput) salidas.getCurrent();
            
            @SuppressWarnings("unchecked")
            List<Cliente> lista = consultaSalida.getResultList();
            
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente: " + e);
        }
        return null;
    }
}
