/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.transportadora;


import br.com.awasis.manangerbackend.model.Transportadora_;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class TransportadoraSpecification {
    
    public static Specification byRazaoSocialSpecification(String razaoSocial){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Transportadora_.razaoSocial), "%"+razaoSocial.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byNomeFantasiaSpecification(String nomeFantasia){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Transportadora_.nomeFantasia), "%"+nomeFantasia.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byCpfSpecification(String cpf){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Transportadora_.cpf), "%"+cpf.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) ->{
             Predicate equalPredicate = builder.equal(root.get(Transportadora_.idTransportadora), id);
          
          return equalPredicate;
        };
    }
    
    public static Specification byCpnjSpecification(String cnpj){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Transportadora_.cnpj), "%"+cnpj.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byInscricaoEstadualSpecification(String inscricaoEstadual){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Transportadora_.inscricaoEstadual), "%"+inscricaoEstadual.trim()+"%");
          
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
