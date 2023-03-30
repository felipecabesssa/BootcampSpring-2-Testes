package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.ContaBancaria;
import tests.factory.FabricaDeContasBancarias;

public class TestesContaBancaria {
	
	@Test
	public void saldoDeveriaAumentarQuandoDepositarValorPositivo() {
		
		double valorDeposito = 200.0;
		double valorTotalEsperado = 196.0;
		//valorDeposito = valorDeposito - valorDeposito * 0.02;
		
		ContaBancaria conta = new ContaBancaria(1l, 0.0);
		//aqui instanciamos uma conta nova com 0 de saldo (na mão, sem a fabrica)
		// ContaBancaria conta = FabricaDeContasBancarias.criaContaZerada(); - aqui com a fabrica.
		
		conta.depositar(valorDeposito);
		//logo ao depositar 200 na conta (valorDeposito)
		//ela deve ficar com 196.0 após o desconto (valorTotalEsperado)
		
		Assertions.assertEquals(valorTotalEsperado, conta.getSaldo()); ;
	}
	
	@Test
	public void naoAconteceNadaQuandoValorDepositadoNegativo() {
		
		double valorTotalEsperado = 100.0;
		
		// ContaBancaria conta = new ContaBancaria(1l, valorTotalEsperado); - aqui sem fabrica
		ContaBancaria conta = FabricaDeContasBancarias.criaConta(valorTotalEsperado); // - aqui com
		
		double valorDeposito = -200.0;
		
		conta.depositar(valorDeposito);
		
		Assertions.assertEquals(valorTotalEsperado, conta.getSaldo());
		
	}
	
	@Test
	public void metodoSacarTudoDeveriaZerarOSaldoERetornarOSaldoTotalApos() {
		
		double valorEsperado = 0.0;
		double saldoInicial = 800.0;
		ContaBancaria conta = FabricaDeContasBancarias.criaConta(saldoInicial);
		
		double resultado = conta.sacarTudo();
		
		Assertions.assertTrue(valorEsperado == conta.getSaldo());
		Assertions.assertTrue(resultado == saldoInicial);
		//o método pode ter quantos assertions vc quiser (se um for falso o teste todo falha)
		//lembrando que cada cenário é um teste diferente, não pode fazer if else no teste
		
	}
	
	@Test
	public void metodoSacarDeveriaDecrementarOSaldoQuandoSaldoMaiorQueSaque() {
		
		ContaBancaria conta = FabricaDeContasBancarias.criaConta(800.0);
		
		conta.sacar(500.0);
		
		Assertions.assertEquals(300.0, conta.getSaldo());
		
	}
	
	@Test
	public void metodoSacarDeveriaLancarThrowExceptionQuandoSaqueMaiorQueSaldo() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			ContaBancaria conta = FabricaDeContasBancarias.criaConta(800.0);
			
			conta.sacar(805.0);
		});
		
	}

}





















