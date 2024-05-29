public interface IConta {
  // não precisa de 'public'
  // inteface delega um contrato
  // só tem metodos abstratos
  void sacar(double valor);

  void depositar(double valor);

  void transferir(double valor, IConta contaDestino);

  void imprimirExtrato();
}
