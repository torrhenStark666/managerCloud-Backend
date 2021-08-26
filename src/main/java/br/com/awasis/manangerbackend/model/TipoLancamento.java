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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_tipo_lancamento")
@SQLDelete(sql = "update tb_tipo_lancamento set excluido = true where id_tipo_lancamento = ?")
@Where(clause = "excluido = false")
public class TipoLancamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_lancamento")
    private long idTipoLancamento;
    
    private String descricao;
    
    private String tipo;
    
    private boolean excluido;
}
