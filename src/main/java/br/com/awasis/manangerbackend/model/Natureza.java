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
@Table(name="tb_natureza")
@SQLDelete(sql = "update tb_natureza set excluido = true where id_natureza = ?")
@Where(clause = "excluido = false")
public class Natureza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_natureza")
    private long idNatureza;
    
    @Transient
    private long idContaContabil;
    
    private String descricao;
    
    @Column(name="tipo_debito_credito")
    private String tipoDebitoCredito;
    
    private boolean excluido;
    
}
