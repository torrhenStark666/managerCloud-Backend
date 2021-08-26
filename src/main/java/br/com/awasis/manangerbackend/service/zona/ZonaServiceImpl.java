/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.zona;

import br.com.awasis.manangerbackend.model.Zona;
import br.com.awasis.manangerbackend.repository.ZonaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ZonaServiceImpl implements ZonaService {
    
    @Autowired
    private ZonaRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(ZonaSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Zona cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = ZonaSpecification.addClausula(where, ZonaSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        if(cp.getRegiao() != null) {
            if(cp.getRegiao().getIdRegiao() > 0){
                where = ZonaSpecification.addClausula(where, ZonaSpecification.byIdRegiaoSpecification(cp.getRegiao().getIdRegiao()));
            }
            if(!cp.getRegiao().getDescricao().isEmpty() || !cp.getRegiao().getDescricao().isBlank()){
                where = ZonaSpecification.addClausula(where, ZonaSpecification.byDescricaoRegiaoSpecification(cp.getRegiao().getDescricao()));
            }
        }
        
        return repository.findAll(where);
    }

    @Override
    public Zona save(Zona cp) {
        //Regra de negocio
        return repository.save(cp);
    }

    @Override
    public Optional<Zona> update(Zona cp, long id) {
        return repository.findById(id)
                .map(record ->{
                   record.setDescricao(cp.getDescricao());
                   record.setRegiao(cp.getRegiao());
                   return repository.save(record);
        });
    }

    @Override
    public boolean delete(long id) {
                if(id <=0){
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
