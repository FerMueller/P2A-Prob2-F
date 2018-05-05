package problema2;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class ContaCorrente extends Observable{
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo = 0;
    private String ultimaOperacao;

    public String getUltimaOperacao() {
        return ultimaOperacao;
    }

    public void setUltimaOperacao(String ultimaOperacao) {
        this.ultimaOperacao = ultimaOperacao;
    }
    private List<Operacao> operacoes = new ArrayList();
    private List<Servico> servicos = new ArrayList();
    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);
    }
       
    private void startMovimentacao(){        
        setChanged();
        notifyObservers();
    }        
    public void addServico(Servico servico){
        servicos.add(servico);
    }

    public String getChave(){
        return String.valueOf(agencia)+"-"+String.valueOf(numero);
    }
    
    public void sacar(double valor){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this);
        operacoes.add(oper);
        this.saldo -= valor;
        
        startMovimentacao();
        
    }
    
    public void depositar(double valor){
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this);
        operacoes.add(oper);
        this.saldo += valor;
        
        startMovimentacao();
    }    
    
    public void transferir(double valor, ContaCorrente destino){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }        
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this,destino);
        operacoes.add(oper);
        this.saldo -= valor;
        startMovimentacao();
    }   
    
    private void receberTransferencia(double valor, ContaCorrente origem){    
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this,origem);
        operacoes.add(oper);
        this.saldo += valor;
        
        startMovimentacao();
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String toString(){
        return this.getChave();
    }
}
