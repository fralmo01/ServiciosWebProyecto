
package com.entidades;

public class LoginRequest {
    private String p_usuario;
    private String p_pass;

    public LoginRequest(String p_usuario, String p_pass) {
        this.p_usuario = p_usuario;
        this.p_pass = p_pass;
    }

    public LoginRequest() {
    }

    public String getP_usuario() {
        return p_usuario;
    }

    public void setP_usuario(String p_usuario) {
        this.p_usuario = p_usuario;
    }

    public String getP_pass() {
        return p_pass;
    }

    public void setP_pass(String p_pass) {
        this.p_pass = p_pass;
    }
    
    
}
