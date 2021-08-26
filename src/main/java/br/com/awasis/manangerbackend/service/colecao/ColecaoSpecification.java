/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.colecao;

import br.com.awasis.manangerbackend.model.Colecao_;
import java.util.Date;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class ColecaoSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.idColecao), id);
            return equalPredicate;
        };
    }
    
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.descricao), "%"+ descricao.trim().replace(" ", "%")+"%");
            return equalPredicate;
        };
    }
    
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.ativo), ativo);
            return equalPredicate;
        };
    }
    
    public static Specification byQuantidadePrevistaSpecification(long quantidadePrevista){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.quantidadePrevista), quantidadePrevista);
            return equalPredicate;
        };
    }   

    public static Specification byQuantidadeVendidaSpecification(long quantidadeVendida){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.quantidadeVendida), quantidadeVendida);
            return equalPredicate;
        };
    }
    
    public static Specification byDataInicioColecaoSpecification(Date dataInicioColecao){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.dataInicioColecao), dataInicioColecao);
            return equalPredicate;
        };
    } 
    
    public static Specification byDataFimColecaoSpecification(Date dataFimColecao){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.dataFimColecao), dataFimColecao);
            return equalPredicate;
        };
    }
    
    public static Specification byDataInicioProducaoSpecification(Date dataInicioProducao){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.dataInicioProducao), dataInicioProducao);
            return equalPredicate;
        };
    }    

    public static Specification byDataFimProducaoSpecification(Date dataFimProducao){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(Colecao_.dataFimProducao), dataFimProducao);
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
