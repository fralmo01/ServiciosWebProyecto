
package com.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hoteles")
public class Hoteles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHotel")
    private int idHotel;
    
    @Column(name = "nombreHotel", length = 300)
    private String nombreHotel;
    
    @Column(name = "direccion", length = 500)
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "idCategoriaHotel")
    private CategoriasHotel categoriaAsignada;
    
    @Column(name = "estadoHotel")
    private Boolean estadoHotel;

    public Hoteles(int idHotel, String nombreHotel, String direccion, CategoriasHotel categoriaAsignada, Boolean estadoHotel) {
        this.idHotel = idHotel;
        this.nombreHotel = nombreHotel;
        this.direccion = direccion;
        this.categoriaAsignada = categoriaAsignada;
        this.estadoHotel = estadoHotel;
    }

    public Hoteles() {
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CategoriasHotel getCategoriaAsignada() {
        return categoriaAsignada;
    }

    public void setCategoriaAsignada(CategoriasHotel categoriaAsignada) {
        this.categoriaAsignada = categoriaAsignada;
    }

    public Boolean getEstadoHotel() {
        return estadoHotel;
    }

    public void setEstadoHotel(Boolean estadoHotel) {
        this.estadoHotel = estadoHotel;
    }

    
}
