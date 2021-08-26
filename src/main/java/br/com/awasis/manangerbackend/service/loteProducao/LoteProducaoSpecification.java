/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.loteProducao;

import br.com.awasis.manangerbackend.model.LoteProducao_;
import java.util.Date;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class LoteProducaoSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(LoteProducao_.idLoteProducao), id);
            return equalPredicate;
        };
    }
    public static Specification byQuantidadeLoteSpecification(long quantidadeLote){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(LoteProducao_.quantidadeLote), quantidadeLote);
            return equalPredicate;
        };
    }
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, builder) -> {
            Predicate equalPredicate = builder.equal(root.get(LoteProducao_.descricao), "%"+descricao.trim()+"%");
            return equalPredicate;
        };
    }
    
    public static Specification byDataInicioSpecification(Date dataInicio){
              return (root, query, builder) ->{
                  Predicate equalPredicate = builder.equal(root.get(LoteProducao_.dataInicio), dataInicio);
                  return  equalPredicate;

            };
    }
    
    public static Specification byDataFimSpecification(Date dataFinal){
              return (root, query, builder) ->{
                  Predicate equalPredicate = builder.equal(root.get(LoteProducao_.dataFinal), dataFinal);
                  return  equalPredicate;

            };
    }
    
    public static Specification byAtivoSpecification(boolean ativo){
        return (root, query, builder) ->{
          Predicate equalPredicate = builder.equal(root.get(LoteProducao_.ativo), ativo);
          return equalPredicate;
        };
    }
    
    public static Specification byPermiteVendasSpecification(boolean permiteVendas){
        return (root, query, builder) ->{
          Predicate equalPredicate = builder.equal(root.get(LoteProducao_.permiteVendas), permiteVendas);
          return equalPredicate;
        };
    }
    
    public static Specification byPermitePedidosSpecification(boolean permitePedido){
        return (root, query, builder) ->{
          Predicate equalPredicate = builder.equal(root.get(LoteProducao_.permitePedido), permitePedido);
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
