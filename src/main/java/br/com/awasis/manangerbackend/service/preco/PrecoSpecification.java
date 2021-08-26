/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.preco;

import br.com.awasis.manangerbackend.model.Preco_;
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
public class PrecoSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Preco_.idPreco), id);
            return equalPredicate;
        };
    }
    
    public static Specification byDescricaoSpecification(String  descricao){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.like(root.get(Preco_.descricao), "%"+descricao.trim()+"%");
            return equalPredicate;
        };
    }
    
    public static Specification byValorSpecification(double valor){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Preco_.valor), valor);
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
