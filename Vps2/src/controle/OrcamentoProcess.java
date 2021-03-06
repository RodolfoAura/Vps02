package controle;

import java.util.ArrayList;

import modelo.Orcamento;

public class OrcamentoProcess {

	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	private static orcamentoDAO pd = new orcamentoDAO();
	
	public static void compararPrecos(String produto) {
		int indexBarato = 0;
		double precoBarato = 9999999;
		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getproduto().equals(produto) && orcamento.getpreco() < precoBarato) {
				indexBarato = orcamentos.indexOf(orcamento);
				precoBarato = orcamento.getpreco();
			}
		}
		
		for (Orcamento orcamento : orcamentos) {
			if (orcamentos.indexOf(orcamento) == indexBarato) {
				orcamento.setMaisBarato(true);
			} else if(orcamento.getproduto() == produto) {
				orcamento.setMaisBarato(false);
			}
		}
		
	}
	
	public static void abrir() {
		orcamentos = pd.ler();
	}
	
	public static void salvar() {
		pd.escrever(orcamentos);
	}

}
