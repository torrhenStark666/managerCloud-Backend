/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tituloReceber;

import br.com.awasis.manangerbackend.model.TituloReceber;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TituloReceberService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(TituloReceber cp);
    public Optional save(TituloReceber cp);
/*    public Optional<TituloPagar> update(TituloPagar cp, long id);*/
    public boolean delete(long id);      
    
}
