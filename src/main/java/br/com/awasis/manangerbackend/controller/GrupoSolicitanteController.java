/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.controller;

import br.com.awasis.manangerbackend.model.GrupoSolicitante;
import br.com.awasis.manangerbackend.service.grupoSolicitante.GrupoSolicitanteService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequestMapping({"/grupos-solicitantes"})
public class GrupoSolicitanteController {
    
    
    private GrupoSolicitanteService service;
    
    @GetMapping
    public List findAll(){
        return service.findAll();
    }
    
    @PostMapping(path = {"/find"})
    public List findByProperties(@RequestBody GrupoSolicitante gf){
        return service.find(gf);
    }
    
    @PostMapping
    public GrupoSolicitante save(@RequestBody GrupoSolicitante gf){
        return service.save(gf);
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return (ResponseEntity) service.findById(id)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping(path = {"/{id}"})
    public ResponseEntity update(@PathVariable long id, @RequestBody GrupoSolicitante gf){
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
