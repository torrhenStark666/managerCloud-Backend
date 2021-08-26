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
import javax.persistence.ManyToMany;
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
@Table(name="tb_parcela_receber")
@SQLDelete(sql = "update tb_parcela_receber set excluido = true where id_parcela_receber = ?")
@Where(clause = "excluido = false")
public class ParcelaReceber {

    @ManyToMany(mappedBy = "parcelasReceber")
    private List<Baixa> baixas;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_parcela_receber")
    private long idParcelaReceber;
    
    @ManyToOne
    @JoinColumn(name="id_titulo_receber")
    private TituloReceber tituloReceber;
    
    private String parcela;
    
    @Column(name="data_vencimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimento;
    
    @Column(name="valor_original")
    private double valorOriginal;
    
    @Column(name="valor_pagar")
    private double valorPagar;
    
    @Column(name="percentual_desconto")
    private double percentualDesconto;
    
    @Column(name="valor_desconto")
    private double valorDesconto;
    
    @Column(name="percentual_juro")
    private double percentualJuro;
    
    @Column(name="valor_juro")
    private double valorJuro;
    
    private boolean excluido;
    
}
