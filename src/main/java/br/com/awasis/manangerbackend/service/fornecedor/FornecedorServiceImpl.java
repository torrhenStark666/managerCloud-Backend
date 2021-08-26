/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.fornecedor;

import br.com.awasis.manangerbackend.model.Fornecedor;
import br.com.awasis.manangerbackend.repository.FornecedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Service;

/**
 *
 * @author alecsander
 */
@Service
public class FornecedorServiceImpl implements FornecedorService{
    
    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> find(Fornecedor f) {
        
        Specification where = null;
        
        if(!f.getRazaoSocial().isBlank() || !f.getRazaoSocial().isEmpty()){
            where = addClausula(where, FornecedorSpecification.byRazaosocial(f.getRazaoSocial()));
        }
        
        if(!f.getNomeFantasia().isBlank() || !f.getNomeFantasia().isEmpty()){
            where = addClausula(where, FornecedorSpecification.byNomeFantasia(f.getNomeFantasia()));
        }
        
        if(!f.getCelular().isBlank() || !f.getCelular().isEmpty()){
            where = addClausula(where, FornecedorSpecification.byCelular(f.getCelular()));
        }
        
        if(!f.getTelefoneFixo().isBlank() || !f.getTelefoneFixo().isEmpty()){
            where = addClausula(where, FornecedorSpecification.byTelefoneFixo(f.getTelefoneFixo()));
        }
        
        if( !f.getInscricaoEstadual().isBlank() || !f.getInscricaoEstadual().isEmpty()){
            where = addClausula(where, FornecedorSpecification.byInscricaoEstadual(f.getInscricaoEstadual()));
        }
        
        if( f.getPontuacao()!= 0 ){
            where = addClausula(where, FornecedorSpecification.byPontuacao(f.getPontuacao()));
        }
        /*
        if(f.getDataUltimaCompra() == null){
            where = addClausula(where, FornecedorSpecification.byDataUltimaCompra(f.getDataUltimaCompra()));
        }*/
        
        if(!f.getCnpj().isBlank() || !f.getCnpj().isEmpty()){
            where = addClausula(where, FornecedorSpecification.byCnpj(f.getCnpj()));
        }else if(!f.getCpf().isBlank() || !f.getCnpj().isEmpty()){
            where = addClausula(where, FornecedorSpecification.byCpf(f.getCpf()));
        }
        if(f.getEndereco() != null){
            if(!f.getEndereco().getEndereco().isBlank() || !f.getEndereco().getEndereco().isEmpty()){        
                where = addClausula(where, FornecedorSpecification.byEnderecoFornecedor(f.getEndereco().getEndereco()));
            }
        }

        
        if(f.getGrupoFornecedor() != null){
            where = addClausula(where, FornecedorSpecification.byGrupoFornecedor(f.getGrupoFornecedor()));
        }
        
        List<Fornecedor> result = fornecedorRepository.findAll(where);
        
        return  result;
    }
    
    private Specification addClausula(Specification where, Specification novaClausula){
        if(where == null){
            return where(novaClausula);
        } else {
            return where(where).and(novaClausula);
        }
    }

    @Override
    public Fornecedor save(Fornecedor f) {
        //Regra de negocio
        return fornecedorRepository.save(f);
    }

    @Override
    public Optional<Fornecedor> findById(long id) {
               
        return fornecedorRepository.findOne(FornecedorSpecification.byId(id));
    }

    @Override
    public List findAll() {
        List result = fornecedorRepository.findAll();
        return result;
    }

    @Override
    public void delete(long id) {
        
        if(id != 0){
             fornecedorRepository.deleteById(id);
        }
        
       
    }
    

    
}
