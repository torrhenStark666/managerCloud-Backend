/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grade;

import br.com.awasis.manangerbackend.model.Grade;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface GradeService {

    public Optional findById(long id);
    public List findAll();
    public List find(Grade cp);
    public Grade save(Grade cp);
    public Optional<Grade> update(Grade cp, long id);
    public boolean delete(long id);  
    
}
