package javaquinho.comidinhas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaquinho.comidinhas.models.Menu;
import javaquinho.comidinhas.repositories.MenuRepository;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired private MenuRepository repository;

    @GetMapping("")
    public List<Menu> getAllByRestauranteId(){
        return repository.findAll();
    }

    // @GetMapping("/produtos/{id}")
    // public ResponseEntity<Menu> getProduto(@RequestParam Long id){
    //     Optional<Menu> produto = repository.findByProdutoId(id);

    //     return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
    // }

    @PostMapping
    public Menu criarMenu(@RequestBody Menu menu) {
        return repository.save(menu);
    }
    
}
