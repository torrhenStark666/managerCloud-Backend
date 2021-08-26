/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author boniolo
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_imagem")
@SQLDelete(sql = "update tb_imagem set excluido = true where id_imagem = ?")
@Where(clause = "excluido = false")
public class Imagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_imagem")
    private long idImagem;
    
    private String descricao;
    
    private String formato;
    
    @Lob
    private byte[] imagem;
    
    private boolean excluido;
    
}
