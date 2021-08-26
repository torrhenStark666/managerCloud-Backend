/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grupoSolicitante;

import br.com.awasis.manangerbackend.model.GrupoSolicitante;
import br.com.awasis.manangerbackend.repository.GrupoClienteRepository;
import br.com.awasis.manangerbackend.repository.GrupoSolicitanteRepository;
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
public class GrupoSolicitanteServiceImpl implements GrupoSolicitanteService {

    @Autowired
    private GrupoSolicitanteRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(GrupoSolicitanteSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(GrupoSolicitante cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank() || cp.getDescricao() != null){
            where = GrupoSolicitanteSpecification.byDescricaoSpecification(cp.getDescricao());
        }
        
        return repository.findAll(where);
    }

    @Override
    public GrupoSolicitante save(GrupoSolicitante cp) {
        return repository.save(cp);
    }

    @Override
    public Optional<GrupoSolicitante> update(GrupoSolicitante cp, long id) {
                return repository.findById(id)
                 .map((record) ->{
                     record.setDescricao(cp.getDescricao());
                     record.setAtivo(cp.isAtivo());
                     
                     GrupoSolicitante updated = repository.save(record);
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
