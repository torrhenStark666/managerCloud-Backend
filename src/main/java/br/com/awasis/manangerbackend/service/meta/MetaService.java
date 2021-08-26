/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.meta;

import br.com.awasis.manangerbackend.model.Meta;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface MetaService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Meta cp);
    public Meta save(Meta cp);
    public Optional<Meta> update(Meta cp, long id);
    public boolean delete(long id);      
    
}
