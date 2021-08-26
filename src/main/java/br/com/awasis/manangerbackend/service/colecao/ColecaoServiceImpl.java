/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.colecao;

import br.com.awasis.manangerbackend.model.Colecao;
import br.com.awasis.manangerbackend.repository.ColecaoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ColecaoServiceImpl implements ColecaoService {

    private ColecaoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(ColecaoSpecification.byAtivoSpecification(true));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Colecao cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = ColecaoSpecification
                    .addClausula(where, ColecaoSpecification
                            .byDescricaoSpecification(cp.getDescricao()));
        }
        
        if(cp.getQuantidadePrevista() > 0){
            where = ColecaoSpecification
                    .addClausula(where, ColecaoSpecification
                            .byQuantidadePrevistaSpecification(cp.getQuantidadePrevista()));
        }
        
        if(cp.getQuantidadeVendida()> 0){
            where = ColecaoSpecification
                    .addClausula(where, ColecaoSpecification
                            .byQuantidadeVendidaSpecification(cp.getQuantidadeVendida()));
        }
        
        if(cp.getDataInicioColecao() != null){
            where = ColecaoSpecification
                    .addClausula(where, ColecaoSpecification
                            .byDataInicioColecaoSpecification(cp.getDataInicioColecao()));
        }
                
        if(cp.getDataFimColecao()!= null){
            where = ColecaoSpecification
                    .addClausula(where, ColecaoSpecification
                            .byDataFimColecaoSpecification(cp.getDataFimColecao()));
        }
        
        if(cp.getDataInicioProducao()!= null){
            where = ColecaoSpecification
                    .addClausula(where, ColecaoSpecification
                            .byDataInicioProducaoSpecification(cp.getDataInicioProducao()));
        }
        
        if(cp.getDataFimProducao()!= null){
            where = ColecaoSpecification
                    .addClausula(where, ColecaoSpecification
                            .byDataFimProducaoSpecification(cp.getDataFimProducao()));
        }
        
        where = ColecaoSpecification.addClausula(where, ColecaoSpecification
                .byAtivoSpecification(cp.isAtivo()));

        
        return repository.findAll(where);
    }

    @Override
    public Colecao save(Colecao cp) {
if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            return null;
        }
        
        if(cp.getQuantidadePrevista() > 0){
            return null;
        }
        
        if(cp.getQuantidadeVendida()> 0){
            return null;
        }
        
        if(cp.getDataInicioColecao() != null){
            return null;
        }
                
        if(cp.getDataFimColecao()!= null){
            return null;
        }
        
        if(cp.getDataInicioProducao()!= null){
            return null;
        }
        
        if(cp.getDataFimProducao()!= null){
            return null;
        }
        return repository.save(cp);
    }

    @Override
    public Optional<Colecao> update(Colecao cp, long id) {
        return repository.findById(id)
                .map((record) ->{
                   
                    record.setDescricao(cp.getDescricao());
                    record.setAtivo(cp.isAtivo());
                    record.setQuantidadePrevista(cp.getQuantidadePrevista());
                    record.setQuantidadeVendida(cp.getQuantidadeVendida());
                    record.setDataInicioProducao(cp.getDataInicioProducao());
                    record.setDataFimProducao(cp.getDataFimProducao());
                    record.setDataInicioColecao(cp.getDataFimColecao());
                    
                    repository.save(record);
                    
                    return repository.findById(id).get();
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
