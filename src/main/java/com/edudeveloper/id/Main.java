package com.edudeveloper.id;

public class Main {
	public static void main(String[] args) {
		Pedidos pedidos = new Pedidos();
		
		// Injeção de dependencia (pedidos)
		RelatorioService relatorioService = new RelatorioService();
		//relatorioService.setPedidos(pedidos);
	}
}
