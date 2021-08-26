/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.controller;

import br.com.awasis.manangerbackend.model.TituloPagar;
import br.com.awasis.manangerbackend.service.tituloPagar.TituloPagarService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alecsander
 */

@AllArgsConstructor
@RestController
@RequestMapping({"/titulos-pagar"})
public class TituloPagarController {
    
    private TituloPagarService service;

    @GetMapping
    public List findAll(){
        return service.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return (ResponseEntity) service.findById(id)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity save(@RequestBody TituloPagar b){
        return (ResponseEntity) service.save(b)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.notFound().build());
    }
            
    @PostMapping(path = {"/find"})
    public List findByProperties(@RequestBody TituloPagar b){
        return service.find(b);
    }
    /*
    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TituloPagar b){
        return service.update(b, id)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.notFound().build());
    }*/
    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity delete(@PathVariable long id) {
        return (ResponseEntity) service.findById(id)
               .map(record -> {
                   if(service.delete(id) == true){
                       return ResponseEntity.ok().build();
                   }else{
                       return ResponseEntity.noContent().build();
                   }
               }).orElse(ResponseEntity.notFound().build());
    }    
}
