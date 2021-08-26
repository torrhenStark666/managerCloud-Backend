/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tituloPagar;

import br.com.awasis.manangerbackend.model.CondicaoPagamento;
import br.com.awasis.manangerbackend.model.CondicaoPagamento_;
import br.com.awasis.manangerbackend.model.FormaPagamento;
import br.com.awasis.manangerbackend.model.FormaPagamento_;
import br.com.awasis.manangerbackend.model.Fornecedor;
import br.com.awasis.manangerbackend.model.Fornecedor_;
import br.com.awasis.manangerbackend.model.TipoLancamento;
import br.com.awasis.manangerbackend.model.TipoLancamento_;
import br.com.awasis.manangerbackend.model.TituloPagar;
import br.com.awasis.manangerbackend.model.TituloPagar_;
import java.util.Date;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class TituloPagarSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder)->{
            Predicate equalPredicate = builder.equal(root.get(TituloPagar_.idTituloPagar), id);
        
            return equalPredicate;
        };
    }
    
    public static Specification byDataInclusaoSpecification(Date dataInclusao){
        return (root, query, builder)->{
            Predicate equalPredicate = builder.equal(root.get(TituloPagar_.dataInclusao), dataInclusao);
        
            return equalPredicate;
        };
    }
    
    public static Specification byDataLancamentoSpecification(Date dataLancamento){
        return (root, query, builder)->{
            Predicate equalPredicate = builder.equal(root.get(TituloPagar_.dataLancamento), dataLancamento);
        
            return equalPredicate;
        };
    }
    
    public static Specification byIdCondicaoPagamentoSpecification(long id){
        return (root, query, builder)->{
            Join<TituloPagar, CondicaoPagamento> fornecedorJoin =root.join(TituloPagar_.condicaoPagamento);
            Predicate equalPredicate = builder.equal(fornecedorJoin.get(CondicaoPagamento_.idCondicaoPagamento), id);
        
            return equalPredicate;
        };
    }
    
    public static Specification byIdFormaPagamentoSpecification(long id){
        return (root, query, builder)->{
            Join<TituloPagar, FormaPagamento> fornecedorJoin =root.join(TituloPagar_.formaPagamento);
            Predicate equalPredicate = builder.equal(fornecedorJoin.get(FormaPagamento_.idFormaPagamento), id);
        
            return equalPredicate;
        };
    }

    public static Specification byIdTipoLancamentoSpecification(long id){
        return (root, query, builder)->{
            Join<TituloPagar, TipoLancamento> fornecedorJoin =root.join(TituloPagar_.tipoLancamento);
            Predicate equalPredicate = builder.equal(fornecedorJoin.get(TipoLancamento_.idTipoLancamento), id);
        
            return equalPredicate;
        };
    }
    
    public static Specification byIdFornecedorSpecification(long id){
        return (root, query, builder)->{
            Join<TituloPagar, Fornecedor> fornecedorJoin =root.join(TituloPagar_.fornecedor);
            Predicate equalPredicate = builder.equal(fornecedorJoin.get(Fornecedor_.idFornecedor), id);
        
            return equalPredicate;
        };
    }

    public static Specification byCnpjFornecedorSpecification(String cnpj){
        return (root, query, builder)->{
            Join<TituloPagar, Fornecedor> fornecedorJoin =root.join(TituloPagar_.fornecedor);
            Predicate equalPredicate = builder.equal(fornecedorJoin.get(Fornecedor_.cnpj), "%"+cnpj.trim()+"%");
        
            return equalPredicate;
        };
    }

    public static Specification byCpfFornecedorSpecification(String cpf){
        return (root, query, builder)->{
            Join<TituloPagar, Fornecedor> fornecedorJoin =root.join(TituloPagar_.fornecedor);
            Predicate equalPredicate = builder.equal(fornecedorJoin.get(Fornecedor_.cpf), "%"+cpf.trim()+"%");
        
            return equalPredicate;
        };
    }

    public static Specification byInscricaoEstadualFornecedorSpecification(String inscricaoEstadual){
        return (root, query, builder)->{
            Join<TituloPagar, Fornecedor> fornecedorJoin =root.join(TituloPagar_.fornecedor);
            Predicate equalPredicate = builder.equal(fornecedorJoin.get(Fornecedor_.inscricaoEstadual), "%"+inscricaoEstadual.trim()+"%");
        
            return equalPredicate;
        };
    }
    
    public static Specification byRazaoSocialFornecedorSpecification(String razaoSocial){
        return (root, query, builder)->{
            Join<TituloPagar, Fornecedor> fornecedorJoin =root.join(TituloPagar_.fornecedor);
            Predicate equalPredicate = builder.like(fornecedorJoin.get(Fornecedor_.razaoSocial), "%"+razaoSocial.trim()+"%");
        
            return equalPredicate;
        };
    }
    
    public static Specification byNomeFantasiaFornecedorSpecification(String nomeFantasia){
        return (root, query, builder)->{
            Join<TituloPagar, Fornecedor> fornecedorJoin =root.join(TituloPagar_.fornecedor);
            Predicate equalPredicate = builder.like(fornecedorJoin.get(Fornecedor_.nomeFantasia), "%"+nomeFantasia.trim()+"%");
        
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
