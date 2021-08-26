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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author alecsander
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_pedido_venda")
@SQLDelete(sql = "update tb_pedido_venda set excluido = true where id_pedido_venda = ?")
@Where(clause = "excluido = false")
public class PedidoVenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_venda")
    private long idPedidoVenda;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoVenda", fetch = FetchType.LAZY)
    private List<ItemPedidoVenda> itensPedidoVenda;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_pedido_venda")
    private TipoPedidoVenda tipoPedidoVenda;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_representante")
    private Representante representante;
    
    
    @ManyToOne
    @JoinColumn(name = "id_transportadora")
    private Transportadora transportadora;
    
    
    @ManyToOne
    @JoinColumn(name = "id_condicao_pagamento")
    private CondicaoPagamento condicaoPagamento;
    
    
    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento")
    private FormaPagamento formaPagamento;
    
    
    @ManyToOne
    @JoinColumn(name = "id_lote_producao")
    private LoteProducao loteProducao;
    
    
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque estoque;
    
    @Column(name = "total_pecas")
    private int totalPecas;
    
    @Column(name = "prioridade")
    private int prioridade;
    
    @Column(name = "data_digitacao")
    private Date dataDigitacao;
    
    @Column(name = "data_prevista_entrega")
    private Date dataPrevistaEntrega;
    
    @Column(name = "data_aprovacao")
    private Date dataAprovacao;
    
    private String descricao;
    
    private String digitador;
    
    private String aprovador;
    
    @Column(name = "tipo_titulo")
    private String tipoTitulo;
    
    private boolean aprovado;
    
    private boolean ativo;
    
    private boolean excluido;
    
}
