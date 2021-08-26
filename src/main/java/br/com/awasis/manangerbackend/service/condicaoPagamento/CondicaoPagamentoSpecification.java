/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.condicaoPagamento;

import br.com.awasis.manangerbackend.model.CondicaoPagamento_;
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
public class CondicaoPagamentoSpecification {
    
    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(CondicaoPagamento_.idCondicaoPagamento), id);
            return equalPredicate;
        };
    }
    
    public static Specification byDescricaoSpecification(String descricao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.like(root.get(CondicaoPagamento_.descricao), "%"+descricao+"%")  ;
            return equalPredicate;
         };
    }
    
    public static Specification bycontasPagarReceberSpecification(String contaPagarReceber){
       return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
           Predicate equalPredicate = builder.like(root.get(CondicaoPagamento_.contasPagarReceber), contaPagarReceber);
           return equalPredicate;
       };
    }
        
    public static Specification byJurosSpecification(double juros){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(CondicaoPagamento_.juros), juros);
            return equalPredicate;
        };
    }
    
    public static Specification byDescontoSpecification(double desconto){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(CondicaoPagamento_.desconto), desconto);
            return equalPredicate;
        };
    }
    
    public static Specification byQuantidadeSpecification(long quantidade){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(CondicaoPagamento_.quantidadeVezes), quantidade);
            return equalPredicate;
        };
    }
    
    public static Specification byPrazoMedioSpecification(long prazoMedio){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(CondicaoPagamento_.prazoMedio), prazoMedio);
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
