package TP;

import java.util.ArrayList;
import java.util.Scanner;

import fr.formation.banque.Depot;
import fr.formation.banque.ExceptionValeurIndefinie;
import fr.formation.banque.ICalculeTaux;
import fr.formation.banque.IOperation;
import fr.formation.banque.Operation;
import fr.formation.banque.Prelevement;
import fr.formation.banque.TypeOperation;
import fr.formation.banque.Virement;

public class Exercice
{
	public static void main(String... args) throws Exception
	{
		boolean fini = false;
		Scanner scan = new Scanner(System.in);

		while (!fini)
		{
			fini = menuMain(fini, scan);
		}
		scan.close();
	}

	private static boolean menuMain(boolean fini, Scanner scan)
	{
		int prompt;
		System.out.println("GESTION DE COMPTES BANCAIRES");
		System.out.println(" 1 - Afficher informations");
		System.out.println(" 2 - Créer des choses");
		System.out.println(" 3 - Sauvegarder");
		System.out.println(" 4 - Quitter");

		prompt = scan.nextInt();

		switch (prompt)
		{
			case 1:
				menuAfficher(scan);
				break;
			case 2:
				menuCreer(scan);
				break;
			case 3:
				break;
			case 4:
				fini = true;
				break;
			default:
				break;
		}
		return fini;
	}

	private static void menuCreer(Scanner scan)
	{
		int prompt;
		boolean fini_creer = false;
		while (!fini_creer)
		{
			System.out.println("CREER DES CHOSES");
			System.out.println(" 1 - Opération");
			System.out.println(" 2 - Compte");
			System.out.println(" 3 - Portefeuille");
			System.out.println(" 4 - Retour");

			prompt = scan.nextInt();

			switch (prompt)
			{
				case 1:
					// menuAfficher(scan);
					break;
				case 2:
					menuCreer(scan);
					break;
				case 3:
					creerPortefeuille(scan);
					break;
				case 4:
					fini_creer = true;
					break;
				default:
					break;
			}
		}
	}

	private static void creerPortefeuille(Scanner scan)
	{
		// TODO Auto-generated method stub

	}

	private static void menuAfficher(Scanner scan)
	{
		System.out.println("AFFICHAGE DES INFOS");
		System.out.println(" 1 - Afficher portefeuille(s)");
		System.out.println(" 2 - Créer des choses");
		System.out.println(" 3 - Sauvegarder");
		System.out.println(" 4 - Quitter");
	}
}
