
package com.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private int idCliente;
    
    @Column(name = "nombreUsuario", length = 20, nullable = false)
    private String nombreUsuario;
    
    @Column(name = "apellidoPaterno", length = 20, nullable = false)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", length = 20, nullable = false)
    private String apellidoMaterno;
    
    @Column(name = "email", unique = true, length = 500)
    private String email;
    
    @Column(name = "usuario", unique = true, length = 50)
    private String usuario;
    
    @Column(name = "pass", length = 500)
    private String pass;
    
    @Column(name = "estadoCliente")
    private Boolean estadoCliente;

    public Cliente(int idCliente, String nombreUsuario, String apellidoPaterno, String apellidoMaterno, String email, String usuario, String pass, Boolean estadoCliente) {
        this.idCliente = idCliente;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.usuario = usuario;
        this.pass = pass;
        this.estadoCliente = estadoCliente;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(Boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    
    
    
}
