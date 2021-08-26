
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="tb_representante")
@SQLDelete(sql = "update tb_representante set excluido = true where id_representante = ?")
@Where(clause = "excluido = false")
public class Representante {

    @ManyToMany(mappedBy = "representantes")
    @JsonIgnore
    private List<TabelaPreco> tabelaPrecos;
    
    @OneToMany(mappedBy = "representante")
    @JsonIgnore
    private List<PedidoVenda> pedidoVendas;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_representante")
    private long idRepresentante;
    
    
    @ManyToMany
    @JoinTable(name = "tb_representante_contato", 
            joinColumns = {
                @JoinColumn(name = "id_representante",
                            referencedColumnName = "id_representante")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_contato",
                            referencedColumnName = "id_contato")}
    )
    private List<Contato> contatos;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_endereco")
    private Endereco endereco;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_imagem")
    private Imagem imagem;
    
    @ManyToMany
    @JoinTable(name = "tb_representante", 
            joinColumns = {
                @JoinColumn(name = "id_representante",
                            referencedColumnName = "id_representante")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_meta",
                            referencedColumnName = "id_meta")}
            )
    @JsonIgnore
    private List<Meta> metas;
    
    @Column(name="id_centro_custo")
    private long idCentroCusto;
    
    @Column(name="id_conta_contabil")
    private long idContaContabil;
    
    @ManyToOne
    @JoinColumn(name="id_setor")
    private Setor setor;
    
    @Column(name="razao_social")
    private String razaoSocial;
    
    @Column(name="nome_fantasia")
    private String nomeFantasia;
    
    @Column(name="tipo_contribuinte")
    private String tipoContribuiente;
    
    
    private String cnpj;
    
    private String cpf;
    
    @Column(name="inscricao_estadual")
    private String inscricaoEstadual;
    
    @Column(name="percentual_comissao", scale = 2, precision = 10)
    private double percentualComissao;
    
    @Column(name="telefone_fixo")
    private String telefoneFixo;
    
    private String celular;
    
    @Column(name="email_contato")
    private String email;
    
    @Column(name="email_envio_xml")
    private String emailXml;
    
    private Boolean ativo;
    
    private boolean excluido;
    
    
}
