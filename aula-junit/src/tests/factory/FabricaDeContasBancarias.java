package tests.factory;

import entities.ContaBancaria;

public class FabricaDeContasBancarias {
	
	public static ContaBancaria criaContaZerada() {
		return new ContaBancaria(1L, 0.0);
	}
	
	public static ContaBancaria criaConta(double valorInicial) {
		return new ContaBancaria(1L, valorInicial);
	}

}
