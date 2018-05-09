/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

import java.util.Observable;

/**
 *
 * @author asilva37
 */
public class BaixaInvestimento extends Servico{

    public BaixaInvestimento(String descricao) {
        super(descricao);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        ContaCorrente conta  = (ContaCorrente)o;
        System.out.println(" Cliente "+conta.getCliente().getNome() + 
                    ", "+ " Conta " + conta.getNumero() + 
                    ", "+ "Operação " + conta.getUltimaOperacao() + 
                    ", "+ this.descricao);
    }
    
}
