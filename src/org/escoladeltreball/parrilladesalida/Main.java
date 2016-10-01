package org.escoladeltreball.parrilladesalida;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

class Cas implements Comparable<Cas> {
	int pos;
	String name;

	public Cas(int pos, String name) {
		super();
		this.pos = pos;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Cas [pos=%s, name=%s]", pos, name);
	}

	@Override
	public int compareTo(Cas cas) {
		return pos - cas.pos;
	}

}

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static final int MAX_PILOTS = 26;

	public static void main(String[] args) {

		Cas[] casDeProva = null;

		while (true) {
			int n = scanner.nextInt();
			if (n == 0) {
				System.exit(-1);
			}
			//out.printf("%d%n", n);
			casDeProva = new Cas[n];
			for (int i = 0; i < n; i++) {
				casDeProva[i] = new Cas(scanner.nextInt(), scanner.nextLine().trim());
				// out.printf("%s%n", mostra[i]);
			}
			solve(casDeProva);
		}

	}

	private static void solve(Cas[] casDeProva) {
		List<Cas> parrilla = new ArrayList<>();

		for (int i = 0; i < casDeProva.length; i++) {
			parrilla.add(new Cas(i + 1 + casDeProva[i].pos, casDeProva[i].name));
		}
		Collections.sort(parrilla);
		for (Cas cas : parrilla) {
			if (cas.pos > MAX_PILOTS) {
				out.printf("%s%n", "IMPOSIBLE");
			} else {
				out.printf("%d %s%n", cas.pos, cas.name);
			}
		}
		out.printf("%s%n", "-----");
	}

}
