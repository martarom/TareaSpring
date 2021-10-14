package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Cliente;

public class ClienteListDTO {
	
	 private Boolean errors;
	    private List<Cliente> data;
	    private String message;

	    public ClienteListDTO(Boolean b, List<Cliente> listado, String message){
	        this.errors = b;
	        this.data = listado;
	        this.message = message;
	    }

}
