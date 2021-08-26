/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.movimentacaoBancaria;

import br.com.awasis.manangerbackend.model.Modelo;
import br.com.awasis.manangerbackend.model.MovimentacaoBancaria;
import br.com.awasis.manangerbackend.repository.MovimentacaoBancariaRepository;
import br.com.awasis.manangerbackend.service.modelo.ModeloSpecification;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alecsander-PC
 */

@AllArgsConstructor
@NoArgsConstructor
@Service
public class MovimentacaoBancariaServiceImpl implements MovimentacaoBancariaService{

    @Autowired
    private MovimentacaoBancariaRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(MovimentacaoBancariaSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(MovimentacaoBancaria cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = ModeloSpecification.addClausula(where, ModeloSpecification.byDescricaoSpecification(cp.getDescricao()) );
        }
        
        return repository.findAll(where);
    }

    @Override
    public MovimentacaoBancaria save(MovimentacaoBancaria cp) {
        //Regra de negocio
        return repository.save(cp);
    }

    @Override
    public Optional<MovimentacaoBancaria> update(MovimentacaoBancaria cp, long id) {
         return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());

                     
                     MovimentacaoBancaria updated = repository.save(record);
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
