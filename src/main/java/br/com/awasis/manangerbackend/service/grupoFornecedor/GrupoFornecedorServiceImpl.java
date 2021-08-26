/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grupoFornecedor;

import br.com.awasis.manangerbackend.model.GrupoFornecedor;
import br.com.awasis.manangerbackend.repository.GrupoFornecedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GrupoFornecedorServiceImpl implements GrupoFornecedorService {
    
    @Autowired
    private GrupoFornecedorRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(GrupoFornecedorSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(GrupoFornecedor gf) {
        Specification where = null;
        if(!gf.getDescricao().isBlank() || !gf.getDescricao().isEmpty()){
            where = GrupoFornecedorSpecification.addClausula(where, GrupoFornecedorSpecification.byDescricaoSpecification(gf.getDescricao()));
        }
        
        where = GrupoFornecedorSpecification.addClausula(where, GrupoFornecedorSpecification.byAtivoSpecification(gf.isAtivo()));
        
        return repository.findAll(where);
    }

    @Override
    public GrupoFornecedor save(GrupoFornecedor gf) {
        //Regra de negocio
        
        return repository.save(gf);
    }

    @Override
    public Optional<GrupoFornecedor> update(GrupoFornecedor gf, long id) {
        return repository.findById(id)
                .map(record ->{
                        record.setDescricao(gf.getDescricao());
                        record.setAtivo(gf.isAtivo());
                        return this.save(record);
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0 ){
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
