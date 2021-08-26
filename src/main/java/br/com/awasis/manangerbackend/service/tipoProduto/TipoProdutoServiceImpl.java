/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoProduto;

import br.com.awasis.manangerbackend.model.TipoProduto;
import br.com.awasis.manangerbackend.repository.TipoProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TipoProdutoServiceImpl implements TipoProdutoService {
    
    @Autowired
    private TipoProdutoRepository repository;

    @Override
    public Optional findById(long id) {
        return repository.findOne(TipoProdutoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(TipoProduto cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
             where = TipoProdutoSpecification.addClausula(where, TipoProdutoSpecification.byDescricaoSpecification(cp.getDescricao()));
         }
         where = TipoProdutoSpecification.addClausula(where, TipoProdutoSpecification.byAtivoSpecification(cp.isAtivo()));
        
        return repository.findAll(where);
    }

    @Override
    public TipoProduto save(TipoProduto cp) {
        //Regra de negocio 
        return repository.save(cp);
    }

    @Override
    public Optional<TipoProduto> update(TipoProduto cp, long id) {
        return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());
                     record.setAtivo(cp.isAtivo());
                     
                     TipoProduto updated = repository.save(record);
                     return updated;
                 
                 });
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
