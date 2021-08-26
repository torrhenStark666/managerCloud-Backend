/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.configuracao.certificado;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SingletonCertificado{

    /**
     *
     * @param senha
     * @return Certificado
     * @throws CertificadoException
     * @throws FileNotFoundException
     */
    
    private volatile static Certificado certificado;

    public static Certificado getCertificadoA1(String senha) throws CertificadoException, FileNotFoundException{
        
        if(certificado == null){
            synchronized (Certificado.class){
                if(certificado == null){
                    certificado = CertificadoService.certificadoPfx(
                                    (System.getProperty("user.dir")+"/certificado/teste.pfx"), "666666666");
                }               
            }      
        }
        
        return certificado;
    }
    
}
