/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.zona;

import br.com.awasis.manangerbackend.model.Regiao;
import br.com.awasis.manangerbackend.model.Regiao_;
import br.com.awasis.manangerbackend.model.Zona;
import br.com.awasis.manangerbackend.model.Zona_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class ZonaSpecification {

    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Zona_.idZona), id);
            return equalPredicate;
        };  
    }

    public static Specification byDescricaoSpecification(String descricao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Zona_.idZona), "%"+descricao+"%");
            return equalPredicate;
        };  
    }
    
    public static Specification byRegiaoSpecification(Regiao regiao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Zona_.regiao), regiao);
            return equalPredicate;
        };  
    }
    
    public static Specification byIdRegiaoSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Join<Zona, Regiao> regiaoJoin = root.join(Zona_.regiao);
            Predicate equalPredicate = builder.equal(regiaoJoin.get(Regiao_.idRegiao), id);
            return equalPredicate;
        };  
    }
    
    public static Specification byDescricaoRegiaoSpecification(String descricao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Join<Zona, Regiao> regiaoJoin = root.join(Zona_.regiao);
            Predicate equalPredicate = builder.equal(regiaoJoin.get(Regiao_.descricao), descricao);
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
