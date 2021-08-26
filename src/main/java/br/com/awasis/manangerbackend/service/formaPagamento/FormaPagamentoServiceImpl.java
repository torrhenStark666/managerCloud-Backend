/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.formaPagamento;

import br.com.awasis.manangerbackend.model.FormaPagamento;
import br.com.awasis.manangerbackend.repository.FormaPagamentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoServiceImpl implements FormaPagamentoService {
    
    @Autowired
    private FormaPagamentoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(FormaPagamentoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(FormaPagamento cp) {
         Specification where = null;
         
         if(!cp.getDescricao().isBlank() || !cp.getDescricao().isEmpty()){
             where = FormaPagamentoSpecification.addClausula(where, FormaPagamentoSpecification.byDescricaoSpecification(cp.getDescricao()));
         }
         
         where = FormaPagamentoSpecification.addClausula(where, FormaPagamentoSpecification.byAtivoSpecification(cp.isAtivo()));
         
         return repository.findAll(where);
    }

    @Override
    public FormaPagamento save(FormaPagamento cp) {
        //Regra de negocio 
        return repository.save(cp);
    }

    @Override
    public Optional<FormaPagamento> update(FormaPagamento cp, long id) {
         return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());
                     record.setAtivo(cp.isAtivo());
                     
                     FormaPagamento updated = repository.save(record);
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
