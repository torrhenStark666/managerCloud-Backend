/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.banco;

import br.com.awasis.manangerbackend.model.Banco;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author alecsander
 */


public interface BancoService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Banco f);
    public Banco save(Banco f);
    public Optional<Banco> update(Banco b, long id);
    public boolean delete(long id);
    
}
