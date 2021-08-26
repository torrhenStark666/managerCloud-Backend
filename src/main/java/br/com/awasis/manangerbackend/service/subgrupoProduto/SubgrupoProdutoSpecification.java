/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.subgrupoProduto;

import br.com.awasis.manangerbackend.model.GrupoProduto;
import br.com.awasis.manangerbackend.model.GrupoProduto_;
import br.com.awasis.manangerbackend.model.SubgrupoProduto;
import br.com.awasis.manangerbackend.model.SubgrupoProduto_;
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
public class SubgrupoProdutoSpecification {

    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(SubgrupoProduto_.idSubgrupoProduto), id);
            return equalPredicate;
        };
    }
    
    public static Specification byDescricaoSpecification(String descricao){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
          Predicate equalPredicate = builder.like(root.get(SubgrupoProduto_.descricao), "%"+descricao+"%");
          return equalPredicate;
        };
    }
    
    public static Specification byAtivoSpecification(boolean ativo){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
          Predicate equalPredicate = builder.equal(root.get(SubgrupoProduto_.ativo), ativo);
          return equalPredicate;
        };
    }
    
    public static Specification byGrupoProdutoSpecification(GrupoProduto gp){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
          Predicate equalPredicate = builder.equal(root.get(SubgrupoProduto_.grupoProduto), gp);
          return equalPredicate;
        };
    }
    
    public static Specification byDescricaoGrupoProdutoSpecification(String descricao){
          return (Root root, CriteriaQuery query,CriteriaBuilder builder) -> {
              Join<SubgrupoProduto, GrupoProduto> grupoProdutoJoin = root.join(SubgrupoProduto_.grupoProduto);
              Predicate equalPredicate = builder.like(grupoProdutoJoin.get(GrupoProduto_.descricao), "%"+descricao.trim()+"%");
              return  equalPredicate;
              
        };
    }
    
    public static Specification byIdGrupoProdutoSpecification(long id){
          return (Root root, CriteriaQuery query,CriteriaBuilder builder) -> {
              Join<SubgrupoProduto, GrupoProduto> grupoProdutoJoin = root.join(SubgrupoProduto_.grupoProduto);
              Predicate equalPredicate = builder.equal(grupoProdutoJoin.get(GrupoProduto_.idGrupoProduto), id);
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
