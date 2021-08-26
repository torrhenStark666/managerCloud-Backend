/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.produto;

import br.com.awasis.manangerbackend.model.Produto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface ProdutoService {
    public Optional findById(long id);
    public List findAll();
    public List find(Produto cp);
    public Produto save(Produto cp);
    public Optional<Produto> update(Produto cp, long id);
    public boolean delete(long id);
}
