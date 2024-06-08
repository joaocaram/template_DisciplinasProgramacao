package javaquinho.comidinhas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
        return mesaRepository.findById(id)
            .map(mesa -> ResponseEntity.ok(mesa))
            .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable int id, @RequestBody Mesa mesa) {
        return mesaRepository.findById(id)
            .map(mesaData -> {
                mesaData.setOcupada(mesa.isOcupada());
                Mesa updatedMesa = mesaRepository.save(mesaData);
                return ResponseEntity.ok(updatedMesa);
            })
            .orElse(ResponseEntity.notFound().build());
    } 

    @PostMapping
    public Mesa createMesa(@RequestBody Mesa mesa){
        return mesaRepository.save(mesa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mesa> deleteMesa(@PathVariable int id) {
        return mesaRepository.findById(id)
            .map(mesa -> {
                mesaRepository.delete(mesa);
                return ResponseEntity.ok(mesa);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
