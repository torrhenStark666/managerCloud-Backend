/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grupoProduto;

import br.com.awasis.manangerbackend.model.GrupoProduto;
import br.com.awasis.manangerbackend.repository.GrupoProdutoRepository;
import br.com.awasis.manangerbackend.service.grupoFornecedor.GrupoFornecedorSpecification;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GrupoProdutoServiceImpl implements GrupoProdutoService {
    
    @Autowired
    private GrupoProdutoRepository repository;
    
    @Override
    public Optional findById(long id) {
         return repository.findOne(GrupoProdutoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(GrupoProduto cp) {
         Specification where = null;
         
         if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
             where = GrupoProdutoSpecification.addClausula(where, GrupoProdutoSpecification.byDescricaoSpecification(cp.getDescricao()));
         }
         where = GrupoProdutoSpecification.addClausula(where, GrupoProdutoSpecification.byAtivoSpecification(cp.isAtivo()));
         return repository.findAll(where);
    }

    @Override
    public GrupoProduto save(GrupoProduto cp) {
        //Regra de negocio 
        return repository.save(cp);
    }

    @Override
    public Optional<GrupoProduto> update(GrupoProduto cp, long id) {
        return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());
                     record.setAtivo(cp.isAtivo());
                     
                     GrupoProduto updated = repository.save(record);
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
