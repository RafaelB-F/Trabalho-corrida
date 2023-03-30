
import java.util.Random;
import java.util.Scanner;

public class Corrida {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		Random rr = new Random();
		Random rrr = new Random();

		System.out.println("Quantos participantes deseja adicionar?");
		int jogadores = sc.nextInt();
		System.out.println("Digite um número de voltas para a corrida");
		int voltas = sc.nextInt();
		System.out.println("Cada volta possui 20Km de comprimento");
		System.out.println();

		if (voltas < 0) {
			while (voltas < 0) {
				System.out.println("Valor inválido, digite um número positivo");
				voltas = sc.nextInt();
			}
		}

		System.out.println("Deseja jogar 1 v 1 local? (S/N)");
		char resposta = sc.next().charAt(0);

		String nome1 = null;
		String nome2 = null;
		boolean condicao = false;
		if (resposta == 's' || resposta == 'S') {
			sc.nextLine();
			System.out.println("Digite um nome para o jogador 1");
			nome1 = sc.nextLine();
			System.out.println("Digite um nome para o jogador 2");
			nome2 = sc.nextLine();
			System.out.println();
			System.out.println("O jogo será iniciado no modo versus");
			condicao = true;
		} else {
			System.out.println();
			System.out.println("O jogo será iniciado no modo solo");
			System.out.println();
		}

		System.out.println("A contagem regressiva está prestes a iniciar...");

		int contagem = 1;
		for (int i = 3; i < 4 && i > -1; i--) {
			System.out.println(i);
			if (i == 0) {
				contagem = 0;
			}
		}

		System.out.println();
		System.out.println("ACELERE!!!");

		double velo = 0;
		double veloJog1 = 0;
		double veloJog2 = 0;

		double distancia = 0;
		double distancia1 = 0;
		double distancia2 = 0;

		if (condicao == true) {

			// enquanto qualquer uma das distâncias forem inferiores à distância do total de
			// voltas
			// o jogo continuará pedindo para alterar a velocidade dos jogadores
			while (distancia1 <= voltas * 20 || distancia2 <= voltas * 20) {

				System.out.println(nome1 + " Quanto deseja adicionar a velocidade de seu corredor em Km?");
				veloJog1 = sc.nextDouble();
				System.out.println(nome2 + " Quanto deseja adicionar a velocidade de seu corredor em Km?");
				veloJog2 = sc.nextDouble();

				veloJog1 = r.nextDouble(veloJog1 + 1);

				System.out.println("--------------------------------------------------------");
				System.out.printf("A velocidade média de %s:  %.2f", nome1, veloJog1);
				System.out.println("Km/h");
				System.out.printf("Distância percorrida: %.2f", (veloJog1 / 3.6 * 120) / 1000);
				System.out.println("Km");
				System.out.println("--------------------------------------------------------");
				System.out.println();

				distancia1 += (veloJog1 / 3.6 * 120) / 1000;

				veloJog2 = r.nextDouble(veloJog2 + 1);

				System.out.println("--------------------------------------------------------");
				System.out.printf("A velocidade média de %s:  %.2f", nome2, veloJog2);
				System.out.println("Km/h");
				System.out.printf("Distância percorrida: %.2f", (veloJog2 / 3.6 * 120) / 1000);
				System.out.println("Km");
				System.out.println("--------------------------------------------------------");

				distancia2 += (veloJog2 / 3.6 * 120) / 1000;
			}

			if (distancia1 > distancia2) {
				System.out.println("o vencedor é: " + nome1);
			} else {
				System.out.println("o vencedor é: " + nome2);
			}

		} else {
			// enquanto a distância total percorrida n passar da distância total de voltas
			// o jogo continuará pedindo informações de velocidade e adicionando isso na
			// variável
			// distância
			while (distancia <= voltas * 20) {
				System.out.println("Quanto deseja adicionar a velocidade de seu corredor?");
				velo = sc.nextDouble();

				velo = r.nextDouble(velo + 1);

				System.out.println("--------------------------------------------------------");
				System.out.printf("Sua velocidade média: %.2f", velo);
				System.out.println("Km/h");
				System.out.printf("Distância percorrida: %.2f", (velo / 3.6 * 120) / 1000);
				System.out.println("Km");
				System.out.println("--------------------------------------------------------");

				distancia += (velo / 3.6 * 120) / 1000;
			}
			if (distancia > voltas * 20) {
				System.out.println("corrida terminada");
			}

			// eu não sabia direito como adicionar outro corredores no modo solo, então eu
			// não tem um vencedor
			// e sim só o término da corrida nesse modo

		}

	}

}
