/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tituloPagar;

import br.com.awasis.manangerbackend.model.TituloPagar;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TituloPagarService {

    public Optional findById(long id);
    public List findAll();
    public List find(TituloPagar cp);
    public Optional save(TituloPagar cp);
/*    public Optional<TituloPagar> update(TituloPagar cp, long id);*/
    public boolean delete(long id);  
    
}
