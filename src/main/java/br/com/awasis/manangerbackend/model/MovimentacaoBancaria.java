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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
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
@Table(name="tb_movimentacao_bancaria")
@SQLDelete(sql = "update tb_movimentacao_bancaria set excluido = true where id_movimentacao_bancaria = ?")
@Where(clause = "excluido = false")
public class MovimentacaoBancaria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimentacao_bancaria")
    private long idMovimentacaoBancaria;
    
    @ManyToOne
    @JoinColumn(name="id_banco")
    private Banco banco;
    
    @ManyToMany
    @JoinTable(name = "tb_movimentacao_bancaria_baixa", 
            joinColumns = {
                @JoinColumn(name = "id_movimentacao_bancaria",
                            referencedColumnName = "id_movimentacao_bancaria")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_baixa",
                            referencedColumnName = "id_baixa")}
            )
    
    private List<Baixa> baixas;
    
    @Column(name="id_conta_contabil")
    @Transient
    private long idContaContabil;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="data_movimentacao")
    private Date dataMovimentacao;
    
    private String descricao;
    
    private double valor;
    
    @Column(name="saldo_final")
    private double saldoFinal;
    
    @Column(name="debito_credito")
    private String debitoCredito;
    
    private boolean excluido;
}
