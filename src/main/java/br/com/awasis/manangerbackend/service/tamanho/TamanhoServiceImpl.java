/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tamanho;

import br.com.awasis.manangerbackend.model.Tamanho;
import br.com.awasis.manangerbackend.repository.TamanhoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TamanhoServiceImpl implements TamanhoService {
    
    private TamanhoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(TamanhoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }


    @Override
    public List find(Tamanho cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isBlank() || !cp.getDescricao().isEmpty() || cp.getDescricao() != null){
            where = TamanhoSpecification.addClausula(where, TamanhoSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        if(!cp.getTamanho().isBlank() || !cp.getTamanho().isEmpty() || cp.getTamanho() != null){
            where = TamanhoSpecification.addClausula(where, TamanhoSpecification.byDescricaoSpecification(cp.getTamanho()));
        }
        
        return repository.findAll(where);
    }

    @Override
    public Tamanho save(Tamanho cp) {
        return repository.save(cp);
    }

    @Override
    public Optional<Tamanho> update(Tamanho cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    record.setDescricao(cp.getDescricao());
                    record.setTamanho(cp.getTamanho());
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
