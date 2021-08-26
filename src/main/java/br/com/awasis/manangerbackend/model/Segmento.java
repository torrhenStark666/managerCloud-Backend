/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="tb_segmento")
@SQLDelete(sql = "update tb_segmento set excluido = true where id_segmento = ?")
@Where(clause = "excluido = false")
public class Segmento {

    @OneToMany(mappedBy = "segmento")
    private List<Referencia> referencias;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_segmento")
    private long idSegmento;
    
    private String descricao;
    
    private boolean ativo;
    
    private boolean excluido;
}
