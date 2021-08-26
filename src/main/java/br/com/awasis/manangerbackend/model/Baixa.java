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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name="tb_baixa")
@SQLDelete(sql = "update tb_baixa set excluido = true where id_baixa = ?")
@Where(clause = "excluido = false")
public class Baixa {

    @ManyToMany(mappedBy = "baixas")
    @JsonIgnore
    private List<MovimentacaoBancaria> movimentacoesBancarias;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_baixa")
    private Long idBaixa;
    
    @ManyToOne
    @JoinColumn(name="id_natureza")
    private Natureza natureza;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_lancamento")
    private TipoLancamento tipoLancamento;
    
    @ManyToMany
    @JoinTable(name = "tb_baixa_parcela_pagar", 
            joinColumns = {
                @JoinColumn(name = "id_baixa",
                            referencedColumnName = "id_baixa")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_parcela_pagar",
                            referencedColumnName = "id_parcela_pagar")}
            )
    private List<ParcelaPagar> parcelasPagar;
    
    @ManyToMany
    @JoinTable(name = "tb_baixa_parcela_receber", 
            joinColumns = {
                @JoinColumn(name = "id_baixa",
                            referencedColumnName = "id_baixa")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_parcela_receber",
                            referencedColumnName = "id_parcela_receber")}
            )
    private List<ParcelaReceber> parcelasReceber;
    
    @Column(name="id_conta_contabil")
    @Transient
    private Long idContaCotabil;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_baixa")
    private Date dataBaixa;
    
    @Column(name="valor_baixa")
    private Double valorBaixa;
    
    private Double decressimo;
    
    @Column(name="dias_atraso")
    private Integer diasAtraso;
    
    @Column(name="tipo_pagar_receber")
    private String tipoPagarReceber;
    
    private Boolean excluido;
    
}
