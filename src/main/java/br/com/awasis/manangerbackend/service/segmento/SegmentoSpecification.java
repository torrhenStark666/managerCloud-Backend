/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.segmento;

import br.com.awasis.manangerbackend.model.Segmento_;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class SegmentoSpecification {
    public static Specification byIdSpecification(long id){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Segmento_.idSegmento), id);
            return equalPredicate;
        };
    }
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, build) ->{
            Predicate equalPredicate = build.like(root.get(Segmento_.descricao), "%"+descricao+"%");
            return equalPredicate;
        };
    } 
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Segmento_.ativo), ativo);
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
