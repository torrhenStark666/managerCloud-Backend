/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.natureza;

import br.com.awasis.manangerbackend.model.Natureza;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface NaturezaService {

    public Optional findById(long id);
    public List findAll();
    public List find(Natureza cp);
    public Natureza save(Natureza cp);
    public Optional<Natureza> update(Natureza cp, long id);
    public boolean delete(long id);   
    
}
