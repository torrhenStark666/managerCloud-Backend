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
import javax.persistence.Temporal;
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
@Table(name="tb_renegociacao_receber")
@SQLDelete(sql = "update tb_renegociacao_receber set excluido = true where id_renegociacao_receber = ?")
@Where(clause = "excluido = false")
public class RenegociacaoReceber {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_renegociacao_receber")
    private long idRenegociacaoReceber;
    
    @ManyToOne
    @JoinColumn(name="id_titulo_receber")
    private TituloReceber tituloReceber;
    
    @ManyToOne
    @JoinColumn(name="id_condicao_pagamento")
    private CondicaoPagamento condicaoPagamento;
    
    @ManyToOne
    @JoinColumn(name="id_forma_pagamento")
    private FormaPagamento formaPagamento;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_lancamento")
    private TipoLancamento tipoLancamento;
    
    @ManyToOne
    @JoinColumn(name="id_natureza")
    private Natureza natureza;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="data_renegociacao")
    private Date dataNegociacao;
    
    @Column(name="valor_original")
    private double valorOriginal;
    
    @Column(name="valor_renegociado")
    private double valorRenegociado;
    
    private boolean excluido;
}
