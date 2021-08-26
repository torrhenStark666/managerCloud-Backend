/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.banco;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import br.com.awasis.manangerbackend.model.Banco_;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class BancoSpecification {
    
    public static Specification byNumeroBancoSpecification(String numeroBanco){
              return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
                  Predicate equalPredicate = builder.like(root.get(Banco_.numeroBanco), "%"+numeroBanco.trim()+"%");
                  return  equalPredicate;

            };
    }
    
    public static Specification byAgenciaSpecification(String agencia){
              return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
                  Predicate equalPredicate = builder.like(root.get(Banco_.agencia), "%"+agencia.trim()+"%");
                  return  equalPredicate;

            };
    }
    
    public static Specification byContaSpecification(String conta){
              return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
                  Predicate equalPredicate = builder.like(root.get(Banco_.conta), "%"+conta.trim()+"%");
                  return  equalPredicate;

            };
    }
    
    public static Specification byValorSpecification(double saldo){
              return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
                  Predicate equalPredicate = builder.equal(root.get(Banco_.saldo), saldo);
                  return  equalPredicate;

            };
    }
    
    public static Specification byIdSpecification(long id){
              return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
                  Predicate equalPredicate = builder.equal(root.get(Banco_.idBanco), id);
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