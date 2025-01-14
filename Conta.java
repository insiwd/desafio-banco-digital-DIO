
import java.util.UUID;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	private static final String CHAVE_UNICA = gerarChaveUnica();

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected String chaveUnicaCliente;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.chaveUnicaCliente = CHAVE_UNICA;
		this.cliente = cliente;
	}

	private static String gerarChaveUnica() {
		// usando um UUID que representa um valor de 128 bits
		final String idUnico = UUID.randomUUID().toString().replace("-", "");
		return idUnico;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}


	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Sua chave unica: " + this.chaveUnicaCliente));
	}

}