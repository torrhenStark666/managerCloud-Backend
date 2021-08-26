/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.ItemAutorizado;

import br.com.awasis.manangerbackend.model.GrupoProduto_;
import br.com.awasis.manangerbackend.model.ItemAutorizado_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author alecsander
 */
public class ItemAutorizadoSpecification {
    
    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(ItemAutorizado_.idItemAutorizado), id);
            return equalPredicate;
        };
    }
    
}
