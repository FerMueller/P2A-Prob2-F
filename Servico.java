/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

import java.util.Observer;

/**
 *
 * @author asilva37
 */
public abstract class Servico implements Observer{
    String descricao;
    public Servico(String descricao){
        this.descricao = descricao;
    }    
}
