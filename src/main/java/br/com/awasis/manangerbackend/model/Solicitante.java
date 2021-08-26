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
import javax.persistence.TemporalType;
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
@Table(name="tb_solicitante")
@SQLDelete(sql = "update tb_solicitante set excluido = true where id_solicitante = ?")
@Where(clause = "excluido = false")
public class Solicitante {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_solicitante")
    private long idSolicitante;
    
    
    @ManyToOne
    @JoinColumn(name="id_login")
    private Usuario login;
    
    
    @ManyToOne
    @JoinColumn(name="id_grupo_produto")
    private GrupoProduto grupoProduto;
    
    @ManyToOne
    @JoinColumn(name="id_grupo_solicitante")
    private GrupoSolicitante grupoSolicitante; 
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_inicio")
    private Date dataInicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_fim")
    private Date dataFim;
    
    @Column(name="limite_inicio")
    private Double limiteInicial;
    
    @Column(name="limite_fim")
    private Double limiteFinal;
    
    @Column(name="valor_disponivel")
    private Double valorDisponivel;
    
    private Integer nivel;
    
    private boolean ativo;
    
    private boolean excluido;
    
}
