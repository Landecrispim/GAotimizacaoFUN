package def;

import java.util.Random;

public class Populacao {
	private int tamanho_pop;
	private double pop[][];
	double k;
	double taxa_crossover;
	double taxa_mutacao;

	public Populacao() {
		tamanho_pop = 500;// Tamanho da população
		this.pop = new double[tamanho_pop][2];// Instancia vetor para armazenar a população
		k = 0.1;// indicie para controle de pressao seletiva
		taxa_crossover = 0.45;// taxa de crossover
		taxa_mutacao = 0.65;// taxa de mutação
	}

	public void set_primeira_pop_1() {// gera primeira população para a equação 1
		Random aleatorio = new Random();// Variavel que gera valores aleatorios
		for (int i = 0; i < tamanho_pop; i++) {
			for (int j = 0; j < 2; j++) {
				pop[i][j] = (aleatorio.nextDouble() + aleatorio.nextInt()) % 20;// gera numeros aleatorios no intervalo
																				// de -20 a 20

			}
		}
	}

	public void set_primeira_pop_2() {// gera primeira população para a equação 2
		Random aleatorio = new Random();// Variavel que gera valores aleatorios
		for (int i = 0; i < tamanho_pop; i++) {
			for (int j = 0; j < 2; j++) {
				pop[i][j] = (aleatorio.nextDouble() + aleatorio.nextInt()) % 512;// gera numeros aleatorios no intervalo
																					// de 512 a -512
			}
		}
	}

	public void newPop_1(double pop_ant[][]) {// Chama os metodos para gerar a população da nova geração
		torneio_1(pop_ant);
		crossover_1();
		mutacao_1();

	}

	public void newPop_2(double pop_ant[][]) {// Chama os metodos para gerar a população da nova geração
		torneio_2(pop_ant);
		crossover_2();
		mutacao_2();

	}

	public double[][] getPop() {
		return this.pop;
	}

	public void torneio_1(double pop_ant[][]) {// seleção por torneio
		Random rand = new Random();// gera valor aleatorio
		Funtion func = new Funtion();// objeto to tipo função para testes
		double k1;// variavel comparativa para controlhe de pressao seletiva
		int melhor;// armazena melhor resultado atual da equação
		int select_2;// variavel auxiliar
		int select_1;// variavel auxiliar
		for (int i = 0; i < tamanho_pop; i++) {

			k1 = rand.nextInt(100) / 100;// K1 recebe um valor aleatorio entre 0 e 1,
			select_1 = rand.nextInt(tamanho_pop);// seleciona idividuo aleatorio
			select_2 = rand.nextInt(tamanho_pop);// seleciona idividuo aleatorio
			if (func.calcula_1(pop_ant[select_1][0], pop_ant[select_1][1]) < func.calcula_1(pop_ant[select_2][0],
					pop_ant[select_2][1]))// compara os dois individuos
				melhor = 1;
			else
				melhor = 2;
			if (k >= k1) {// Armazena individuo selecionado em função de k
				if (melhor == 1) {
					this.pop[i][0] = pop_ant[select_1][0];
					this.pop[i][1] = pop_ant[select_1][1];
				} else {
					this.pop[i][0] = pop_ant[select_2][0];
					this.pop[i][1] = pop_ant[select_2][1];

				}
			} else {
				if (melhor == 1) {
					this.pop[i][0] = pop_ant[select_2][0];
					this.pop[i][1] = pop_ant[select_2][1];
				} else {
					this.pop[i][0] = pop_ant[select_1][0];
					this.pop[i][1] = pop_ant[select_1][1];

				}

			}

		}

	}

	public void torneio_2(double pop_ant[][]) {// funcionameto semelhante ao metodo acima
		Random rand = new Random();
		Funtion func = new Funtion();
		double k1;
		int melhor;
		int select_2;
		int select_1;
		for (int i = 0; i < tamanho_pop; i++) {

			k1 = rand.nextInt(100) / 100;
			select_1 = rand.nextInt(tamanho_pop);
			select_2 = rand.nextInt(tamanho_pop);
			if (func.calcula_2(pop_ant[select_1][0], pop_ant[select_1][1]) < func.calcula_2(pop_ant[select_2][0],
					pop_ant[select_2][1]))
				melhor = 1;
			else
				melhor = 2;
			if (k <= k1) {
				if (melhor == 1) {
					this.pop[i][0] = pop_ant[select_1][0];
					this.pop[i][1] = pop_ant[select_1][1];
				} else {
					this.pop[i][0] = pop_ant[select_2][0];
					this.pop[i][1] = pop_ant[select_2][1];

				}
			} else {
				if (melhor == 1) {
					this.pop[i][0] = pop_ant[select_2][0];
					this.pop[i][1] = pop_ant[select_2][1];
				} else {
					this.pop[i][0] = pop_ant[select_1][0];
					this.pop[i][1] = pop_ant[select_1][1];

				}

			}

		}

	}

