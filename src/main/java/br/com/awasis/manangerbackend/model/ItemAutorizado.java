/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import java.util.Date;
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
@Table(name="tb_item_autorizado")
@SQLDelete(sql = "update tb_item_autorizado set excluido = true where id_item_autorizado = ?")
@Where(clause = "excluido = false")
public class ItemAutorizado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item_autorizado")
    private long idItemAutorizado;
    
    @ManyToOne
    @JoinColumn(name="id_item_pedido_compra")
    private ItemPedidoCompra itemPedidoCompra;
    
    @ManyToOne
    @JoinColumn(name="id_liberador")
    private Liberador liberador;
    
    @Column(name="data_liberacao")
    private Date dataLiberacao;
    
    private boolean excluido;
}
