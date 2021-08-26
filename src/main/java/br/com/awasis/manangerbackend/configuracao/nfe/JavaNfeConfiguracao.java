/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.configuracao.nfe;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;

/**
 *
 * @author alecsander
 */
public interface JavaNfeConfiguracao {
    
    public ConfiguracoesNfe getConfiguracao(Certificado certificado);
    public ConfiguracoesNfe getConfiguracao(Certificado certificado, String ip, String porta, String usuario, String senha);
    
}
