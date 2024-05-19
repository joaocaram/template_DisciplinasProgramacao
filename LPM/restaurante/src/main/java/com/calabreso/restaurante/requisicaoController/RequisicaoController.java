package com.calabreso.restaurante.requisicaoController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calabreso.restaurante.entity.Cliente;
import com.calabreso.restaurante.entity.Mesa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(value = "/requisicao")
@RestController
public class RequisicaoController {

    @PostMapping("/criar")
    public Cliente criarCliente(@RequestParam("nome") String nome) {
        return new Cliente(nome);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable("id") int id) {
    }

    @GetMapping("/mesa/{id}")
    public Mesa getMesa(@PathVariable("id") int id) {
    }

    @PostMapping("/mesa/{id}/ocupar")
    public void ocuparMesa(@PathVariable("id") int id) {
    }

    @PostMapping("/mesa/{id}/desocupar")
    public void desocuparMesa(@PathVariable("id") int id) {
    }

    @GetMapping("/mesa/{id}/liberada/{quantPessoas}")
    public boolean estahLiberada(@PathVariable("id") int id, @PathVariable("quantPessoas") int quantPessoas) {
    }

    @GetMapping("/mesa/{id}/descricao")
    public String getDescricaoMesa(@PathVariable("id") int id) {
    }

    @GetMapping("/mesa/{id}/id")
    public int getIdMesa(@PathVariable("id") int id) {
    }

    @GetMapping("/mesa/{id}/capacidade")
    public int getCapacidadeMesa(@PathVariable("id") int id) {
    }
    
    @GetMapping("/mesa/{id}/ocupada")
    public boolean getOcupadaMesa(@PathVariable("id") int id) {
    }

    @GetMapping("/mesa/{id}/cliente")
    public Cliente getClienteMesa(@PathVariable("id") int id) {
    }

    @PostMapping("/mesa/{id}/cliente/{idCliente}")
    public void setClienteMesa(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}")
    public boolean clienteEstaNaMesa(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/nome")
    public String getNomeClienteMesa(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/id")
    public int getIdClienteMesa(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/descricao")
    public String getDescricaoClienteMesa(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/idMesa")
    public int getIdMesaCliente(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/ocupada")
    public boolean getOcupadaCliente(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/quantPessoas")
    public int getQuantPessoasCliente(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/idMesa")
    public int getIdMesaCliente(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }

    @GetMapping("/mesa/{id}/cliente/{idCliente}/id")
    public int getIdCliente(@PathVariable("id") int id, @PathVariable("idCliente") int idCliente) {
    }
    
   
}
