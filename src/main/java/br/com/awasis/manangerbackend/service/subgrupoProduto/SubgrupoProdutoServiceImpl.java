/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.subgrupoProduto;

import br.com.awasis.manangerbackend.model.SubgrupoProduto;
import br.com.awasis.manangerbackend.repository.SubGrupoProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SubgrupoProdutoServiceImpl implements SubgrupoProdutoService {

    @Autowired
    private SubGrupoProdutoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(SubgrupoProdutoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(SubgrupoProduto cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = SubgrupoProdutoSpecification.addClausula(where, SubgrupoProdutoSpecification.byDescricaoSpecification(cp.getDescricao()) );
        }        
        
        where = SubgrupoProdutoSpecification.addClausula(where, SubgrupoProdutoSpecification.byAtivoSpecification(cp.isAtivo()));
        
        if(cp.getGrupoProduto() != null){
            if(cp.getGrupoProduto().getIdGrupoProduto() > 0){
                where = SubgrupoProdutoSpecification.addClausula(where, SubgrupoProdutoSpecification.byIdGrupoProdutoSpecification(cp.getGrupoProduto().getIdGrupoProduto()));
            }
            
            if(!cp.getGrupoProduto().getDescricao().isEmpty() || !cp.getGrupoProduto().getDescricao().isBlank()){
                where = SubgrupoProdutoSpecification.addClausula(where, SubgrupoProdutoSpecification.byDescricaoGrupoProdutoSpecification(cp.getGrupoProduto().getDescricao()));
            }
        }
        
        return repository.findAll(where);
    }

    @Override
    public SubgrupoProduto save(SubgrupoProduto cp) {
        //Regra de negocio
        
        return repository.save(cp);
    }

    @Override
    public Optional<SubgrupoProduto> update(SubgrupoProduto cp, long id) {
         return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());
                     record.setAtivo(cp.isAtivo());
                     record.setGrupoProduto(cp.getGrupoProduto());
                     
                     SubgrupoProduto updated = repository.save(record);
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
