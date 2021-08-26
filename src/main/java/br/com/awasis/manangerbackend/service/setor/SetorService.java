/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.setor;

import br.com.awasis.manangerbackend.model.Setor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface SetorService {

    public Optional findById(long id);
    public List findAll();
    public List find(Setor cp);
    public Setor save(Setor cp);
    public Optional<Setor> update(Setor cp, long id);
    public boolean delete(long id);  
    
}
