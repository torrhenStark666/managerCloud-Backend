/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.marca;

import br.com.awasis.manangerbackend.model.Marca;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface MarcaService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Marca cp);
    public Marca save(Marca cp);
    public Optional<Marca> update(Marca cp, long id);
    public boolean delete(long id);       
    
}
