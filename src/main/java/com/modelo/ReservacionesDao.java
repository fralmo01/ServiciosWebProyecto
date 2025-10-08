
package com.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import com.entidades.Reservaciones;

public class ReservacionesDao {
    
    public List<Reservaciones> listarReservas(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            List<Reservaciones> lista = sn.createQuery( "from Reservaciones" ,Reservaciones.class).list();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar las reservas: " + e);
        }
        return null;
    }
    
    public void insertarReserva(Reservaciones reserva){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.persist(reserva);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar la reserva: " + e);
        }
    }
    
    public void actualizarReserva(Reservaciones reserva){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar la reserva: " + e);
        }
    }
    
    public void eliminarReserva(int idReserva){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            Reservaciones reserva = sn.find(Reservaciones.class, idReserva);
            if(reserva != null){
                sn.remove(reserva);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar la reserva: " + e);
        }
    }
    
}
