/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.setor;

import br.com.awasis.manangerbackend.model.Setor;
import br.com.awasis.manangerbackend.model.TabelaPreco;
import br.com.awasis.manangerbackend.model.RegraNegocio;
import br.com.awasis.manangerbackend.model.FaixaCep;
import br.com.awasis.manangerbackend.model.FaixaCep_;
import br.com.awasis.manangerbackend.model.RegraNegocio_;
import br.com.awasis.manangerbackend.model.Setor_;
import br.com.awasis.manangerbackend.model.TabelaPreco_;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class SetorSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Setor_.idSetor), id);
            return equalPredicate;
        };
    }    
    
    public static Specification byIdFaixaCepSpecification(long id){
        return (root, query, build) ->{
            Join<Setor, FaixaCep> faixaCepJoin = root.join(Setor_.faixaCep);
            Predicate equalPredicate = build.equal(faixaCepJoin.get(FaixaCep_.idFaixaCep), id);
            
            return equalPredicate;
        };
    }
    
    public static Specification byIdTabelasPrecoSpecification(List tabelaPreco){
        return (root, query, build) ->{
            Join<Setor, TabelaPreco> tabelaPrecoJoin = root.join(Setor_.tabelaPrecos);
            Predicate equalPredicate = tabelaPrecoJoin.in(root.in(TabelaPreco_.idTabelaPreco), tabelaPreco);
            
            return equalPredicate;
        };
    }
    
    public static Specification byIdRegrasNegocioSpecification(List regraNegocio){
        return (root, query, build) ->{
            Join<Setor, RegraNegocio> tabelaPrecoJoin = root.join(Setor_.regrasNegocio);
            Predicate equalPredicate = tabelaPrecoJoin.in(root.in(RegraNegocio_.idRegraNegocio), regraNegocio);
            
            return equalPredicate;
        };
    }
    
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, build) ->{
            Predicate equalPredicate = build.like(root.get(Setor_.descricao), "%"+descricao.trim()+"%");   
            return equalPredicate;
        };
    }
    
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, build) ->{
            Predicate equalPredicate = build.equal(root.get(Setor_.ativo), ativo);
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
