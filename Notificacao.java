/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author asilva37
 */
public class Notificacao extends Servico{
    ArrayList<TiposNotificacao> tiposNotificacao = new ArrayList<TiposNotificacao>();

    public Notificacao(String descricao) {
        super(descricao);
    }
    
    public void addTipoNotificacao(TiposNotificacao tipo){
        tiposNotificacao.add(tipo);                
    }
    
    @Override
    public void update(Observable o, Object arg) {
        ContaCorrente conta  = (ContaCorrente)o;
        for (TiposNotificacao notificacao : tiposNotificacao) {
            System.out.println(" Cliente "+conta.getCliente().getNome() + 
                    ", "+ " Conta " + conta.getNumero() + 
                    ", "+ "Operação " + conta.getUltimaOperacao() + 
                    ", "+ this.descricao +
                    " de "+notificacao.descricao);
        }        
    }
}
