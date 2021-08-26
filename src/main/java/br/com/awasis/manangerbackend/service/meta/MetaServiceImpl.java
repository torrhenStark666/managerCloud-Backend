/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.meta;

import br.com.awasis.manangerbackend.model.Meta;
import br.com.awasis.manangerbackend.model.Representante;
import br.com.awasis.manangerbackend.repository.MetaRepository;
import br.com.awasis.manangerbackend.repository.RepresentanteRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class MetaServiceImpl implements MetaService {
    
    private MetaRepository repository;
    private RepresentanteRepository representanteRepository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(MetaSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Meta cp) {
        Specification where = null;
        
        if(cp.getQuantidade() > 0){
            where = MetaSpecification
                    .addClausula(where, MetaSpecification
                            .byQuantidadeSpecification(cp.getQuantidade()));
        }
        
        if(cp.getValor() > 0.0){
            where = MetaSpecification
                    .addClausula(where, MetaSpecification
                            .byValorSpecification(cp.getValor()));                    
        }
        
        if(cp.getInicio() != null){
            where = MetaSpecification
                    .addClausula(where, MetaSpecification
                            .byInicioSpecification(cp.getInicio()));
        }

        if(cp.getFim() != null){
            where = MetaSpecification
                    .addClausula(where, MetaSpecification
                            .byFimSpecification(cp.getFim()));
        }
        
        if(!cp.getRepresentantes().isEmpty() || cp.getRepresentantes() != null){
            where = MetaSpecification
                    .addClausula(where, MetaSpecification
                            .byRepresentanteSpecification(cp.getRepresentantes()));
        }
        
        return repository.findAll(where);
    }

    @Override
    public Meta save(Meta cp) {
        
      /*  if(!cp.getRepresentantes().isEmpty() || cp.getRepresentantes() != null){
            cp = repository.save(cp);
            for(Representante temp : cp.getRepresentantes()){
                temp = representanteRepository.findById(temp.getIdRepresentante()).get();
                temp.getMetas().add(cp);
                representanteRepository.save(temp);                
            }
        }else{
            cp = repository.save(cp);
        }*/
        
        return cp;
    }

    @Override
    public Optional<Meta> update(Meta cp, long id) {
        return repository.findById(id)
                .map((record) ->{
                    record.setInicio(cp.getInicio());
                    record.setFim(cp.getFim());
                    record.setQuantidade(cp.getQuantidade());
                    record.setValor(cp.getValor());
                    record.setRepresentantes(cp.getRepresentantes());
                    return record;
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
