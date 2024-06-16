package javaquinho.comidinhas.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javaquinho.comidinhas.models.Menu;
import javaquinho.comidinhas.models.Produto;
import javaquinho.comidinhas.repositories.MenuRepository;
import javaquinho.comidinhas.repositories.ProdutoRepository;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired 
    private MenuRepository repository;

    @Autowired 
    private ProdutoRepository repositorioProduto;

    @GetMapping("")
    public List<Menu> getAllByRestauranteId() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getProduto(@PathVariable Long id) {
        Optional<Menu> menu = repository.findById(id);
        return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Menu criarMenu(@RequestBody Menu menu) {
        Menu retornoMenu = repository.save(menu);
        return retornoMenu;
    }

    @PutMapping("/adicionarProduto")
    public ResponseEntity<Menu> adicionarProduto(@RequestParam Long menuId, @RequestBody Produto produto) {
        Optional<Menu> optionalMenu = repository.findById(menuId);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            menu.adicionarProduto(produto);
            return ResponseEntity.ok(repository.save(menu));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/adicionarProduto/all")
    public ResponseEntity<Menu> adicionarProduto(@RequestParam Long menuId, @RequestBody List<Produto> produtos){
        Menu menu = repository.findById(menuId).orElse(null);
        if (menu != null){
            for (Produto p : produtos) {
                menu.adicionarProduto(p);
            }
            return ResponseEntity.ok(repository.save(menu));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
