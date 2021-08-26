/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@Table(name="tb_item_pedido_compra")
@SQLDelete(sql = "update tb_item_pedido_compra set excluido = true where id_item_pedido_compra = ?")
@Where(clause = "excluido = false")
public class ItemPedidoCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item_pedido_compra")
    private long idItemPedidoCompra;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido_compra")
    @JsonIgnore @ToString.Exclude
    private PedidoCompra pedidoCompra;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name="id_cor")
    private Cor cor;
    
    @ManyToOne
    @JoinColumn(name="id_liberador")
    private Liberador liberador;
    
    @ManyToOne
    @JoinColumn(name="id_solicitante")
    private Solicitante solicitante;
    
    @Column(columnDefinition = "ENUM('SOLICITADO','LIBERADO', 'PARCIALMENTE_LIBERADO', 'NEGADO', 'ENTREGUE', 'PARCIALMENTE_ENTREGUE')")
    @Enumerated(EnumType.STRING)
    private SituacaoCompra situacao;
    
    private int nivel;
    
    @Column(name="data_situacao")
    @Temporal(TemporalType.DATE)
    private Date dataSituacao;
    
    private double quantidade;
    
    private double valor;
    
    private boolean excluido;
            
    
}
