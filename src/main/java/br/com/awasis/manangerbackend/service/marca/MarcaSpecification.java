/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.marca;

import br.com.awasis.manangerbackend.model.Marca_;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class MarcaSpecification {
    public static Specification byIdSpecification(long id){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Marca_.idMarca), id);
            return equalPredicate;
        };
    }
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, build) ->{
            Predicate equalPredicate = build.like(root.get(Marca_.descricao), "%"+descricao+"%");
            return equalPredicate;
        };
    } 
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Marca_.ativo), ativo);
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
