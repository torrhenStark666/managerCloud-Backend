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
 * @author Alecsander
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_banco")
@SQLDelete(sql = "update tb_banco set excluido = true where id_banco = ?")
@Where(clause = "excluido = false")
public class Banco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_banco")
    private long idBanco;
    
    @Column(name="numero_banco")
    private String numeroBanco;
    
    private String agencia;
    
    private String conta;
        
    private double saldo;
    
    @Column(name="data_inclusao")
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    
    private boolean excluido;
    
}
