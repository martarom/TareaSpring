package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ClienteDTO;
import com.example.demo.DTO.ClienteListDTO;
import com.example.demo.model.Cliente;
import com.example.demo.servicio.ClienteService;

@RestController
public class ClienteController {
	@Autowired
    private ClienteService service;
	
	@GetMapping("/api")
    public String apiHome (){
        return "Hola";
    }
	
	@GetMapping("/api/clientes")
    public ClienteListDTO getAll(){
        List<Cliente> listado = service.findAll();
        if (listado == null){
            return new ClienteListDTO(true, null, "Ha habido un problema con la BBDD");
        }
        return new ClienteListDTO(false, listado, "");
    }
	 @GetMapping("/api/clientes/{id}")
	    public ClienteDTO getByID(@PathVariable Long id){
	        try {
	            Cliente ret= service.findById(id).get();
	            return new ClienteDTO(false,ret, "");
	        }catch (NoSuchElementException e){
	            return new ClienteDTO(true, null, "Cliente no encontrado");
	        }
	    }    
	 @PutMapping("/api/clientes/{id}")
	    public ClienteDTO updateById(
	            @PathVariable Long id,
	            @RequestBody @Validated Cliente clienteModificar){
	        try {
	            Cliente ret= service.findById(id).get();
	            ret.setTelefono(clienteModificar.getTelefono());
	            ret.setNombre(clienteModificar.getNombre());
	            service.update(ret);
	            return new ClienteDTO(false,ret, "");
	        }catch (NoSuchElementException e){
	            return new ClienteDTO(true, null, "Cliente no encontrado");
	        }
	    }
	    @DeleteMapping("/api/clientes/{id}")
	    public ClienteDTO deleteByID(@PathVariable Long id){
	        try {
	            Cliente ret= service.findById(id).get();
	            service.deleteById(id);
	            return new ClienteDTO(false,ret, "");
	        }catch (NoSuchElementException e){
	            return new ClienteDTO(true, null, "Cliente no encontrado");
	        }
	    }
}
