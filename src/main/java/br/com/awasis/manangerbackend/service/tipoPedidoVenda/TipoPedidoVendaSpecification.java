/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoPedidoVenda;

import br.com.awasis.manangerbackend.model.PedidoVenda;
import br.com.awasis.manangerbackend.model.PedidoVenda_;
import br.com.awasis.manangerbackend.model.TipoPedidoVenda;
import br.com.awasis.manangerbackend.model.TipoPedidoVenda_;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class TipoPedidoVendaSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(TipoPedidoVenda_.idTipoPedidoVenda), id);
            return equalPredicate;
        };
    }
    
    public static Specification byIdPedidoVendaSpecification(List pedidosVenda){
        return (root, query, builder) ->{
            Join<TipoPedidoVenda, PedidoVenda> pedidoVendaJoin = root.join(TipoPedidoVenda_.pedidoVendas);
            Predicate equalPredicate = pedidoVendaJoin.in(root.in(PedidoVenda_.idPedidoVenda), pedidosVenda);
            return equalPredicate;
        };
    }  
    
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, builder) ->{
          Predicate equalPredicate = builder.like(root.get(TipoPedidoVenda_.descricao), "%"+descricao.trim()+"%");
          return equalPredicate;
        };
    }
    
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, builder) ->{
          Predicate equalPredicate = builder.equal(root.get(TipoPedidoVenda_.ativo), ativo);
          return equalPredicate;
        };
    }
    
    public static Specification byDuplicataSpecification(boolean duplicata){
        return (root, query, builder) ->{
          Predicate equalPredicate = builder.equal(root.get(TipoPedidoVenda_.duplicata), duplicata);
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
