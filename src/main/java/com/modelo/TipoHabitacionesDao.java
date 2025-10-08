
package com.modelo;

import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List;
import com.entidades.TipoHabitaciones;
import jakarta.persistence.ParameterMode;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;

public class TipoHabitacionesDao {
    
    public List<TipoHabitaciones> listarTipoHabitaciones(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            List<TipoHabitaciones> lista = sn.createQuery("from TipoHabitaciones", TipoHabitaciones.class).list();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar los tipos de habitaciones: " + e);
        }
        return null;
    }
    
    public void insertarTipoHabitacion(TipoHabitaciones tipo){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.persist(tipo);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error la insertar el tipo de habitacion: " + e);
        }
    }
    
    public void actualizarTipoHabitacion(TipoHabitaciones tipo){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.merge(tipo);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el tipo de habitacion: " + e);
        }
    }
    
    public void eliminarTipoHabitacion(int idTipoHabitacion){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            TipoHabitaciones tipoHabitacion = sn.find(TipoHabitaciones.class, idTipoHabitacion);
            if(tipoHabitacion != null){
                sn.remove(tipoHabitacion);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el tipo de habitacion: " + e);
        }
    }
    
    public List<TipoHabitaciones> listarTipoHabitacionesBasico(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            ProcedureCall sp = sn.createStoredProcedureCall("sp_listarTipoHabitaciones", TipoHabitaciones.class);
            
            ProcedureOutputs salidas = sp.getOutputs();
            ResultSetOutput consultaSalida = (ResultSetOutput) salidas.getCurrent();
            
            @SuppressWarnings("unchecked")
            List<TipoHabitaciones> lista = consultaSalida.getResultList();
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar los tipos de habitaciones basico: " + e);
        }
        return null;
    }
}
