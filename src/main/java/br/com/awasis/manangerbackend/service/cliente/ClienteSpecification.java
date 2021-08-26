/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.cliente;

import br.com.awasis.manangerbackend.model.Cliente;
import br.com.awasis.manangerbackend.model.Cliente_;
import br.com.awasis.manangerbackend.model.GrupoCliente;
import br.com.awasis.manangerbackend.model.GrupoCliente_;
import br.com.awasis.manangerbackend.model.RegraNegocio;
import br.com.awasis.manangerbackend.model.RegraNegocio_;
import br.com.awasis.manangerbackend.model.Setor;
import br.com.awasis.manangerbackend.model.Setor_;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class ClienteSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) ->{
             Predicate equalPredicate = builder.equal(root.get(Cliente_.idCliente), id);
          
          return equalPredicate;
        };
    }
    
    public static Specification byCpnjSpecification(String cnpj){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.cnpj), "%"+cnpj.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byInscricaoEstadualSpecification(String inscricaoEstadual){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.inscricaoEstadual), "%"+inscricaoEstadual.trim()+"%");
          
          return equalPredicate;
        };
    } 
    
    public static Specification byBloqueadoInativoSpecification(boolean bloqueadoInativo){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.bloqueadoInativo), bloqueadoInativo);
          
          return equalPredicate;
        };
    }
    
    public static Specification byBloqueadorVendasSpecification(boolean bloqueadorVendas){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.bloqueadorVendas), bloqueadorVendas);
          
          return equalPredicate;
        };
    }
    
    public static Specification byBloqueadorFaturamentoSpecification(boolean bloqueadorFaturamento){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.bloqueadorFaturamento), bloqueadorFaturamento);
          
          return equalPredicate;
        };
    }
    
    public static Specification byCpfSpecification(String cpf){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.cpf), "%"+ cpf.trim()+"%");
          
          return equalPredicate;
        };
    } 
    
    public static Specification byDataUltimaCompraSpecification(Date dataUltimaCompra){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.dataUltimaCompra), dataUltimaCompra);
          
          return equalPredicate;
        };
    } 
    
    public static Specification byConsumidorFinalSpecification(String consumidorFinal){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.consumidorFinal), "%"+consumidorFinal.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byRazaoSocialSpecification(String razaoSocial){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.razaoSocial), "%"+razaoSocial.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byNomeFantasiaSpecification(String nomeFantasia){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Cliente_.nomeFantasia), "%"+nomeFantasia.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byIdGrupoClienteSpecification(long id){
        return (root, query, builder) ->{
            Join<Cliente, GrupoCliente> grupoClienteJoin = root.join(Cliente_.grupoCliente);
            Predicate equalPredicate = builder.equal(grupoClienteJoin.get(GrupoCliente_.idGrupoCliente),id);

          return equalPredicate;
        };
    }  
    
    public static Specification byIdSetorClienteSpecification(long id){
        return (root, query, builder) ->{
            Join<Cliente, Setor> setorJoin = root.join(Cliente_.setor);
            Predicate equalPredicate = builder.equal(setorJoin.get(Setor_.idSetor),id);

          return equalPredicate;
        };
    }
    
    public static Specification byIdRegraNegocioClienteSpecification(List regrasNegocio){
        return (root, query, builder) ->{
            Join<Cliente, RegraNegocio> regraNegocioJoin = root.join(Cliente_.regrasNegocio);
            Predicate equalPredicate = regraNegocioJoin.in(root.in(RegraNegocio_.idRegraNegocio),regrasNegocio);

          return equalPredicate;
        };
    }
    
    
    public static Specification addClausula(Specification where, Specification novaClausula){
        if(where == null){
            return where(novaClausula);
        } else {
            return where(where).and(novaClausula);
        }
    }     
}
