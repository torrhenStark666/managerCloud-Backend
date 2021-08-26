/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
@Table(name = "tb_empresa")
@SQLDelete(sql = "update tb_empresa set excluido = true where id_modulo = ?")
@Where(clause = "excluido = false")
public class Empresa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empresa")
    private long idEmpresa;
    
    @ManyToMany
    @JoinTable(name = "tb_empresa_contato", 
            joinColumns = {
                @JoinColumn(name = "id_empresa",
                            referencedColumnName = "id_empresa")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_contato",
                            referencedColumnName = "id_contato")}
            )
    private List<Contato> contatos;
    /*
    @ManyToMany
    @JoinTable(name = "tb_empresa_modulo", 
            joinColumns = {
                @JoinColumn(name = "id_empresa",
                            referencedColumnName = "id_empresa")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_modulo",
                            referencedColumnName = "id_modulo")}
            )
    private List<Modulo> modulos;
    */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    
    @Column(length = 20)
    private String cnpj;
    
    @Column(length = 50, name = "nome_fantasia")
    private String nomeFantasia;
    
    @Column(length = 50, name = "razao_social")
    private String razaoSocial;
    
    @Column(length = 50, name = "incricao_estadual")
    private String incricaoEstadual;
    
    @Column(length = 50, name = "inscricao_municipal")
    private String incricaoMunicipal;
    
    private boolean excluido;
    
}
