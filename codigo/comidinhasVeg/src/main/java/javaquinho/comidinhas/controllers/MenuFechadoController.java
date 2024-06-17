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

import javaquinho.comidinhas.excecoes.LimiteProdutosException;
import javaquinho.comidinhas.models.Menu;
import javaquinho.comidinhas.models.MenuFechado;
import javaquinho.comidinhas.models.Produto;
import javaquinho.comidinhas.repositories.MenuFechadoRepository;

@RestController
@RequestMapping("/menus-fechados")
public class MenuFechadoController {

    @Autowired 
    private MenuFechadoRepository repository;

    @GetMapping("")
    public List<MenuFechado> getAllByRestauranteId() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuFechado> getProduto(@PathVariable Long id) {
        Optional<MenuFechado> menu = repository.findById(id);
        return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MenuFechado criarMenu(@RequestBody MenuFechado menu) {
        MenuFechado retornoMenu = repository.save(menu);
        return retornoMenu;
    }

    @PutMapping("/adicionarProduto")
    public ResponseEntity<String> adicionarProduto(@RequestParam Long menuId, @RequestBody Produto produto) {
        Optional<MenuFechado> optionalMenu = repository.findById(menuId);
        if (optionalMenu.isPresent()) {
            MenuFechado menu = optionalMenu.get();
            try{
                menu.adicionarProduto(produto);
                repository.save(menu);

                return ResponseEntity.ok("Produto adicionado com sucesso!");
            } 
            catch (LimiteProdutosException e){
                return ResponseEntity.status(400).body(e.getMessage());
            }
            
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/adicionarProduto/all")
    public ResponseEntity<String> adicionarProduto(@RequestParam Long menuId, @RequestBody List<Produto> produtos){
        MenuFechado menu = repository.findById(menuId).orElse(null);
        if (menu != null){
            for (Produto p : produtos) {
                try {
                    menu.adicionarProduto(p);
                }
                catch(LimiteProdutosException e){
                    return ResponseEntity.status(400).body(e.getMessage());
                }
            }

            repository.save(menu);
            return ResponseEntity.ok().body("Produtos adicionados com sucesso!");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
