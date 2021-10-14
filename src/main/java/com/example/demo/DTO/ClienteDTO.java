package com.example.demo.DTO;

import com.example.demo.model.Cliente;

import lombok.Data;


@Data

public class ClienteDTO {
	 private Boolean errors;
	    private Cliente data;
	    private String message;

	    public ClienteDTO(Boolean b, Cliente data, String message){
	        this.errors = b;
	        this.data = data;
	        this.message = message;
	    }

}
