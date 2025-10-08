
package com.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CategoriasHotel")
public class CategoriasHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaHotel")
    private int idCategoriaHotel;
    
    @Column(name = "nombreCategoria", length = 200, nullable = false )
    private String nombreCategoria;
    
    @Column(name = "descripcionCategoriaHotel", length = 500, nullable = false)
    private String descripcionCategoriaHotel;
    
    @Column(name = "estadoCategoriaHotel")
    private Boolean estadoCategoriaHotel;

    public CategoriasHotel(int idCategoriaHotel, String nombreCategoria, String descripcionCategoriaHotel, Boolean estadoCategoriaHotel) {
        this.idCategoriaHotel = idCategoriaHotel;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoriaHotel = descripcionCategoriaHotel;
        this.estadoCategoriaHotel = estadoCategoriaHotel;
    }

    public CategoriasHotel() {
    }

    public int getIdCategoriaHotel() {
        return idCategoriaHotel;
    }

    public void setIdCategoriaHotel(int idCategoriaHotel) {
        this.idCategoriaHotel = idCategoriaHotel;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoriaHotel() {
        return descripcionCategoriaHotel;
    }

    public void setDescripcionCategoriaHotel(String descripcionCategoriaHotel) {
        this.descripcionCategoriaHotel = descripcionCategoriaHotel;
    }

    public Boolean getEstadoCategoriaHotel() {
        return estadoCategoriaHotel;
    }

    public void setEstadoCategoriaHotel(Boolean estadoCategoriaHotel) {
        this.estadoCategoriaHotel = estadoCategoriaHotel;
    }
    
    
}
