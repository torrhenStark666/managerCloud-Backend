/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.regranegocio;

import br.com.awasis.manangerbackend.model.RegraNegocio_;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class RegraNegocioSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, build) -> {
            Predicate equalPredicate = build.equal(root.get(RegraNegocio_.idRegraNegocio), id);
            return equalPredicate;
        };
    }
    
    public static Specification byPrecoOneSpecification(double preco){
        return (root, query, build) -> {
            Predicate equalPredicate = build.equal(root.get(RegraNegocio_.precoOne), preco);
            return equalPredicate;
        };
    }
    
    public static Specification byPrecoTwoSpecification(double preco){
        return (root, query, build) -> {
            Predicate equalPredicate = build.equal(root.get(RegraNegocio_.precoTwo), preco);
            return equalPredicate;
        };
    }
    
    public static Specification byPrecoThreeSpecification(double preco){
        return (root, query, build) -> {
            Predicate equalPredicate = build.equal(root.get(RegraNegocio_.precoThree), preco);
            return equalPredicate;
        };
    }   

    public static Specification byDescontoReferenciaSpecification(double descontoReferencia){
        return (root, query, build) -> {
            Predicate equalPredicate = build.equal(root.get(RegraNegocio_.descontoReferencia), descontoReferencia);
            return equalPredicate;
        };
    } 
    
    public static Specification byComissaoReferenciaSpecification(double comissaoReferencia){
        return (root, query, build) -> {
            Predicate equalPredicate = build.equal(root.get(RegraNegocio_.comissaoReferencia), comissaoReferencia);
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
