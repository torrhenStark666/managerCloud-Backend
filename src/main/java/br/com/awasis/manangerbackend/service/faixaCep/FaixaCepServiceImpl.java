/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.faixaCep;

import br.com.awasis.manangerbackend.model.FaixaCep;
import br.com.awasis.manangerbackend.repository.FaixaCepRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FaixaCepServiceImpl implements FaixaCepService {

    @Autowired
    private FaixaCepRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(FaixaCepSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(FaixaCep cp) {
        Specification where =null;
        
        if(cp.getComissao() > 0){
            where = FaixaCepSpecification.addClausula(where, FaixaCepSpecification.byComissaoSpecification(cp.getComissao()));
        }
        
        if(cp.getDesconto() > 0){
            where = FaixaCepSpecification.addClausula(where, FaixaCepSpecification.byDescontoSpecification(cp.getDesconto()));
        }
        
        if(!cp.getCepInicial().isBlank() || !cp.getCepInicial().isEmpty()){
            where = FaixaCepSpecification.addClausula(where, FaixaCepSpecification.byCepInicialSpecification(cp.getCepInicial()));
        }
        
        if(!cp.getCepFinal().isBlank() || !cp.getCepFinal().isEmpty()){
            where = FaixaCepSpecification.addClausula(where, FaixaCepSpecification.byCepFinalSpecification(cp.getCepFinal()));
        }    
        
        return repository.findAll(where);
    }

    @Override
    public FaixaCep save(FaixaCep cp) {
        //Regra de negocio
        
        return repository.save(cp);
    }

    @Override
    public Optional<FaixaCep> update(FaixaCep cp, long id) {
        return repository.findById(id)
                .map(record ->{
                        record.setDesconto(cp.getDesconto());
                        record.setComissao(cp.getComissao());
                        record.setCepInicial(cp.getCepInicial());
                        record.setCepFinal(cp.getCepFinal());
                    
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
