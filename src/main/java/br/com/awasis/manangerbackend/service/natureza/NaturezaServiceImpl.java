/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.natureza;

import br.com.awasis.manangerbackend.model.Natureza;
import br.com.awasis.manangerbackend.repository.NaturezaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NaturezaServiceImpl implements NaturezaService {

    private NaturezaRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(NaturezaSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Natureza cp) {
         Specification where = null;
         
         if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
             where = NaturezaSpecification.addClausula(where, NaturezaSpecification.byDescricaoSpecification(cp.getDescricao()));
         }
         
         if(!cp.getTipoDebitoCredito().isEmpty() || !cp.getTipoDebitoCredito().isBlank()){
            where = NaturezaSpecification.addClausula(where, NaturezaSpecification.byTipoDebitoCreditoSpecification(cp.getTipoDebitoCredito()));
         }         
         
         return repository.findAll(where);
    }

    @Override
    public Natureza save(Natureza cp) {
        //Regra de negocio 
        return repository.save(cp);
    }

    @Override
    public Optional<Natureza> update(Natureza cp, long id) {
                return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());
                     record.setTipoDebitoCredito(cp.getTipoDebitoCredito());
                     
                     Natureza updated = repository.save(record);
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
