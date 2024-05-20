package javaquinho.comidinhas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaquinho.comidinhas.models.Mesa;
import javaquinho.comidinhas.repositories.MesaRepository;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private MesaRepository mesaRepository;

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable int id) {
        Mesa mesa = mesaRepository.findById(id).get();
        return ResponseEntity.ok(mesa);
    }

    @PostMapping
    public Mesa createMesa(@RequestBody Mesa mesa){
        return mesaRepository.save(mesa);
    }
}