	public void crossover_2() {// crossover
		Random rand = new Random();// variavel para gerar valores aleatorios
		double taxa_crossover_1;// variavel comparativa para controlhe de taxa de crossover
		int select_2;// variavel auxiliar
		int select_1;// variavel auxiliar

		for (int i = 0; i < tamanho_pop; i++) {// corre vetor de individuos
			select_1 = rand.nextInt(tamanho_pop);// seleciona idividuo aleatorio
			select_2 = rand.nextInt(tamanho_pop);// seleciona idividuo aleatorio
			taxa_crossover_1 = (double) rand.nextInt(100) / 100;// taxa_crossover_1 recebe um valor aleatorio entre 0 e
																// 1,
			if (taxa_crossover_1 <= this.taxa_crossover) {// verifica se vai acontecer o crossover
				this.pop[i][0] = select_1;// O individuo i recebe a primeira parte de select_1
				this.pop[i][1] = select_2;// O individuo i recebe a segunda parte de select_2
			}
		}
	}
	
	public void crossover_1() {// crossover
		Random rand = new Random();// variavel para gerar valores aleatorios
		double taxa_crossover_1;// variavel comparativa para controlhe de taxa de crossover
		int select_2;// variavel auxiliar
		int select_1;// variavel auxiliar

		for (int i = 0; i < tamanho_pop; i++) {// corre vetor de individuos
			select_1 = rand.nextInt(tamanho_pop);// seleciona idividuo aleatorio
			select_2 = rand.nextInt(tamanho_pop);// seleciona idividuo aleatorio
			taxa_crossover_1 = (double) rand.nextInt(100) / 100;// taxa_crossover_1 recebe um valor aleatorio entre 0 e
																// 1,
			if (taxa_crossover_1 <= this.taxa_crossover) {// verifica se vai acontecer o crossover
				this.pop[i][0] = select_1*0.5 + select_2*0.5;// O individuo i recebe a primeira parte de select_1 e segunda de select_2
			}
		}
	}

	public void mutacao_1() {// mutação
		Random rand = new Random();// variavel para gerar valores aleatorios
		double taxa_mutacao_1;// variavel comparativa para controlhe de taxa de mutação
		for (int i = 0; i < tamanho_pop; i++) {// corre vetor de individuos
			taxa_mutacao_1 = (double) rand.nextInt(100) / 100;// taxa_mutacao_1 recebe um valor aleatorio entre 0 e 1,
			if (taxa_mutacao > taxa_mutacao_1) {// verifica se vai acontecer o mutação
				
					pop[i][0] = (rand.nextDouble() + rand.nextInt()) % 20;// individuo recebe valores aleatorios
				

			}
		}

	}

	public void mutacao_2() {// funcionameto semelhante ao metodo acima
		Random rand = new Random();
		double taxa_mutacao_1;
		for (int i = 0; i < tamanho_pop; i++) {
			taxa_mutacao_1 = (double) rand.nextInt(100) / 100;
			if (taxa_mutacao > taxa_mutacao_1) {
				if (rand.nextBoolean())
					pop[i][0] = (rand.nextDouble() + rand.nextInt()) % 512;
				else
					pop[i][1] = (rand.nextDouble() + rand.nextInt()) % 512;

			}
		}

	}

	public void best_1() {// encontra melhor valor da geração
		Funtion func = new Funtion();
		double melhor = 0;
		int melhor_i = 0;
		for (int i = 0; i < tamanho_pop; i++) {

			if (func.calcula_1(pop[i][0], pop[i][1]) < melhor) {
				melhor = func.calcula_1(pop[i][0], pop[i][1]);
				melhor_i = i;
			}
		}
		System.out.println();
		System.out.println(pop[melhor_i][0]);
		
		//System.out.println(pop[melhor_i][1]);
		System.out.println(func.calcula_1(pop[melhor_i][0], pop[melhor_i][1]));
	}

	public void best_2() {// encontra melhor valor da geração
		Funtion func = new Funtion();
		double melhor = 0;
		int melhor_i = 0;
		for (int i = 0; i < tamanho_pop; i++) {

			if (func.calcula_2(pop[i][0], pop[i][1]) < melhor) {
				melhor = func.calcula_2(pop[i][0], pop[i][1]);
				melhor_i = i;
			}
		}
		System.out.println();
		System.out.print(pop[melhor_i][0]);
		System.out.print("			");
		System.out.println(pop[melhor_i][1]);
		System.out.println(func.calcula_2(pop[melhor_i][0], pop[melhor_i][1]));
	}

}