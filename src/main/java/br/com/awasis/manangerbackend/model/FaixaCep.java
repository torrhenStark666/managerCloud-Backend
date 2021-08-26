/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_faixa_cep")
@SQLDelete(sql = "update tb_faixa_cep set excluido = true where id_faixa_cep = ?")
@Where(clause = "excluido = false")
public class FaixaCep {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_faixa_cep")
    private long idFaixaCep;
    
    private double comissao;
    
    private double desconto;
    
    @Column(name="cep_inicial")
    private String cepInicial;
    
    @Column(name="cep_final")
    private String cepFinal;
    
    private boolean excluido;
    
}
