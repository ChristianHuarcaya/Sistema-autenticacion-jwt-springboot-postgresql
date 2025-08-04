package com.idat.semana8.dto;

public class JwtResponse {
	
	private String token;
    private String tipo = "Bearer";
    private String email;
    private String rol;

    public JwtResponse(String token, String email, String rol) {
        this.token = token;
        this.email = email;
        this.rol = rol;
    }

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEmail() {
		return email;
	}

	public String getRol() {
		return rol;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
    
    

}
