/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.liberador;

import br.com.awasis.manangerbackend.model.Liberador;
import br.com.awasis.manangerbackend.repository.LiberadorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class LiberadorServiceImpl implements LiberadorService {

    @Autowired
    private LiberadorRepository repository;    
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(LiberadorSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Liberador cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Liberador save(Liberador cp) {
        return repository.save(cp);
    }

    @Override
    public Optional<Liberador> update(Liberador cp, long id) {
        return repository.findById(id)
                .map( (record) ->{
                    
                    record.setDataFim(cp.getDataFim());
                    record.setDataInicio(cp.getDataInicio());
                    record.setLimiteInicial(cp.getLimiteInicial());
                    record.setLimiteFinal(cp.getLimiteFinal());
                    record.setGrupoProduto(cp.getGrupoProduto());
                    record.setGrupoSolicitante(cp.getGrupoSolicitante());
                    record.setNivel(cp.getNivel());
                    record.setValorDisponivel(cp.getValorDisponivel());
                    record.setAtivo(cp.isAtivo());
                    record.setLogin(cp.getLogin());
                    
                    
                    Liberador updated = repository.save(record);
                    return updated;
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
            repository.deleteById(id);
            return true;
            
        }else{
            return false;
        }
    }
}
