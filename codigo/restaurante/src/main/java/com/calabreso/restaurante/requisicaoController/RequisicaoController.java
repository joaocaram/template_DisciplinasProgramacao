package com.calabreso.restaurante.requisicaoController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(value = "/requisicao")
@RestController
public class RequisicaoController {

    @GetMapping("/teste")
    private String teste(){
        return "Cardápio Vegano";
    }
   
}
