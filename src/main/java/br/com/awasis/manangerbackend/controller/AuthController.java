/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.controller;

import br.com.awasis.manangerbackend.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.awasis.manangerbackend.service.login.UsuarioService;

/**
 *
 * @author alecsander
 */

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping({"/auth"})
public class AuthController {
    
    @Autowired
    private UsuarioService service;
    
    @PostMapping
    public ResponseEntity autenticar(@RequestBody Usuario login){
        
        return ResponseEntity.ok(login);
    }
    
    @PostMapping(path = {"/signup"})
    public ResponseEntity cadastrar(@RequestBody Usuario login){
        var result = service.signup(login);
        
        if(result == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(login);
    }
    
}
