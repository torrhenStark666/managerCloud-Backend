/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.segmento;

import br.com.awasis.manangerbackend.model.Segmento;
import br.com.awasis.manangerbackend.repository.SegmentoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SegmentoServiceImpl implements SegmentoService {
    
    private SegmentoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(SegmentoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Segmento cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank() || cp.getDescricao() != null){
            where = SegmentoSpecification.addClausula(where, SegmentoSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        where = SegmentoSpecification.addClausula(where, SegmentoSpecification.byAtivoSpecification(cp.isAtivo()));
        
        return repository.findAll(where);
    }

    @Override
    public Segmento save(Segmento cp) {
                //Regra de negocio
        return repository.save(cp);
    }

    @Override
    public Optional<Segmento> update(Segmento cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    record.setDescricao(cp.getDescricao());
                    record.setAtivo(cp.isAtivo());
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
