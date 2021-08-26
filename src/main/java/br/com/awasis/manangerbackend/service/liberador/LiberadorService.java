/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.liberador;

import br.com.awasis.manangerbackend.model.Liberador;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface LiberadorService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Liberador cp);
    public Liberador save(Liberador cp);
    public Optional<Liberador> update(Liberador cp, long id);
    public boolean delete(long id);  
    
}
