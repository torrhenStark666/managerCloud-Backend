/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Alecsander
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_pedido_compra")
@SQLDelete(sql = "update tb_pedido_compra set excluido = true where id_pedido_compra = ?")
@Where(clause = "excluido = false")
public class PedidoCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido_compra")
    private long idPedidoCompra;
    
    
    @ManyToOne
    @JoinColumn(name="id_fornecedor")
    private Fornecedor fornecedor;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "pedidoCompra")
    private List<ItemPedidoCompra> itensPedidoCompra;
    
    @ManyToOne
    @JoinColumn(name="id_condicao_pagamento")
    private CondicaoPagamento condicaoPagamento;
    
    @ManyToOne
    @JoinColumn(name="id_forma_pagamento")
    private FormaPagamento formaPagamento;
    
    @Column(name="id_conta_contabil")
    private long contaContabil;
    
    @ManyToOne
    @JoinColumn(name="id_solicitante")
    private Solicitante solicitante;
    
    @Column(name="sif_fob")
    private String sifFob;
    
    @Column(name="valor_frete")
    private double valorFrete;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_prevista_entrega")
    private Date dataPrevistaEntrega;
    
    @Column(name = "quantidade_produto")
    private int quantidadeProduto;
    
    @Column(name = "valor_total")
    private double valorTotal;
    
    @Column(columnDefinition = "ENUM('SOLICITADO','LIBERADO', 'PARCIALMENTE_LIBERADO', 'NEGADO', 'ENTREGUE', 'PARCIALMENTE_ENTREGUE')")
    @Enumerated(EnumType.STRING)
    private SituacaoCompra situacao;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_solicitacao")
    private Date dataSolicitacao;
        
    @Temporal(TemporalType.DATE)
    @Column(name="data_entrega")
    private Date dataEntrega;
    
    private boolean excluido;
    
}
