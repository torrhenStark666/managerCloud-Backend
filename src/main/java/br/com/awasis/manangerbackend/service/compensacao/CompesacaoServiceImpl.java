/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.compensacao;

import br.com.awasis.manangerbackend.model.Compensacao;
import br.com.awasis.manangerbackend.repository.CompensacaoRepository;
import br.com.awasis.manangerbackend.service.cor.CorSpecification;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alecsander-PC
 */

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CompesacaoServiceImpl implements CompensacaoService{
    
    @Autowired
    private CompensacaoRepository repository;

    @Override
    public Optional<Compensacao> findById(long id) {
        return repository.findOne(CompensacaoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List<Compensacao> find(Compensacao f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compensacao save(Compensacao f) {
        return repository.save(f);
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
