/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.transportadora;

import br.com.awasis.manangerbackend.model.Transportadora;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TransportadoraService {

    public Optional findById(long id);
    public List findAll();
    public List find(Transportadora cp);
    public Transportadora save(Transportadora cp);
    public Optional<Transportadora> update(Transportadora cp, long id);
    public boolean delete(long id);    
}
