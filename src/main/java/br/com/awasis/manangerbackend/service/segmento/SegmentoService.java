/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.segmento;

import br.com.awasis.manangerbackend.model.Segmento;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface SegmentoService {

    public Optional findById(long id);
    public List findAll();
    public List find(Segmento cp);
    public Segmento save(Segmento cp);
    public Optional<Segmento> update(Segmento cp, long id);
    public boolean delete(long id); 
    
}
