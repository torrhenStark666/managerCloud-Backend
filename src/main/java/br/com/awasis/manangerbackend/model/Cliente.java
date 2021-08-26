/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Table(name="tb_cliente")
@SQLDelete(sql = "update tb_cliente set excluido = true where id_cliente = ?")
@Where(clause = "excluido = false")
public class Cliente {

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<PedidoVenda> pedidoVendas;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private long idCliente;
    
    
    @ManyToOne
    @JoinColumn(name = "id_grupo_cliente")
    private GrupoCliente grupoCliente;
    
    
    @ManyToMany
    @JoinTable(name = "tb_cliente_contato", 
            joinColumns = {
                @JoinColumn(name = "id_cliente",
                            referencedColumnName = "id_cliente")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_contato",
                            referencedColumnName = "id_contato")}
            )
    private List<Contato> contatos;
    
    @ManyToMany
    @JoinTable(name = "tb_cliente_regra_negocio", 
            joinColumns = {
                @JoinColumn(name = "id_cliente",
                            referencedColumnName = "id_cliente")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_regra_negocio",
                            referencedColumnName = "id_regra_negocio")}
            )
    private List<RegraNegocio> regrasNegocio;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_endereco")
    private Endereco endereco;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_imagem")
    private Imagem imagem;
    
    @ManyToOne
    @JoinColumn(name="id_setor")
    private Setor setor;
    
    @ManyToOne
    @JoinColumn(name="id_representante")
    private Representante representante;
    
    @Column(name="razao_social")
    private String razaoSocial;
    
    @Column(name="nome_fantasia")
    private String nomeFantasia;    
    
    private String cnpj;
    
    private String cpf;
    
    @Column(name="inscricao_estadual")
    private String inscricaoEstadual;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_ultima_compra")
    private Date dataUltimaCompra;
    
    @Column(name = "consumidor_final")
    private String consumidorFinal;
    
    @Column(name = "bloqueado_inativo")
    private Boolean bloqueadoInativo;
    
    @Column(name = "bloquear_vendas")
    private Boolean bloqueadorVendas;
    
    @Column(name = "bloquear_faturamento")
    private Boolean bloqueadorFaturamento;
    
    @Column(scale = 2, precision = 10)
    private double pontuacao;
    
    @Column(name="telefone_fixo")
    private String telefoneFixo;
    
    private String celular;
    
    @Column(name="email_contato")
    private String email;
    
    @Column(name="email_envio_xml")
    private String emailXml;
    
    private boolean excluido;
    
    
    
}
