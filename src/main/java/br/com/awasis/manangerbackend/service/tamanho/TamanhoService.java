/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tamanho;

import br.com.awasis.manangerbackend.model.Tamanho;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TamanhoService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Tamanho cp);
    public Tamanho save(Tamanho cp);
    public Optional<Tamanho> update(Tamanho cp, long id);
    public boolean delete(long id);       
    
}
