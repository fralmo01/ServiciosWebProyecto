
package com.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entidades.Habitaciones;
import java.util.List;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;

public class HabitacionesDao {
    
    public List<Habitaciones> listarHabitaciones(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            List<Habitaciones> lista = sn.createQuery("from Habitaciones ", Habitaciones.class).list();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar las habitaciones: " + e);
        }
        return null;
    }
    
    public void insertarHabitacion(Habitaciones habi){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.persist(habi);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar Habitacion: " + e);
        }
    }
    
    public void actualizarHabitacion(Habitaciones habi){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.merge(habi);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar Habitacion: " + e);
        }
    }
    
    public void eliminarHabitacion(int idHabitacion){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            Habitaciones habi = sn.find(Habitaciones.class, idHabitacion);
            if(habi != null){
                sn.remove(habi);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar Habitacion: " + e);
        }
    }    
    
    public List<Habitaciones> listarHabitacionesBasico(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            ProcedureCall sp = sn.createStoredProcedureCall("sp_listarHabitaciones", Habitaciones.class);
            
            ProcedureOutputs salidas = sp.getOutputs();
            ResultSetOutput consultaSalida = (ResultSetOutput) salidas.getCurrent();
            
            @SuppressWarnings("unchecked")
            List<Habitaciones> lista = consultaSalida.getResultList();
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar las habitacionas basico: " + e);
        }
        return null;
    }
}
