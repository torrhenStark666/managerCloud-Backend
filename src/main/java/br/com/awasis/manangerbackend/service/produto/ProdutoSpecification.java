/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.produto;

import br.com.awasis.manangerbackend.model.Cor;
import br.com.awasis.manangerbackend.model.Cor_;
import br.com.awasis.manangerbackend.model.Fornecedor;
import br.com.awasis.manangerbackend.model.Fornecedor_;
import br.com.awasis.manangerbackend.model.GrupoProduto;
import br.com.awasis.manangerbackend.model.GrupoProduto_;
import br.com.awasis.manangerbackend.model.Produto;
import br.com.awasis.manangerbackend.model.Produto_;
import br.com.awasis.manangerbackend.model.SubgrupoProduto;
import br.com.awasis.manangerbackend.model.SubgrupoProduto_;
import br.com.awasis.manangerbackend.model.TipoProduto;
import br.com.awasis.manangerbackend.model.TipoProduto_;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 *
 * @author alecsander
 */
public class ProdutoSpecification {
    
    public static Specification byIdSpecification(long id){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.idProduto), id);
            return equalPredicate;
        };
    }  
    
    public static Specification byIdTipoSpecification(long id){
        return (root, query, builder) ->{
            Join<Produto, TipoProduto> tipoProdutoJoin = root.join(Produto_.tipoProduto);
            Predicate equalPredicate = builder.equal(tipoProdutoJoin.get(TipoProduto_.idTipoProduto) , id);
            return equalPredicate;
        };    
    }
    
    public static Specification byIdGrupoSpecification(long id){
        return (root, query, builder) ->{
            Join<Produto, GrupoProduto> grupoProdutoJoin = root.join(Produto_.grupoProduto);
            Predicate equalPredicate = builder.equal(grupoProdutoJoin.get(GrupoProduto_.idGrupoProduto) , id);
            return equalPredicate;
        };    
    }
    
    public static Specification byIdSubGrupoSpecification(long id){
        return (root, query, builder) ->{
            Join<Produto, SubgrupoProduto> subGrupoProdutoJoin = root.join(Produto_.subGrupoProduto);
            Predicate equalPredicate = builder.equal(subGrupoProdutoJoin.get(SubgrupoProduto_.idSubgrupoProduto) , id);
            return equalPredicate;
        };    
    }
    
    public static Specification byIdFornecedorSpecification(List fornecedores){
        return (root, query, builder) ->{
            Join<Produto, Fornecedor> fornecedorJoin = root.join(Produto_.fornecedores);
            Predicate equalPredicate = fornecedorJoin.in(root.in(Fornecedor_.idFornecedor) , fornecedores);
            return equalPredicate;
        };    
    }
    
    public static Specification byIdCoresSpecification(List cores){
        return (root, query, builder) ->{
            Join<Produto, Cor> corJoin = root.join(Produto_.cores);
            Predicate equalPredicate = corJoin.in(root.in(Cor_.idCor) , cores);
            return equalPredicate;
        };    
    }
    
    public static Specification byDescricaoSpecification(String descricao){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.descricao), "%"+descricao.trim()+"%");
            return equalPredicate;
        };       
    }
    
    public static Specification byUnidadeMedidaSpecification(String unidadeMedida){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.unidadeMedida), "%"+unidadeMedida.trim()+"%");
            return equalPredicate;
        };       
    }
    
    public static Specification byUnidadeMedidaTwoSpecification(String unidadeMedidaTwo){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.unidadeMedidaTwo), "%"+unidadeMedidaTwo.trim()+"%");
            return equalPredicate;
        };       
    }
    
    public static Specification byConversorAbudadeTwoSpecification(String conversoAbudade){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.conversoAbudade), "%"+conversoAbudade.trim()+"%");
            return equalPredicate;
        };       
    }
    
    public static Specification byFatorConversorTwoSpecification(long fatorConversor){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.fatorConversor), fatorConversor);
            return equalPredicate;
        };       
    }
            
    public static Specification byCodigoBarrasFornecedorSpecification(long codigoBarrasFornecedor){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.codigoBarrasFornecedor), codigoBarrasFornecedor);
            return equalPredicate;
        };       
    }    
    
    public static Specification byCodigoBarrasSpecification(long codigoBarras){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.codigoBarras), codigoBarras);
            return equalPredicate;
        };       
    } 
    
    public static Specification byPesoSpecification(double peso){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.peso), peso);
            return equalPredicate;
        };       
    }

    public static Specification byValorSpecification(double valor){
        return (root, query, builder) ->{
            Predicate equalPredicate = builder.equal(root.get(Produto_.valor), valor);
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
