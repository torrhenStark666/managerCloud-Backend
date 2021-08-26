/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.configuracao.nfe;

import br.com.awasis.manangerbackend.configuracao.certificado.SingletonCertificado;
import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.Proxy;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.nfe.schema_4.consStatServ.TRetConsStatServ;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class JavaNfeConfiguracaoImpl implements JavaNfeConfiguracao {

    private ConfiguracoesNfe    configuracao;
    
    @Override
    public ConfiguracoesNfe getConfiguracao(Certificado certificado) {
       
        if(configuracao == null){
            
            try {
            
             configuracao = ConfiguracoesNfe.criarConfiguracoes(
                    EstadosEnum.PR,
                    AmbienteEnum.HOMOLOGACAO,
                    certificado,
                    (System.getProperty("user.dir")+"/schemas"));
            
            } catch (CertificadoException ex) {

                System.out.println(ex.getMessage());

            }
            
        }
        
        
        return configuracao;
        
    }

    @Override
    public ConfiguracoesNfe getConfiguracao(Certificado certificado, String ip, String porta, String usuario, String senha) {
	
        try {
            
            configuracao = ConfiguracoesNfe.criarConfiguracoes(
                            EstadosEnum.GO ,
                            AmbienteEnum.HOMOLOGACAO,
                            certificado,
                            (System.getProperty("user.dir")+"/schemas"));
            
            configuracao.setProxy(new Proxy(ip, Integer.valueOf(porta), usuario, senha));
            
        } catch (CertificadoException ex) {
            Logger.getLogger(JavaNfeConfiguracaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

	
        
	return configuracao; 
        
    }
    
    //@Bean
    public void testarServico() throws NfeException, CertificadoException, FileNotFoundException{
        
        ConfiguracoesNfe configuracao = getConfiguracao(SingletonCertificado.getCertificadoA1("123456"));
        
        br.com.swconsultoria.nfe.schema_4.retConsStatServ.TRetConsStatServ retorno = Nfe.statusServico(configuracao, DocumentoEnum.NFCE);
        System.out.println("# Status: " + retorno.getCStat() + " - " + retorno.getXMotivo());
    }
    
}
