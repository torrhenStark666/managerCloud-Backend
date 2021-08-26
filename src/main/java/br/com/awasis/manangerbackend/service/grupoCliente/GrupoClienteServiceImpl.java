/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grupoCliente;

import br.com.awasis.manangerbackend.model.GrupoCliente;
import br.com.awasis.manangerbackend.repository.GrupoClienteRepository;
import br.com.awasis.manangerbackend.service.grupoFornecedor.GrupoFornecedorSpecification;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GrupoClienteServiceImpl implements GrupoClienteService {

    private GrupoClienteRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(GrupoFornecedorSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(GrupoCliente gf) {
        Specification where = null;
        if(!gf.getDescricao().isBlank() || !gf.getDescricao().isEmpty()){
            where = GrupoClienteSpecification.addClausula(where, GrupoClienteSpecification.byDescricaoSpecification(gf.getDescricao()));
        }

        return repository.findAll(where);
    }

    @Override
    public GrupoCliente save(GrupoCliente gf) {
        //Regra de negocio
        
        return repository.save(gf);
    }

    @Override
    public Optional<GrupoCliente> update(GrupoCliente gf, long id) {
        return repository.findById(id)
                .map(record ->{
                        record.setDescricao(gf.getDescricao());
                        return this.save(record);
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
