/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.loteProducao;

import br.com.awasis.manangerbackend.model.LoteProducao;
import br.com.awasis.manangerbackend.repository.LoteProducaoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class LoteProducaoServiceImpl implements LoteProducaoService {

    private LoteProducaoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(LoteProducaoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(LoteProducao cp) {
        Specification where = null;
        
        if(cp.getAtivo() != null){
            where = LoteProducaoSpecification
                    .addClausula(where, LoteProducaoSpecification
                            .byAtivoSpecification(cp.getAtivo()));
        }
        
        if(cp.getPermitePedido()!= null){
            where = LoteProducaoSpecification
                    .addClausula(where, LoteProducaoSpecification
                            .byPermitePedidosSpecification(cp.getPermitePedido()));
        }
        
        if(cp.getPermiteVendas()!= null){
            where = LoteProducaoSpecification
                    .addClausula(where, LoteProducaoSpecification
                            .byPermiteVendasSpecification(cp.getPermiteVendas()));
        }
        
        if(cp.getDataInicio()!= null){
            where = LoteProducaoSpecification
                    .addClausula(where, LoteProducaoSpecification
                            .byDataInicioSpecification(cp.getDataInicio()));
        }
        
        if(cp.getDataFinal()!= null){
            where = LoteProducaoSpecification
                    .addClausula(where, LoteProducaoSpecification
                            .byDataFimSpecification(cp.getDataFinal()));
        }
        
        if(cp.getQuantidadeLote() > 0){
            where = LoteProducaoSpecification
                    .addClausula(where, LoteProducaoSpecification
                            .byQuantidadeLoteSpecification(cp.getQuantidadeLote()));
        }
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = LoteProducaoSpecification
                    .addClausula(where, LoteProducaoSpecification
                            .byDescricaoSpecification(cp.getDescricao()));
        }
        return repository.findAll(where);
    }

    @Override
    public LoteProducao save(LoteProducao cp) {
        if(cp.getAtivo() == null){
            return null;
        }
        
        if(cp.getPermitePedido()== null){
            return null;
        }
        
        if(cp.getPermiteVendas()== null){
            return null;
        }
        
        if(cp.getDataInicio()== null){
            return null;
        }
        
        if(cp.getDataFinal()== null){
            return null;
        }
        
        if(cp.getQuantidadeLote() <= 0){
            return null;
        }
        
        if(cp.getDescricao().isEmpty() || cp.getDescricao().isBlank()){
            return null;
        }
        
        return repository.save(cp);
    }

    @Override
    public Optional<LoteProducao> update(LoteProducao cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    
                    record.setAtivo(cp.getAtivo());
                    record.setDataFinal(cp.getDataFinal());
                    record.setDataInicio(cp.getDataFinal());
                    record.setPermiteVendas(cp.getPermiteVendas());
                    record.setPermitePedido(cp.getPermitePedido());
                    record.setDescricao(cp.getDescricao());
                    record.setQuantidadeLote(cp.getQuantidadeLote());
                    
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
