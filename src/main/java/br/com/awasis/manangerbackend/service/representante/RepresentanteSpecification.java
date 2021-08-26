/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.representante;

import br.com.awasis.manangerbackend.model.Representante;
import br.com.awasis.manangerbackend.model.Representante_;
import br.com.awasis.manangerbackend.model.TabelaPreco;
import br.com.awasis.manangerbackend.model.TabelaPreco_;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class RepresentanteSpecification {

    public static Specification byIdSpecification(long id){
        return (root, query, builder) ->{
             Predicate equalPredicate = builder.equal(root.get(Representante_.idRepresentante), id);
          
          return equalPredicate;
        };
    }
    
    public static Specification byCpnjSpecification(String cnpj){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Representante_.cnpj), "%"+cnpj.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byInscricaoEstadualSpecification(String inscricaoEstadual){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Representante_.inscricaoEstadual), "%"+inscricaoEstadual.trim()+"%");
          
          return equalPredicate;
        };
    } 
    
    public static Specification byCpfSpecification(String cpf){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Representante_.cpf), "%"+cpf.trim()+"%");
          
          return equalPredicate;
        };
    } 
    
    public static Specification byRazaoSocialSpecification(String razaoSocial){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Representante_.razaoSocial), "%"+razaoSocial.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byNomeFantasiaSpecification(String nomeFantasia){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Representante_.nomeFantasia), "%"+nomeFantasia.trim()+"%");
          
          return equalPredicate;
        };
    }
    
    public static Specification byTabelaPrecoSpecification(List tabelas){
        return (root, query, builder) ->{
            Join<Representante, TabelaPreco> tabelaPrecoJoin = root.join(Representante_.tabelaPrecos);
            Predicate equalPredicate = tabelaPrecoJoin.in(root.get(TabelaPreco_.idTabelaPreco), tabelas);
         //   Predicate teste = builder.in(tabelaPrecoJoin.get(TabelaPreco_.idTabelaPreco), tabelas);
          
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
