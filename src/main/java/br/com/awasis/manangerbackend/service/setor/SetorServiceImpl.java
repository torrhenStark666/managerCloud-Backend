/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.setor;

import br.com.awasis.manangerbackend.model.Setor;
import br.com.awasis.manangerbackend.repository.SetorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class SetorServiceImpl implements SetorService {

    private SetorRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(SetorSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Setor cp) {
        Specification where = null ;
        
        if(!cp.getDescricao().isBlank() && !cp.getDescricao().isEmpty()){
           where = SetorSpecification.addClausula(where, SetorSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        if(cp.getFaixaCep() != null){
            where = SetorSpecification.addClausula(where, SetorSpecification.byIdFaixaCepSpecification( cp.getFaixaCep().getIdFaixaCep()));
        }
        if(cp.getRegrasNegocio() != null || !cp.getRegrasNegocio().isEmpty()){
             where = SetorSpecification.addClausula(where, SetorSpecification.byIdRegrasNegocioSpecification(cp.getRegrasNegocio()));    
        }
        if(cp.getTabelaPrecos()!= null || !cp.getTabelaPrecos().isEmpty()){
             where = SetorSpecification.addClausula(where, SetorSpecification.byIdTabelasPrecoSpecification(cp.getTabelaPrecos()));    
        } 
        return repository.findAll(where);
    }

    @Override
    public Setor save(Setor cp) {
        if(cp.getDescricao() == null){
            return null;
        }
        if(cp.getZona() == null){
            return null;
        }
        if(cp.getFaixaCep() == null){
            return null;
        }
        if(cp.getRegrasNegocio() == null || cp.getRegrasNegocio().isEmpty()){
            return null;
        }
        return repository.save(cp);       
    }

    @Override
    public Optional<Setor> update(Setor cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    
                    record.setDescricao(cp.getDescricao());
                    record.setZona(cp.getZona());
                    record.setFaixaCep(cp.getFaixaCep());
                    
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
