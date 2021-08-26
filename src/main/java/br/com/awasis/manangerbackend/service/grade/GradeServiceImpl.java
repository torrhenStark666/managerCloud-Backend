/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grade;

import br.com.awasis.manangerbackend.model.Grade;
import br.com.awasis.manangerbackend.repository.GradeRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {
    
    private GradeRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(GradeSpecification.byIdGradeSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Grade cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank() || cp.getDescricao() != null){
            where = GradeSpecification.addClausula(where, GradeSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        where = GradeSpecification.addClausula(where, GradeSpecification.byAtivoSpecification(cp.isAtivo()));
        
        return repository.findAll(where);
    }

    @Override
    public Grade save(Grade cp) {
        return repository.save(cp);
    }

    @Override
    public Optional<Grade> update(Grade cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    record.setDescricao(cp.getDescricao());
                    record.setAtivo(cp.isAtivo());
                    record.setPrecos(cp.getPrecos());
                    record.setTamanhos(cp.getTamanhos());
                    
                    return repository.save(record);
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
