package def;

public class Start {
	public Start() {
		//Roda o AG 30 vezes para cada equação
		for (int i = 0; i < 30; i++) {
			Geracao gera = new Geracao();
			gera.start_1();
			gera.start_2();
			System.out.println("---------------------------");
		}
		
		
		
	}

}
