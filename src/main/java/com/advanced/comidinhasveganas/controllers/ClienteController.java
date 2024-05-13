package com.advanced.comidinhasveganas.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.advanced.comidinhasveganas.models.Cliente;
import com.advanced.comidinhasveganas.services.ClienteServices;

import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = this.clienteServices.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Cliente> Id(@PathVariable Long Id){
        Cliente obj = this.clienteServices.buscarPeloId(Id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Cliente obj){
        this.clienteServices.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{Id}").buildAndExpand(obj.getIdCliente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping ("/{Id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Cliente obj, @PathVariable Long Id){
        obj.setIdCliente(Id);  
        this.clienteServices.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id){
        this.clienteServices.delete(Id);
        return ResponseEntity.noContent().build();
    }
    
}
