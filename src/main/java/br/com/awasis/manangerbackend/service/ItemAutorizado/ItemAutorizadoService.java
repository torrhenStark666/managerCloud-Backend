/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.ItemAutorizado;

import br.com.awasis.manangerbackend.model.ItemAutorizado;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface ItemAutorizadoService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(ItemAutorizado cp);
    public ItemAutorizado save(ItemAutorizado cp);
    public Optional<ItemAutorizado> update(ItemAutorizado cp, long id);
    public boolean delete(long id);  
    
}
