/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.transportadora;

import br.com.awasis.manangerbackend.model.Transportadora;
import br.com.awasis.manangerbackend.repository.TransportadoraRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class TransportadoraServiceImpl implements TransportadoraService {

    private TransportadoraRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Transportadora cp) {
        Specification where = null;
        
        if(!cp.getCpf().isEmpty() || !cp.getCpf().isBlank()){
            where = TransportadoraSpecification
                    .addClausula(where, TransportadoraSpecification
                            .byCpfSpecification(cp.getCpf()));
        }else if(!cp.getCnpj().isEmpty() || !cp.getCnpj().isBlank()){
            where = TransportadoraSpecification
                    .addClausula(where, TransportadoraSpecification
                            .byCpnjSpecification(cp.getCnpj()));
        }
        
        if(!cp.getRazaoSocial().isEmpty() || !cp.getRazaoSocial().isBlank()){
            where = TransportadoraSpecification
                    .addClausula(where, TransportadoraSpecification
                            .byRazaoSocialSpecification(cp.getRazaoSocial()));
        }
        
        if(!cp.getNomeFantasia().isEmpty() || !cp.getNomeFantasia().isBlank()){
            where = TransportadoraSpecification
                    .addClausula(where, TransportadoraSpecification
                            .byNomeFantasiaSpecification(cp.getNomeFantasia()));
        }
        
         if(!cp.getInscricaoEstadual().isEmpty() || !cp.getInscricaoEstadual().isBlank()){
            where = TransportadoraSpecification
                    .addClausula(where, TransportadoraSpecification
                            .byInscricaoEstadualSpecification(cp.getInscricaoEstadual()));
        }
        return repository.findAll(where);
    }

    @Override
    public Transportadora save(Transportadora cp) {
        if(cp.getEndereco() == null){
            return null;
        }
                
        if(cp.getNomeFantasia().isBlank() || cp.getNomeFantasia().isEmpty() ){
            return null;
        }
        
        if(cp.getRazaoSocial().isBlank() || cp.getRazaoSocial().isEmpty() ){
            return null;
        }
        
        if(cp.getTelefoneFixo().isBlank() || cp.getTelefoneFixo().isEmpty()){
            return null;
        }
        
        if(cp.getCpf().isBlank() || cp.getCpf().isEmpty()){
            return null;
        }else if(cp.getCnpj().isBlank() || cp.getCnpj().isEmpty()){
            return null;
        }
        
        return repository.save(cp);
    }

    @Override
    public Optional<Transportadora> update(Transportadora cp, long id) {
        return  repository.findById(id)
                .map(record ->{
                    
                    record.setCelular(cp.getCelular());
                    record.setContatos(cp.getContatos());
                    record.setCnpj(cp.getCnpj());
                    record.setCpf(cp.getCpf());
                    record.setEndereco(cp.getEndereco());
                    record.setInscricaoEstadual(cp.getInscricaoEstadual());
                    record.setNomeFantasia(cp.getNomeFantasia());
                    record.setRazaoSocial(cp.getRazaoSocial());
                    record.setTelefoneFixo(cp.getTelefoneFixo());
                    record.setCelular(cp.getCelular());
                    
                    return repository.save(record);
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
