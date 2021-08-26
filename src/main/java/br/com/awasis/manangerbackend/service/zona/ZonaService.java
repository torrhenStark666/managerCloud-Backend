/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.zona;

import br.com.awasis.manangerbackend.model.Zona;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface ZonaService {

    public Optional findById(long id);
    public List findAll();
    public List find(Zona cp);
    public Zona save(Zona cp);
    public Optional<Zona> update(Zona cp, long id);
    public boolean delete(long id);  
    
}
