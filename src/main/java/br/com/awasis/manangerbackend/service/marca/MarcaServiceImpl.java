/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.marca;

import br.com.awasis.manangerbackend.model.Marca;
import br.com.awasis.manangerbackend.repository.MarcaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MarcaServiceImpl implements MarcaService {
    
    private MarcaRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(MarcaSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Marca cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank() || cp.getDescricao() != null){
            where = MarcaSpecification.addClausula(where, MarcaSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        where = MarcaSpecification.addClausula(where, MarcaSpecification.byAtivoSpecification(cp.isAtivo()));
        
        return repository.findAll(where);
    }

    @Override
    public Marca save(Marca cp) {
        //Regra de negocio
        return repository.save(cp);
    }

    @Override
    public Optional<Marca> update(Marca cp, long id) {
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
