
package com.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Reservaciones")
public class Reservaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservacion")
    private int idReservacion;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente clienteAsignado;
    
    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    private Habitaciones habitacionAsignada;
    
    @Column(name = "fechaReservacion")
    private LocalDate fechaReservacion;
    
    @Column(name = "fechaFinalizacionReserva")
    private LocalDate fechaFinalizacionReserva;
    
    @Column(name = "estadoReserva")
    private Boolean estadoReserva;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    public Reservaciones(int idReservacion, Cliente clienteAsignado, Habitaciones habitacionAsignada, LocalDate fechaReservacion, LocalDate fechaFinalizacionReserva, Boolean estadoReserva, BigDecimal costo) {
        this.idReservacion = idReservacion;
        this.clienteAsignado = clienteAsignado;
        this.habitacionAsignada = habitacionAsignada;
        this.fechaReservacion = fechaReservacion;
        this.fechaFinalizacionReserva = fechaFinalizacionReserva;
        this.estadoReserva = estadoReserva;
        this.costo = costo;
    }

    public Reservaciones() {
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Cliente getClienteAsignado() {
        return clienteAsignado;
    }

    public void setClienteAsignado(Cliente clienteAsignado) {
        this.clienteAsignado = clienteAsignado;
    }

    public Habitaciones getHabitacionAsignada() {
        return habitacionAsignada;
    }

    public void setHabitacionAsignada(Habitaciones habitacionAsignada) {
        this.habitacionAsignada = habitacionAsignada;
    }

    public LocalDate getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(LocalDate fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public LocalDate getFechaFinalizacionReserva() {
        return fechaFinalizacionReserva;
    }

    public void setFechaFinalizacionReserva(LocalDate fechaFinalizacionReserva) {
        this.fechaFinalizacionReserva = fechaFinalizacionReserva;
    }

    public Boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    

    
    
    
}
