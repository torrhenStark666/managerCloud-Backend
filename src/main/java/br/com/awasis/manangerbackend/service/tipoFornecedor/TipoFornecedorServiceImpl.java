/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoFornecedor;

import br.com.awasis.manangerbackend.model.TipoFornecedor;
import br.com.awasis.manangerbackend.repository.TipoFornecedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TipoFornecedorServiceImpl implements TipoFornecedorService {
    
    @Autowired
    private TipoFornecedorRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(TipoFornecedorSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(TipoFornecedor tf) {
        
        Specification where = null;
        
        if(!tf.getDescricao().isEmpty() || !tf.getDescricao().isBlank()){
            where = TipoFornecedorSpecification.addClausula(where, TipoFornecedorSpecification.byDescricaoSpecification(tf.getDescricao()));
        }
        
        where = TipoFornecedorSpecification.addClausula(where, TipoFornecedorSpecification.byAtivoSpecification(tf.isAtivo()));
        
        return repository.findAll(where);
        
    }

    @Override
    public TipoFornecedor save(TipoFornecedor tf) {
        //Regra de Negocio
        return repository.save(tf);
    }

    @Override
    public Optional<TipoFornecedor> update(TipoFornecedor tf, long id) {
        return repository.findById(id)
                .map((TipoFornecedor record)->{
                    record.setDescricao(tf.getDescricao());
                    record.setAtivo(tf.isAtivo());
                    
                    return repository.save(record);
                    
                });
                
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
             repository.deleteById(id);
             return true;
        }else return false;
    }
    
}
