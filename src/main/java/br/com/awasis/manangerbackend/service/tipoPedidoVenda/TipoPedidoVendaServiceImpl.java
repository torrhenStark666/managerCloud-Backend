/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoPedidoVenda;

import br.com.awasis.manangerbackend.model.TipoPedidoVenda;
import br.com.awasis.manangerbackend.repository.TipoPedidoVendaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class TipoPedidoVendaServiceImpl implements TipoPedidoVendaService {

    private TipoPedidoVendaRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(TipoPedidoVendaSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(TipoPedidoVenda cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = TipoPedidoVendaSpecification
                    .addClausula(where, TipoPedidoVendaSpecification
                            .byDescricaoSpecification(cp.getDescricao()));
        }
        
        if(cp.getAtivo() != null){
            where = TipoPedidoVendaSpecification
                    .addClausula(where, TipoPedidoVendaSpecification
                            .byAtivoSpecification(cp.getAtivo()));
        }
        
        if(cp.getDuplicata()!= null){
            where = TipoPedidoVendaSpecification
                    .addClausula(where, TipoPedidoVendaSpecification
                            .byDuplicataSpecification(cp.getDuplicata()));
        }
        
        if(cp.getPedidoVendas().isEmpty() || cp.getPedidoVendas() != null){
            where = TipoPedidoVendaSpecification
                    .addClausula(where, TipoPedidoVendaSpecification
                            .byIdPedidoVendaSpecification(cp.getPedidoVendas()));
        }
        
        return repository.findAll(where);
    }

    @Override
    public TipoPedidoVenda save(TipoPedidoVenda cp) {
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            return null;
        }
        
        if(cp.getAtivo() != null){
            return null;
        }
        
        if(cp.getDuplicata()!= null){
            return null;
        }        
        
        return repository.save(cp);
        
    }

    @Override
    public Optional<TipoPedidoVenda> update(TipoPedidoVenda cp, long id) {
        return repository.findById(id)
                .map((record) ->{
                    record.setDescricao(cp.getDescricao());
                    record.setAtivo(cp.getAtivo());
                    record.setDuplicata(cp.getDuplicata());
                    return repository.save(record);
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0 ){
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
