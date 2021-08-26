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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Alecsander
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_titulo_pagar")
@SQLDelete(sql = "update tb_titulo_pagar set excluido = true where id_titulo_pagar = ?")
@Where(clause = "excluido = false")
public class TituloPagar {

    @OneToMany(mappedBy = "tituloPagar")
    @JsonIgnore
    private List<ParcelaPagar> parcelasPagar;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_titulo_pagar")
    private long idTituloPagar;
    
    
    @ManyToOne
    @JoinColumn(name="id_fornecedor")
    private Fornecedor fornecedor;
    
    @ManyToOne
    @JoinColumn(name="id_condicao_pagamento")
    private CondicaoPagamento condicaoPagamento;
    
    @ManyToOne
    @JoinColumn(name="id_forma_pagamento")
    private FormaPagamento formaPagamento;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_lancamento")
    private TipoLancamento tipoLancamento;
    
    @Column(name="id_conta_contabil")
    @Transient
    private long idContaContabil;
    
    @Column(name="data_inclusao")
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInclusao;
    
    @Column(name="data_lancamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLancamento;
    
    @Column(name ="valor_total",scale = 2, precision = 10)
    private double valorTotal;
    
    private boolean excluido;
}
