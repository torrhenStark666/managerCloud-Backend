/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.solicitante;

import br.com.awasis.manangerbackend.model.Solicitante;
import br.com.awasis.manangerbackend.repository.SolicitanteRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class SolicitanteServiceImpl implements SolicitanteService {
    
    @Autowired
    private SolicitanteRepository repository;

    @Override
    public Optional findById(long id) {
        return repository.findOne(SolicitanteSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Solicitante cp) {
        
        Specification where = null;
        
        if(cp.getLogin() != null){
            where = SolicitanteSpecification.addClausula(where, SolicitanteSpecification.byIdLoginSpecification(cp.getLogin().getIdLogin()));
        }
        
        return repository.findAll(where);
    }

    @Override
    public Solicitante save(Solicitante cp) {
        return repository.save(cp);
    }

    @Override
    public Optional<Solicitante> update(Solicitante cp, long id) {
        return repository.findById(id)
                .map( (record) ->{
                    
                    record.setDataFim(cp.getDataFim());
                    record.setDataInicio(cp.getDataInicio());
                    record.setLimiteInicial(cp.getLimiteInicial());
                    record.setLimiteFinal(cp.getLimiteFinal());
                    record.setGrupoProduto(cp.getGrupoProduto());
                    record.setGrupoSolicitante(cp.getGrupoSolicitante());
                    record.setNivel(cp.getNivel());
                    record.setValorDisponivel(cp.getValorDisponivel());
                    record.setAtivo(cp.isAtivo());
                    record.setLogin(cp.getLogin());
                    
                    
                    Solicitante updated = repository.save(record);
                    return updated;
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
            repository.deleteById(id);
            return true;
            
        }else{
            return false;
        }
    }
    
}
