/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.banco;

import br.com.awasis.manangerbackend.model.Banco;
import br.com.awasis.manangerbackend.repository.BancoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BancoServiceImpl implements BancoService {
    
    @Autowired
    private BancoRepository repository;
    
    @Override
    public List findAll() {
        return repository.findAll();    
    }
    
    @Override
    public Optional<Banco> findById(long id) {
        return repository.findOne(BancoSpecification.byIdSpecification(id));
    }
    
    @Override
    public List find(Banco f) {
        
        Specification where = null;
        
        if(!f.getAgencia().isBlank() || !f.getAgencia().isEmpty()){
            where = BancoSpecification.addClausula(where, BancoSpecification.byAgenciaSpecification(f.getAgencia()));
        }
        
        if(!f.getConta().isBlank() || !f.getConta().isEmpty()){
            where = BancoSpecification.addClausula(where, BancoSpecification.byContaSpecification(f.getConta()));
        }
        
        if(!f.getNumeroBanco().isBlank() || !f.getNumeroBanco().isEmpty()){
            where = BancoSpecification.addClausula(where, BancoSpecification.byNumeroBancoSpecification(f.getNumeroBanco()));
        }
        try {
            if(f.getSaldo() >= 0){
                where = BancoSpecification.addClausula(where, BancoSpecification.byValorSpecification(f.getSaldo()));
            }
        } catch (NullPointerException e) {
            return repository.findAll(where);
        }
               
        
        return repository.findAll(where);
    }

    @Override
    public Banco save(Banco f) {
        //regra de negocio
        
        return repository.save(f);
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
             repository.deleteById(id);
             return true;
        }else return false;
    }

    @Override
    public Optional<Banco> update(Banco b, long id) {
        return findById(id)
                .map(record ->{
                        record.setNumeroBanco(b.getNumeroBanco());
                        record.setAgencia(b.getAgencia());
                        record.setConta(b.getConta());
                        record.setSaldo(b.getSaldo());
                        record.setDataInclusao(b.getDataInclusao());
                        return save(record);
                });
    }


}
