/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.awasis.manangerbackend.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
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
@Table(name = "tb_renegociacao_pagar")
@SQLDelete(sql = "update tb_renegociacao_pagar set excluido = true where id_renegociacao_pagar = ?")
@Where(clause = "excluido = false")
public class RenegociacaoPagar {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_renegociacao_pagar")
    private long idRenegociacaoPagar;
    
    @ManyToOne
    @JoinColumn(name="id_titulo_pagar")
    private TituloReceber tituloPagar;
    
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
