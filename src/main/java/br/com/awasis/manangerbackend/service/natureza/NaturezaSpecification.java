/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.natureza;

import br.com.awasis.manangerbackend.model.Natureza_;
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
public class NaturezaSpecification {

    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Natureza_.idNatureza), id);
            return equalPredicate;
        };
    }
    
    public static Specification byDescricaoSpecification(String descricao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
          Predicate equalPredicate = builder.like(root.get(Natureza_.descricao), "%"+descricao.trim()+"%");
          return equalPredicate;
        };
    } 

    public static Specification byTipoDebitoCreditoSpecification(String tipoDebitoCredito){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
          Predicate equalPredicate = builder.like(root.get(Natureza_.tipoDebitoCredito), "%"+tipoDebitoCredito.trim()+"%");
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
