/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.modelo;

import br.com.awasis.manangerbackend.model.Modelo;
import br.com.awasis.manangerbackend.repository.ModeloRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ModeloServiceImpl implements ModeloService {
    
    @Autowired
    private ModeloRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(ModeloSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Modelo cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = ModeloSpecification.addClausula(where, ModeloSpecification.byDescricaoSpecification(cp.getDescricao()) );
        }
        
        return repository.findAll(where);
    }

    @Override
    public Modelo save(Modelo cp) {
        //Regra de negocio
        return repository.save(cp);
    }

    @Override
    public Optional<Modelo> update(Modelo cp, long id) {
         return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());

                     
                     Modelo updated = repository.save(record);
                     return updated;
                 
                 });
    }

    @Override
    public boolean delete(long id) {
        if(id <= 0){
            repository.deleteById(id);
            return true;
            
        }else{
            return false;
        }
    }
    
}
