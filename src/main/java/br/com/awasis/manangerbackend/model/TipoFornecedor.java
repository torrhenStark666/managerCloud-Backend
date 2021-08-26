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
@Table(name = "tb_tipo_fornecedor")
@SQLDelete(sql = "update id_tipo_fornecedor set excluido = true where id_fornecedor = ?")
@Where(clause = "excluido = false")
public class TipoFornecedor {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_fornecedor")
    private long idTipoFornecedor;
    
    private String descricao;
    
    private boolean ativo;
    
    private boolean excluido;
    
}
