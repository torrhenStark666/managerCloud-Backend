/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.cor;

import br.com.awasis.manangerbackend.model.Cor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface CorService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Cor cp);
    public Cor save(Cor cp);
    public Optional<Cor> update(Cor cp, long id);
    public boolean delete(long id);          
    
}
