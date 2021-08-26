/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grade;

import br.com.awasis.manangerbackend.model.Grade_;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class GradeSpecification {
    
    public static Specification byIdGradeSpecification(long id){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Grade_.idGrade), id);
            return equalPredicate;
        };
    }
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, build) ->{
            Predicate equalPredicate = build.like(root.get(Grade_.descricao), "%"+descricao+"%");
            return equalPredicate;
        };
    } 
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Grade_.ativo), ativo);
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
