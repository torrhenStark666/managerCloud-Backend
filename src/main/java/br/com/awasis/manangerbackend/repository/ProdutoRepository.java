/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.repository;

import br.com.awasis.manangerbackend.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alecsander
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto>{
    
    @Query(
value="SELECT\n" +
"	p.id_produto as id_produto,\n" +
"       p.id_tipo_produto as id_tipo_produto,\n" +
"       p.id_grupo_produto as id_grupo_produto,\n" +
"       p.id_conta_contabil as id_conta_contabil,\n" +
"       p.id_subgrupo_produto as id_subgrupo_produto,\n" +
"       p.descricao as descricao,\n" +
"       p.unidade_medida as unidade_medida,\n" +
"       p.unidade_medida2 as unidade_medida2,\n" +
"       p.conversor_abudade as conversor_abudade,\n" +
"       p.fator_conversor as fator_conversor,\n" +
"       p.codigo_barras_fornecedor as codigo_barras_fornecedor,\n" +
"       p.codigo_barras as codigo_barras,\n" +
"       p.peso as peso,\n" +
"       p.altura as altura,\n" +
"       p.largura as largura,\n" +
"       p.quantidade_max as quantidade_max,\n" +
"       p.quantidade_min as quantidade_min,\n" +
"       p.ponto_pedido as ponto_pedido,\n" +
"       p.lote_economico as lote_economico,\n"+
"       p.data_ultima_compra as data_ultima_compra,\n" +
"       p.pontuacao as pontuacao,\n" +
"       p.calculo_valor as calculo_valor,\n" +
"       ifnull((CASE\n" +
"		WHEN p.calculo_valor LIKE 'MEDIO'\n" +
"		THEN (\n" +
"			SELECT\n" +
"				ROUND(AVG(i.valor),2)\n" +
"			FROM\n" +
"				tb_item_pedido_compra i\n" +
"			WHERE\n" +
"				i.id_produto = p.id_produto\n" +
"        )\n" +
"               WHEN p.calculo_valor LIKE 'MAIOR_VALOR'\n" +
"               THEN(\n" +
"			SELECT\n" +
"				ROUND(i.valor,2)\n" +
"			FROM\n" +
"				tb_item_pedido_compra i\n" +
"			WHERE\n" +
"				i.id_produto = p.id_produto\n" +
"                       ORDER BY\n" +
"				i.id_produto DESC\n "+
"                       LIMIT 1\n" +
"        )\n" +
"               WHEN p.calculo_valor LIKE 'MENOR_VALOR'\n" +
"               THEN(\n" +
"			SELECT\n" +
"				ROUND(MIN(i.valor),2)\n" +
"			FROM\n" +
"				tb_item_pedido_compra i\n" +
"			WHERE\n" +
"				i.id_produto = p.id_produto\n" +
"        )\n" +
"	 END\n" +
"        ),0.00) as valor,\n" +
"        p.excluido as excluido\n" +
"       FROM\n" +
"	tb_produto p\n", 
        nativeQuery = true
    )
    public List<Produto> findAllProdutos();

}
