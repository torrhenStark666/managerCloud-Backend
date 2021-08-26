/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.compensacao;

import br.com.awasis.manangerbackend.model.Compensacao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alecsander-PC
 */
public interface CompensacaoService {
    
    
    public Optional<Compensacao> findById(long id);
    public List findAll();
    public List<Compensacao> find(Compensacao f);
    public Compensacao save(Compensacao f);
    public void delete(long id);
    
    
}
