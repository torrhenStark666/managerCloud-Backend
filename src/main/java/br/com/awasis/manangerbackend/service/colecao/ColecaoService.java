/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.colecao;

import br.com.awasis.manangerbackend.model.Colecao;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface ColecaoService {

    public Optional findById(long id);
    public List findAll();
    public List find(Colecao cp);
    public Colecao save(Colecao cp);
    public Optional<Colecao> update(Colecao cp, long id);
    public boolean delete(long id);    
    
}
