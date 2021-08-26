/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoLancamento;

import br.com.awasis.manangerbackend.model.TipoLancamento;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TipoLancamentoService {

    public Optional findById(long id);
    public List findAll();
    public List find(TipoLancamento cp);
    public TipoLancamento save(TipoLancamento cp);
    public Optional<TipoLancamento> update(TipoLancamento cp, long id);
    public boolean delete(long id);   
     
}
