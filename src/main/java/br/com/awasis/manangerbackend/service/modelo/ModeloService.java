/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.modelo;

import br.com.awasis.manangerbackend.model.Modelo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface ModeloService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Modelo cp);
    public Modelo save(Modelo cp);
    public Optional<Modelo> update(Modelo cp, long id);
    public boolean delete(long id);      
    
}
