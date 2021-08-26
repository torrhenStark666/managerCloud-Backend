/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.login;

import br.com.awasis.manangerbackend.model.Login_;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class UsuarioSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Login_.idLogin), id);
            return equalPredicate; 
        };
    }
    
    public static Specification byLoginSpecification(String login){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.like(root.get(Login_.login), "%"+login.trim()+"%");
            return equalPredicate; 
        };
    }
    
    public static Specification bySenhaSpecification(String senha){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.like(root.get(Login_.senha), "%"+senha.trim()+"%");
            return equalPredicate; 
        };
    }
    
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Login_.ativo), ativo);
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
