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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Table(name="tb_meta")
@SQLDelete(sql = "update tb_meta set excluido = true where id_meta= ?")
@Where(clause = "excluido = false")
public class Meta {
    
    @ManyToMany(mappedBy = "metas")
    private List<Representante>  representantes;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_meta")
    private long idMeta;
    
    private double valor;
    
    private int quantidade;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")    
    private Date inicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fim;
    
    private boolean excluido;
    
}
