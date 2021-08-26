/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.meta;

import br.com.awasis.manangerbackend.model.Meta;
import br.com.awasis.manangerbackend.model.Meta_;
import br.com.awasis.manangerbackend.model.Representante;
import br.com.awasis.manangerbackend.model.Representante_;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class MetaSpecification {

    public static Specification byIdSpecification(long id){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Meta_.idMeta), id);
            return equalPredicate;
        };
    }
    
    public static Specification byQuantidadeSpecification(long quantidade){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Meta_.quantidade), quantidade);
            return equalPredicate;
        };
    }
    
    public static Specification byValorSpecification(double valor){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Meta_.valor), valor);
            return equalPredicate;
        };
    }
    
    public static Specification byInicioSpecification(Date inicio){
              return (root, query, builder) ->{
                  Predicate equalPredicate = builder.equal(root.get(Meta_.inicio), inicio);
                  return  equalPredicate;

            };
    }
    
    public static Specification byFimSpecification(Date fim){
              return (root, query, builder) ->{
                  Predicate equalPredicate = builder.equal(root.get(Meta_.fim), fim);
                  return  equalPredicate;

            };
    }
    
    public static Specification byRepresentanteSpecification(List representantes){
              return (root, query, builder) ->{
                  Join<Meta, Representante> representanteJoin = root.join(Meta_.representantes);
                  Predicate equalPredicate = representanteJoin.in(root.in(Representante_.idRepresentante), representantes);
                  return  equalPredicate;

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
