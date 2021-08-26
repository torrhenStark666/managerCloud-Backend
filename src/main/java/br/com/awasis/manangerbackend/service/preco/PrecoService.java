/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.preco;

import br.com.awasis.manangerbackend.model.Preco;
import br.com.awasis.manangerbackend.model.Setor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface PrecoService {

    public Optional findById(long id);
    public List findAll();
    public List find(Preco cp);
    public Preco save(Preco cp);
    public Optional<Preco> update(Preco cp, long id);
    public boolean delete(long id);      
    
}
