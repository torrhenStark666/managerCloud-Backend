/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.cliente;

import br.com.awasis.manangerbackend.model.Cliente;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author alecsander
 */


public interface ClienteService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Cliente cp);
    public Cliente save(Cliente cp);
    public Optional<Cliente> update(Cliente cp, long id);
    public boolean delete(long id);       
    
}
