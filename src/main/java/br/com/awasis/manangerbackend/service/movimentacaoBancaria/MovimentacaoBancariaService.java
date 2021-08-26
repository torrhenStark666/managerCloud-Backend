/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.movimentacaoBancaria;

import br.com.awasis.manangerbackend.model.MovimentacaoBancaria;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alecsander-PC
 */
public interface MovimentacaoBancariaService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(MovimentacaoBancaria cp);
    public MovimentacaoBancaria save(MovimentacaoBancaria cp);
    public Optional<MovimentacaoBancaria> update(MovimentacaoBancaria cp, long id);
    public boolean delete(long id); 
    
}
