
package com.modelo;

import org.hibernate.Transaction;
import org.hibernate.Session;
import com.entidades.Hoteles;
import java.util.List;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;

public class HotelesDao {
    
    public List<Hoteles> listarHoteles(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            List<Hoteles> lista = sn.createQuery("from Hoteles", Hoteles.class).list();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar Hoteles: " + e);
        }
        return null;
    }
    
    public void insertarHotel(Hoteles hotel){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.persist(hotel);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar el hotel: " + e);
        }
    }
    
    public void actualizarHotel(Hoteles hotel){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.merge(hotel);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el hotel: " + e);
        }
    }

    public void eliminarHotel(int idHotel){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            Hoteles hotel = sn.find(Hoteles.class, idHotel);
            if(hotel != null){
                sn.remove(hotel);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el hotel: " + e);
        }
    }
    
    public List<Hoteles> listarHotelesBasico(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            ProcedureCall sp = sn.createStoredProcedureCall("sp_listarHoteles", Hoteles.class);
            
            ProcedureOutputs salidas = sp.getOutputs();
            ResultSetOutput consultaSalida = (ResultSetOutput) salidas.getCurrent();
            
            @SuppressWarnings("unchecked")
            List<Hoteles> lista = consultaSalida.getResultList();
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar los hoteles basico: " + e);
        }
        return null;
    }
    
}
