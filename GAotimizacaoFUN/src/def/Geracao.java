package def;

import java.util.ArrayList;

public class Geracao {
	private int gera_qtd;
	private ArrayList<Populacao> geracao;

	public Geracao() {

		geracao = new ArrayList<Populacao>();
		gera_qtd = 1000;
	}

	public void start_1() {//Para a primeira equa��o
		for (int i = 0; i < gera_qtd; i++) {
			//System.out.println((float)i/gera_qtd);
			if (i == 0) {//Verifica se deve criar a primeira gera��o
				Populacao a = new Populacao();//Instancia objeto do tipo popula��o
				a.set_primeira_pop_1();//inicia popula��o
				geracao.add(a);//adiciona a lista de gera��es

			} else {
				Populacao a = new Populacao();//Instancia objeto do tipo popula��o
				//gera popula��o da nova gera��o
				a.newPop_1(geracao.get(geracao.size() - 1).getPop());//gera popula��o da nova gera��o
				geracao.add(a);//adiciona a lista de gera��es

				
			}

		}
		geracao.get(geracao.size()-1).best_1();//Mostra o melhor individuo da ultima gera��o
	}

	public void start_2() {//Opera��es semelhantes as para a equa��o 1 mas para a 2
		for (int i = 0; i < gera_qtd; i++) {

			if (i == 0) {
				Populacao a = new Populacao();
				a.set_primeira_pop_2();
				geracao.add(a);

			} else {
				Populacao a = new Populacao();
				a.newPop_2(geracao.get(geracao.size() - 1).getPop());
				geracao.add(a);
			}

		}
		geracao.get(geracao.size()-1).best_2();
	}
	

}
