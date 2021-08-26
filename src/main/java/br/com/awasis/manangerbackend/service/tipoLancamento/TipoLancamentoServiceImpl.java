/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoLancamento;

import br.com.awasis.manangerbackend.model.TipoLancamento;
import br.com.awasis.manangerbackend.repository.TipoLancamentoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TipoLancamentoServiceImpl implements TipoLancamentoService {

    private TipoLancamentoRepository repository;    
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(TipoLancamentoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(TipoLancamento cp) {
        
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = TipoLancamentoSpecification.addClausula(where, TipoLancamentoSpecification.byDescricaoSpecification(cp.getDescricao()));
        }
        
        if(!cp.getTipo().isEmpty() || !cp.getTipo().isBlank()){
            where = TipoLancamentoSpecification.addClausula(where, TipoLancamentoSpecification.byTipoSpecification(cp.getTipo()));
        }        
        
        return repository.findAll();
    }

    @Override
    public TipoLancamento save(TipoLancamento cp) {
        //Regra de negocio 
        return repository.save(cp);
    }

    @Override
    public Optional<TipoLancamento> update(TipoLancamento cp, long id) {
                return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());
                     record.setTipo(cp.getTipo());
                     
                     TipoLancamento updated = repository.save(record);
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
