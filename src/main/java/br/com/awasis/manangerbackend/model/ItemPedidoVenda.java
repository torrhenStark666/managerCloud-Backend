/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="tb_item_pedido_venda")
@SQLDelete(sql = "update tb_item_pedido_venda set excluido = true where id_item_pedido_venda = ?")
@Where(clause = "excluido = false")
public class ItemPedidoVenda {
                 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item_pedido_venda")
    private long idItemPedidoVenda;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="id_pedido_venda")
    private PedidoVenda pedidoVenda;
    
    @ManyToOne
    @JoinColumn(name="id_referencia")
    private Referencia referencia;
    
    @ManyToOne
    @JoinColumn(name="id_cor")
    private Cor cor;
    
    private double quantidade;
    
    private boolean excluido;
                            
}
