/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.empresa;

import br.com.awasis.manangerbackend.model.Empresa;
import br.com.awasis.manangerbackend.repository.EmpresaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(EmpresaSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Empresa cp) {
         Specification where = null;
         
         if(!cp.getNomeFantasia().isEmpty() || !cp.getNomeFantasia().isBlank()){
             where = EmpresaSpecification.addClausula(where, EmpresaSpecification.byNomeFantasiaSpecification(cp.getNomeFantasia()));
         }
         return repository.findAll(where);
    }

    @Override
    public Empresa save(Empresa cp) {
        
        if(cp.getEndereco() == null){
            return null;
        }
        
        if(cp.getCnpj() == null){
            return null;
        }
        
        if(cp.getRazaoSocial() == null){
            return null;
        }
        
        if(cp.getNomeFantasia() == null){
            return null;
        }
        
        return repository.save(cp);
    }

    @Override
    public Optional<Empresa> update(Empresa cp, long id) {
                return repository.findById(id)
                 .map((record) ->{
                     record.setNomeFantasia(cp.getNomeFantasia());
                     record.setRazaoSocial(cp.getRazaoSocial());
                     record.setEndereco(cp.getEndereco());
                     
                     Empresa updated = repository.save(record);
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
