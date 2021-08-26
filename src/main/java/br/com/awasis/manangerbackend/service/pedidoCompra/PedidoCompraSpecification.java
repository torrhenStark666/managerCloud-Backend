/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.pedidoCompra;

import br.com.awasis.manangerbackend.model.FormaPagamento;
import br.com.awasis.manangerbackend.model.FormaPagamento_;
import br.com.awasis.manangerbackend.model.CondicaoPagamento;
import br.com.awasis.manangerbackend.model.CondicaoPagamento_;
import br.com.awasis.manangerbackend.model.Fornecedor;
import br.com.awasis.manangerbackend.model.Fornecedor_;
import br.com.awasis.manangerbackend.model.PedidoCompra;
import br.com.awasis.manangerbackend.model.PedidoCompra_;
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
public class PedidoCompraSpecification {
    
    
    public static Specification byIdSpecification(long id){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
            Predicate equalPredicate = builder.equal(root.get(PedidoCompra_.idPedidoCompra), id);
            return equalPredicate;
        };
    }
    
    public static Specification byIdFornecedorSpecification(long id){
        return (root, query, builder) ->{
            Join<PedidoCompra, Fornecedor> grupoProdutoJoin = root.join(PedidoCompra_.fornecedor);
            Predicate equalPredicate = builder.equal(grupoProdutoJoin.get(Fornecedor_.idFornecedor) , id);
            return equalPredicate;
        };    
    }
    
    public static Specification byIdCondicaoPagamentoSpecification(long id){
        return (root, query, builder) ->{
            Join<PedidoCompra, CondicaoPagamento> grupoProdutoJoin = root.join(PedidoCompra_.condicaoPagamento);
            Predicate equalPredicate = builder.equal(grupoProdutoJoin.get(CondicaoPagamento_.idCondicaoPagamento) , id);
            return equalPredicate;
        };    
    }
    
    public static Specification byIdFormaPagamentoSpecification(long id){
        return (root, query, builder) ->{
            Join<PedidoCompra, FormaPagamento> grupoProdutoJoin = root.join(PedidoCompra_.formaPagamento);
            Predicate equalPredicate = builder.equal(grupoProdutoJoin.get(FormaPagamento_.idFormaPagamento) , id);
            return equalPredicate;
        };    
    }
    
    public static Specification bySifFobSpecification(String sifFob){
        return (Root root, CriteriaQuery query, CriteriaBuilder builder) ->{
          Predicate equalPredicate = builder.like(root.get(PedidoCompra_.sifFob), "%"+sifFob+"%");
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
