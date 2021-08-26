/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.ItemAutorizado;

import br.com.awasis.manangerbackend.model.ItemAutorizado;
import br.com.awasis.manangerbackend.repository.ItemAutorizadoRepository;
import br.com.awasis.manangerbackend.repository.SolicitanteRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ItemAutorizadoServiceImpl implements ItemAutorizadoService {

    @Autowired
    private ItemAutorizadoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(ItemAutorizadoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(ItemAutorizado cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemAutorizado save(ItemAutorizado cp) {
        return repository.save(cp);
    }

    @Override
    public Optional<ItemAutorizado> update(ItemAutorizado cp, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
            repository.deleteById(id);
            return true;
            
        }else{
            return false;
        }
    }
    
}
