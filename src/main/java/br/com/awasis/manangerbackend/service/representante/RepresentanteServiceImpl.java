/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.representante;

import br.com.awasis.manangerbackend.model.Representante;
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
public class RepresentanteServiceImpl implements RepresentanteService {

    private RepresentanteRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Representante cp) {
        Specification where = null;
        
        if(!cp.getCpf().isEmpty() || !cp.getCpf().isBlank()){
            where = RepresentanteSpecification
                    .addClausula(where, RepresentanteSpecification
                            .byCpfSpecification(cp.getCpf()));
        }else if(!cp.getCnpj().isEmpty() || !cp.getCnpj().isBlank()){
            where = RepresentanteSpecification
                    .addClausula(where, RepresentanteSpecification
                            .byCpnjSpecification(cp.getCnpj()));
        }
        
        if(!cp.getRazaoSocial().isEmpty() || !cp.getRazaoSocial().isBlank()){
            where = RepresentanteSpecification
                    .addClausula(where, RepresentanteSpecification
                            .byRazaoSocialSpecification(cp.getRazaoSocial()));
        }
        
        if(!cp.getNomeFantasia().isEmpty() || !cp.getNomeFantasia().isBlank()){
            where = RepresentanteSpecification
                    .addClausula(where, RepresentanteSpecification
                            .byNomeFantasiaSpecification(cp.getNomeFantasia()));
        }
        
         if(!cp.getInscricaoEstadual().isEmpty() || !cp.getInscricaoEstadual().isBlank()){
            where = RepresentanteSpecification
                    .addClausula(where, RepresentanteSpecification
                            .byInscricaoEstadualSpecification(cp.getInscricaoEstadual()));
        }
        return repository.findAll(where);
    }

    @Override
    public Representante save(Representante cp) {
        
        if(cp.getEndereco() == null){
            return null;
        }
        
        if(cp.getTipoContribuiente().isBlank() || cp.getTipoContribuiente().isEmpty() ){
            return null;
        }
        
        if(cp.getNomeFantasia().isBlank() || cp.getNomeFantasia().isEmpty() ){
            return null;
        }
        
        if(cp.getRazaoSocial().isBlank() || cp.getRazaoSocial().isEmpty() ){
            return null;
        }
        
        if(cp.getEmail().isBlank() || cp.getEmail().isEmpty()){
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
    public Optional<Representante> update(Representante cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    
                    record.setAtivo(cp.getAtivo());
                    record.setCelular(cp.getCelular());
                    record.setCnpj(cp.getCnpj());
                    record.setCpf(cp.getCpf());
                    record.setEmail(cp.getEmail());
                    record.setEmailXml(cp.getEmailXml());
                    record.setEndereco(cp.getEndereco());
                    record.setImagem(cp.getImagem());
                    record.setInscricaoEstadual(cp.getInscricaoEstadual());
                    record.setMetas(cp.getMetas());
                    record.setNomeFantasia(cp.getNomeFantasia());
                    record.setPercentualComissao(cp.getPercentualComissao());
                    record.setRazaoSocial(cp.getRazaoSocial());
                    record.setSetor(record.getSetor());
                    record.setTabelaPrecos(cp.getTabelaPrecos());
                    record.setTelefoneFixo(cp.getTelefoneFixo());
                    record.setTipoContribuiente(cp.getTipoContribuiente());
                    
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
