package def;

import java.util.ArrayList;

public class Geracao {
	private int gera_qtd;
	private ArrayList<Populacao> geracao;

	public Geracao() {

		geracao = new ArrayList<Populacao>();
		gera_qtd = 1000;
	}

	public void start_1() {//Para a primeira equação
		for (int i = 0; i < gera_qtd; i++) {
			//System.out.println((float)i/gera_qtd);
			if (i == 0) {//Verifica se deve criar a primeira geração
				Populacao a = new Populacao();//Instancia objeto do tipo população
				a.set_primeira_pop_1();//inicia população
				geracao.add(a);//adiciona a lista de gerações

			} else {
				Populacao a = new Populacao();//Instancia objeto do tipo população
				//gera população da nova geração
				a.newPop_1(geracao.get(geracao.size() - 1).getPop());//gera população da nova geração
				geracao.add(a);//adiciona a lista de gerações

				
			}

		}
		geracao.get(geracao.size()-1).best_1();//Mostra o melhor individuo da ultima geração
	}

	public void start_2() {//Operações semelhantes as para a equação 1 mas para a 2
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
