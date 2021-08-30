/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.solicitante;

import br.com.awasis.manangerbackend.model.GrupoProduto_;
import br.com.awasis.manangerbackend.model.Usuario;
import br.com.awasis.manangerbackend.model.Usuario_;
import br.com.awasis.manangerbackend.model.Solicitante;
import br.com.awasis.manangerbackend.model.Solicitante_;
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
public class SolicitanteSpecification {
    
    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Solicitante_.idSolicitante), id);
            return equalPredicate;
        };
    }
    
    public static Specification byIdLoginSpecification(long id){
        return (root, query, builder) ->{
            Join<Solicitante, Usuario> grupoProdutoJoin = root.join(Solicitante_.login);
            Predicate equalPredicate = builder.equal(grupoProdutoJoin.get(Usuario_.idLogin) , id);
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
