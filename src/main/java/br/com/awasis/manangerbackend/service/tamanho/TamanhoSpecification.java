/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tamanho;

import br.com.awasis.manangerbackend.model.Tamanho_;
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
public class TamanhoSpecification {

    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Tamanho_.idTamanho), id);
            return equalPredicate;
        };
    }
    
    public static Specification byDescricaoSpecification(String  descricao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.like(root.get(Tamanho_.descricao), "%"+descricao+"%");
            return equalPredicate;
        };
    }
    
    public static Specification byTamanhoSpecification(String tamanho){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Tamanho_.tamanho), tamanho);
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
