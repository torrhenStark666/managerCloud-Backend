/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.cliente;

import br.com.awasis.manangerbackend.model.Cliente;
import br.com.awasis.manangerbackend.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(ClienteSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Cliente cp) {
        Specification where = null;
        
        if(!cp.getRazaoSocial().trim().isEmpty() || !cp.getRazaoSocial().trim().isBlank()){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byRazaoSocialSpecification(cp.getRazaoSocial()));
        }
        
        if(!cp.getNomeFantasia().trim().isEmpty() || !cp.getNomeFantasia().trim().isBlank()){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byNomeFantasiaSpecification(cp.getNomeFantasia()));
        }
        
        if(cp.getBloqueadoInativo() != null){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byBloqueadoInativoSpecification(cp.getBloqueadoInativo()));
        }
        
        if(cp.getBloqueadorFaturamento()!= null){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byBloqueadorFaturamentoSpecification(cp.getBloqueadorFaturamento()));
        }
        
        if(cp.getBloqueadorVendas()!= null){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byBloqueadorVendasSpecification(cp.getBloqueadorVendas()));
        }
        
        if(cp.getDataUltimaCompra()!= null){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byDataUltimaCompraSpecification(cp.getDataUltimaCompra()));
        }
        
        if(!cp.getCnpj().isBlank() || !cp.getCnpj().isEmpty()){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byCpnjSpecification(cp.getCnpj()));
        }else if(!cp.getCpf().isBlank() || !cp.getCnpj().isEmpty()){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byCpfSpecification(cp.getCpf()));
        }
        
        if( !cp.getInscricaoEstadual().isBlank() || !cp.getInscricaoEstadual().isEmpty()){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byInscricaoEstadualSpecification(cp.getInscricaoEstadual()));
        }
        
        if(cp.getSetor() != null){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byIdSetorClienteSpecification(cp.getSetor().getIdSetor()));
        }
        
        if(cp.getGrupoCliente()!= null){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byIdGrupoClienteSpecification(cp.getGrupoCliente().getIdGrupoCliente()));
        }
        
        if(cp.getRegrasNegocio() != null || !cp.getRegrasNegocio().isEmpty()){
            where = ClienteSpecification
                        .addClausula(where, ClienteSpecification
                            .byIdRegraNegocioClienteSpecification(cp.getRegrasNegocio()));
        }
        return  repository.findAll(where);
    }

    @Override
    public Cliente save(Cliente cp) {
        if(cp.getRazaoSocial().trim().isEmpty() || cp.getRazaoSocial().trim().isBlank()){
            return null;
        }
        
        if(cp.getNomeFantasia().trim().isEmpty() || cp.getNomeFantasia().trim().isBlank()){
            return null;
        }
        
        if(cp.getBloqueadoInativo() == null){
            return null;
        }
        
        if(cp.getBloqueadorFaturamento() == null){
            return null;
        }
        
        if(cp.getBloqueadorVendas() == null){
            return null;
        }
                
        if(cp.getCnpj().trim().isEmpty() || cp.getCnpj().trim().isBlank()){
            return null;
        }else if(cp.getCpf().trim().isEmpty() || cp.getCpf().trim().isBlank()){
            return null;
        }
        
        if(cp.getInscricaoEstadual().trim().isEmpty() || cp.getInscricaoEstadual().trim().isBlank()){
            return null;
        }
        if(cp.getGrupoCliente() == null){
            return null;
        }
                
        if(cp.getSetor() == null){
            return null;
        }
                
        return repository.save(cp);
    }

    @Override
    public Optional<Cliente> update(Cliente cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    record.setCnpj(cp.getCnpj());
                    record.setCpf(cp.getCpf());
                    record.setInscricaoEstadual(cp.getInscricaoEstadual());
                    record.setRazaoSocial(cp.getRazaoSocial());
                    record.setNomeFantasia(cp.getNomeFantasia());
                    record.setConsumidorFinal(cp.getConsumidorFinal());
                    record.setGrupoCliente(cp.getGrupoCliente());
                    record.setRegrasNegocio(cp.getRegrasNegocio());
                    record.setEndereco(cp.getEndereco());
                    record.setContatos(cp.getContatos());
                    record.setImagem(cp.getImagem());
                    record.setRepresentante(cp.getRepresentante());
                    record.setDataUltimaCompra(cp.getDataUltimaCompra());
                    record.setBloqueadoInativo(cp.getBloqueadoInativo());
                    record.setBloqueadorFaturamento(cp.getBloqueadorFaturamento());
                    record.setBloqueadorVendas(cp.getBloqueadorVendas());
                    record.setEmailXml(cp.getEmailXml());
                    record.setEmail(cp.getEmail());
                    record.setCelular(cp.getCelular());
                    record.setTelefoneFixo(cp.getTelefoneFixo());
                    
                    
                    return repository.save(record);
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
