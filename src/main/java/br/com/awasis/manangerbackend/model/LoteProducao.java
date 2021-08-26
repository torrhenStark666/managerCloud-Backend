/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name="tb_lote_producao")
@SQLDelete(sql = "update tb_lote_producao set excluido = true where id_lote_producao = ?")
@Where(clause = "excluido = false")
public class LoteProducao {

    @OneToMany(mappedBy = "loteProducao")
    @JsonIgnore
    private List<PedidoVenda> pedidoVendas;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_lote_producao")
    private long idLoteProducao;
    
    @Column(name="descricaocd")
    private String descricao;
    
    @Column(name="data_inicio")
    private Date dataInicio;
    
    @Column(name="data_final")
    private Date dataFinal;
    
    @Column(name="quantidade_lote")
    private long quantidadeLote;
    
    @Column(name="permite_pedido")
    private Boolean permitePedido;
    
    @Column(name="permite_vendas")
    private Boolean permiteVendas;
    
    private Boolean ativo;
    
    private boolean excluido;
    
}
