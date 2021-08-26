/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.regiao;

import br.com.awasis.manangerbackend.model.Regiao;
import br.com.awasis.manangerbackend.repository.RegiaoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RegiaoServiceImpl implements RegiaoService {
    
    @Autowired
    private RegiaoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(RegiaoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Regiao cp) {
        
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = RegiaoSpecification.addClausula(where, RegiaoSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        return repository.findAll(where);
        
    }

    @Override
    public Regiao save(Regiao cp) {
        // Regra de negocio
        return  repository.save(cp);
    }

    @Override
    public Optional<Regiao> update(Regiao cp, long id) {
        return repository.findById(id)
                .map(record ->{
                   record.setDescricao(cp.getDescricao());
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
