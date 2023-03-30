package entities;

public class ContaBancaria {
	
	public static double PORCENTAGEM_POR_DEPOSITO = 0.02;
	
	private Long id;
	private Double saldo;
	
	public ContaBancaria() {
	}

	public ContaBancaria(Long id, Double saldo) {
		super();
		this.id = id;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void depositar(double valorDeposito) {
		if (valorDeposito > 0) {
			valorDeposito -= valorDeposito * PORCENTAGEM_POR_DEPOSITO;
			saldo += + valorDeposito;
		}
	}
	
	public void sacar(double valorSaque) {
		if (valorSaque > saldo) {
			throw new IllegalArgumentException();
		}
		saldo -= valorSaque;
	}
	
	public double sacarTudo() {
		double aux = saldo;
		saldo = 0.0;
		return aux;
	}
	
}
