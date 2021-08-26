/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.controller;

import br.com.awasis.manangerbackend.model.GrupoFornecedor;
import br.com.awasis.manangerbackend.service.grupoFornecedor.GrupoFornecedorService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping({"/grupos-fornecedores"})
public class GrupoFornecedorController {
    
    private GrupoFornecedorService service;
    
    @GetMapping
    public List findAll(){
        return service.findAll();
    }
    
    @PostMapping(path = {"/find"})
    public List findByProperties(@RequestBody GrupoFornecedor gf){
        return service.find(gf);
    }
    
    @PostMapping
    public GrupoFornecedor save(@RequestBody GrupoFornecedor gf){
        return service.save(gf);
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return (ResponseEntity) service.findById(id)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping(path = {"/{id}"})
    public ResponseEntity update(@PathVariable long id, @RequestBody GrupoFornecedor gf){
        return service.update(gf, id)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.badRequest().build());
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity delete(@PathVariable long id){
        return (ResponseEntity) service.findById(id)
                .map(record ->{
                    if(service.delete(id)){
                        return ResponseEntity.ok().build();
                    }else{
                        return ResponseEntity.noContent().build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
                
    }
    
}
