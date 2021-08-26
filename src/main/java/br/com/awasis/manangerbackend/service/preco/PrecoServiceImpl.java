/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.preco;

import br.com.awasis.manangerbackend.model.Preco;
import br.com.awasis.manangerbackend.repository.PrecoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PrecoServiceImpl implements PrecoService {
    
    private PrecoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(PrecoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }


    @Override
    public List find(Preco cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank() || cp.getDescricao() != null){
            where = PrecoSpecification.addClausula(where, PrecoSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        if(cp.getValor() > 0 ){
            where = PrecoSpecification.addClausula(where, PrecoSpecification.byValorSpecification(cp.getValor()));
        }
        
        
        return repository.findAll(where);
    }

    @Override
    public Preco save(Preco cp) {
        return repository.save(cp);
    }

    @Override
    public Optional<Preco> update(Preco cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    record.setDescricao(cp.getDescricao());
                    record.setValor(cp.getValor());
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
