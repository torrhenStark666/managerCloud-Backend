/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.faixaCep;

import br.com.awasis.manangerbackend.model.FaixaCep_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class FaixaCepSpecification {
    
    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(FaixaCep_.idFaixaCep), id);
            return equalPredicate;
        };
    }
    
    public static Specification byComissaoSpecification(double comissao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(FaixaCep_.comissao), comissao);
            return equalPredicate;
        };
    }
    
    public static Specification byDescontoSpecification(double desconto){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(FaixaCep_.desconto), desconto);
            return equalPredicate;
        };
    }
    
    public static Specification byRangeCepSpecification(String cepInicial, String cepFinal){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.between(root.get(FaixaCep_.desconto), cepInicial, cepFinal);
            return equalPredicate;
        };
    }
    
    public static Specification byCepInicialSpecification(String cepInicial){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(FaixaCep_.desconto), cepInicial);
            return equalPredicate;
        };
    }
    
    public static Specification byCepFinalSpecification(String cepFinal){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(FaixaCep_.desconto), cepFinal);
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
