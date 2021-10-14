package com.example.demo.servicio;


import com.example.demo.model.Cliente;
import com.example.demo.repositorio.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
	 @Autowired
	    private ClienteRepository repository;

	    public List<Cliente> findAll() {
	        return repository.findAll();
	    }


	    public Optional<Cliente> findById(Long id) {
	        return repository.findById(id);
	    }

	    public void deleteById(Long id) {
	        repository.deleteById(id);
	    }

	    public Cliente update(Cliente ret) {
	        return repository.save(ret);
	    }

}
