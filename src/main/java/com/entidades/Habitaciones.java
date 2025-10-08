
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
@Table(name = "Habitaciones")
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHabitacion")
    private int idHabitacion;
    
    @Column(name = "nombreHabitacion", length = 50)
    private String nombreHabitacion;
    
    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hoteles hotelAsignado;
    
    @ManyToOne
    @JoinColumn(name = "idTipoHabitacion")
    private TipoHabitaciones tipoHabitacion;
    
    @Column(name = "estadoHabitacion")
    private Boolean estadoHabitacion;

    public Habitaciones(int idHabitacion, String nombreHabitacion, Hoteles hotelAsignado, TipoHabitaciones tipoHabitacion, Boolean estadoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.nombreHabitacion = nombreHabitacion;
        this.hotelAsignado = hotelAsignado;
        this.tipoHabitacion = tipoHabitacion;
        this.estadoHabitacion = estadoHabitacion;
    }

    public Habitaciones() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public Hoteles getHotelAsignado() {
        return hotelAsignado;
    }

    public void setHotelAsignado(Hoteles hotelAsignado) {
        this.hotelAsignado = hotelAsignado;
    }

    public TipoHabitaciones getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitaciones tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Boolean getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(Boolean estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    
    
    
}
