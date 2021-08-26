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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="tb_compensacao")
@SQLDelete(sql = "update tb_compensacao set excluido = true where id_compensacao = ?")
@Where(clause = "excluido = false")
public class Compensacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compensacao")
    private long idCompensacao;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="id_fornecedor")
    private Fornecedor forncedor;
    
    @OneToMany
    @JoinColumn(name="id_baixa")
    private List<Baixa> baixas;
    
    @Column(name="data_compensacao")
    private Date dataCompensacao;
    
    private boolean excluido;
    
}
