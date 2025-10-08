
package com.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entidades.CategoriasHotel;
import java.util.List;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;

public class CategoriasHotelDao {
    
    public List<CategoriasHotel> listarCategoriasHotel(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            List<CategoriasHotel> lista = sn.createQuery("from CategoriasHotel", CategoriasHotel.class).list();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar las categorias: " + e);
        }
        return null;
    }
    
    public void insertarCategoria(CategoriasHotel cate){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            Transaction tx = sn.beginTransaction();
            sn.persist(cate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar una categoria: " + e);
        }
    }
    
    public void actualizarCategoria(CategoriasHotel cate){
 
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
             Transaction tx = sn.beginTransaction();
             sn.merge(cate);
             tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar la categoria: " + e);
        }
    }
    
    public void eliminarCategoria(int idCategoriaHotel){
        
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
           
            Transaction tx = sn.beginTransaction();
            CategoriasHotel cate = sn.find(CategoriasHotel.class, idCategoriaHotel);
            if(cate != null){
                sn.remove(cate);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar la categoria: " + e);
        }
    }
    
    public List<CategoriasHotel> listarCategoriasHotelBasico(){
        try (Session sn = HibernateUtilSingle.obtenerSessionFactory().openSession()) {
            
            ProcedureCall sp = sn.createStoredProcedureCall("sp_listarCategoriasHotel", CategoriasHotel.class);
            
            ProcedureOutputs salidas = sp.getOutputs();
            ResultSetOutput consultaSalida = (ResultSetOutput) salidas.getCurrent();
            
            @SuppressWarnings("unchecked")
            List<CategoriasHotel> lista = consultaSalida.getResultList();
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar las categorias de hotel  basico: " + e);
        }
        return null;
    }
    
}
