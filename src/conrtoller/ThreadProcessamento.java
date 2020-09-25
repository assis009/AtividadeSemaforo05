package conrtoller;

import java.util.concurrent.Semaphore;

public class ThreadProcessamento extends Thread {
	int id = 0;
	private Semaphore semaforo;

	public ThreadProcessamento(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	public void run() {
		calc();
		// ----- secao critica ----
		try {
			semaforo.acquire();
			transacaoBd();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// --- fim secao critica ----
			semaforo.release();
			fimTrascao();
		}

	}

	private void calc() {

		int filtro = id % 3;// fazendo o filtro das threads
		int tempo = 0;
		switch (filtro) {
		case 0:
			tempo = (int) ((Math.random() * 1001) + 1000);// de 1 a 2 segundos
			try {
				sleep(tempo);// colocando a thread para dormir e teoricamente fazendo o calculo
				System.out.println(" Thread #" + id + " esta calculando");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			tempo = (int) ((Math.random() * 1001) + 200);// de 0,2 a 1 segundos
			try {
				
				sleep(tempo);// colocando a thread para dormir e teoricamente fazendo o calculo
				System.out.println(" Thread #" + id + " esta calculando");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			tempo = (int) ((Math.random() * 1001) + 500);// de 0,5 a 1,5
															// segundos
			try {
				
				sleep(tempo);// colocando a thread para dormir e teoricamente fazendo o calculo
				System.out.println(" Thread #" + id + " esta calculando");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}

	}

	private void transacaoBd() {

		int filtro = id % 3;// fazendo o filtro das threads
		int tempo = 0;
		switch (filtro) {
		case 0:
			tempo = 1500;// 1,5 segundos
			try {
				
				sleep(tempo);// colocando a thread para dormir e teoricamente fazer transação
				System.out.println(" Thread #" + id + " esta fazendo a transação para o banco de dados");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			tempo = 1000;// 1 segundos
			try {
				
				sleep(tempo);// colocando a thread para dormir e teoricamente fazer transação
				System.out.println(" Thread #" + id + " esta fazendo a transação para o banco de dados");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			tempo = 1500;// 1,5 segundos
			try {
				
				sleep(tempo);// colocando a thread para dormir e teoricamente fazer transação
				System.out.println(" Thread #" + id + " esta fazendo a transação para o banco de dados");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	private void fimTrascao() {
		System.out.println("A Thread #" + id + " terminou a transação");

	}

}
