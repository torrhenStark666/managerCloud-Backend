/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.controller;

import br.com.awasis.manangerbackend.model.Fornecedor;
import br.com.awasis.manangerbackend.repository.FornecedorRepository;
import br.com.awasis.manangerbackend.service.fornecedor.FornecedorService;
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
@RequestMapping({"/fornecedores"})
public class FornecedorController {
    
    private FornecedorService service;
    private FornecedorRepository repo;

    @GetMapping
    public List findAll(){
        return service.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return service.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Fornecedor save(@RequestBody Fornecedor f){
        return service.save(f);
    }
    
    @PostMapping(path = {"/find"})
    public List findByProperties(@RequestBody Fornecedor f){
        return service.find(f);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Fornecedor f){
        return service.findById(id)
                .map(record ->{
                    record.setCelular(f.getCelular());
                    record.setCnpj(f.getCnpj());
                    record.setContatos(f.getContatos());
                    record.setCpf(f.getCpf());
                    record.setDataUltimaCompra(f.getDataUltimaCompra());
                    record.setEndereco(f.getEndereco());
                    record.setGrupoFornecedor(f.getGrupoFornecedor());
                    record.setInscricaoEstadual(f.getInscricaoEstadual());
                    record.setNomeFantasia(f.getNomeFantasia());
                    record.setPedidos(f.getPedidos());
                    record.setPontuacao(f.getPontuacao());
                    record.setProdutos(f.getProdutos());
                    record.setRazaoSocial(f.getRazaoSocial());
                    record.setTelefoneFixo(f.getTelefoneFixo());
                    record.setTipoFornecedor(f.getTipoFornecedor());
                    
                    Fornecedor updated = service.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
       return service.findById(id)
               .map(record -> {
                   service.delete(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
    
}
