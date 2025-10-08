
package com.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoHabitaciones")
public class TipoHabitaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoHabitacion")
    private int idTipoHabitacion;
    
    @Column(name = "nombreTipoHabitacion")
    private String nombreTipoHabitacion;
    
    @Column(name = "descripcionTipoHabitacion", length = 250)
    private String descripcionTipoHabitacion;
    
    @Column(name = "estadoTipoHabitacion")
    private Boolean estadoTipoHabitacion;

    public TipoHabitaciones(int idTipoHabitacion, String nombreTipoHabitacion, String descripcionTipoHabitacion, Boolean estadoTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nombreTipoHabitacion = nombreTipoHabitacion;
        this.descripcionTipoHabitacion = descripcionTipoHabitacion;
        this.estadoTipoHabitacion = estadoTipoHabitacion;
    }

    public TipoHabitaciones() {
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getNombreTipoHabitacion() {
        return nombreTipoHabitacion;
    }

    public void setNombreTipoHabitacion(String nombreTipoHabitacion) {
        this.nombreTipoHabitacion = nombreTipoHabitacion;
    }

    public String getDescripcionTipoHabitacion() {
        return descripcionTipoHabitacion;
    }

    public void setDescripcionTipoHabitacion(String descripcionTipoHabitacion) {
        this.descripcionTipoHabitacion = descripcionTipoHabitacion;
    }

    public Boolean getEstadoTipoHabitacion() {
        return estadoTipoHabitacion;
    }

    public void setEstadoTipoHabitacion(Boolean estadoTipoHabitacion) {
        this.estadoTipoHabitacion = estadoTipoHabitacion;
    }
    
    
       
}
