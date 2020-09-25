package view;

import java.util.concurrent.Semaphore;

import conrtoller.ThreadProcessamento;

public class Principal {
	public static void main(String[] args) {
		
		int permissao = 1;

		Semaphore semaforo = new Semaphore(permissao);

		for (int idThread = 0; idThread < 22; idThread++) {
			Thread thread = new ThreadProcessamento  (idThread, semaforo);
			thread.start();
		}
	}
}
