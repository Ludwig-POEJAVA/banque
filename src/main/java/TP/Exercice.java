package TP;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

import fr.formation.banque.Compte;
import fr.formation.banque.Depot;
import fr.formation.banque.ExceptionValeurIndefinie;
import fr.formation.banque.ICalculeTaux;
import fr.formation.banque.IOperation;
import fr.formation.banque.Operation;
import fr.formation.banque.Portefeuille;
import fr.formation.banque.Prelevement;
import fr.formation.banque.TypeOperation;
import fr.formation.banque.Virement;

public class Exercice
{
	// static ArrayList<Portefeuille> portefeuilles = new ArrayList<Portefeuille>();
	static Hashtable<String, Portefeuille> portefeuilles = new Hashtable<String, Portefeuille>();
	static Hashtable<String, Compte> comptes = new Hashtable<String, Compte>();
	// static ArrayList<Operation> operations = new ArrayList<Operation>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String... args) throws Exception
	{

		boolean fini = false;

		while (!fini)
		{
			fini = menuMain(fini);
		}
		scan.close();
	}

	private static boolean menuMain(boolean fini)
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
				menuAfficher();
				break;
			case 2:
				menuCreer();
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

	private static void menuCreer()
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
					creerCompte();
					break;
				case 3:
					creerPortefeuille();
					break;
				case 4:
					fini_creer = true;
					break;
				default:
					break;
			}
		}
	}

	private static void creerCompte()
	{
		String numero;
		String libelle;
		Date dateOuverture;
		Date dateFermeture;

		boolean flag = false;
		do
		{
			System.out.print("> NUMERO DE COMPTE ?");
			if (flag)
			{
				System.out.println("<UNIQUE>");
			}
			else
			{
				System.out.println();
			}
			numero = scan.next();
			flag = true;
		}
		while (comptes.containsKey(numero));

		System.out.println("> LIBELLE DE COMPTE ?");
		libelle = scan.next();
		comptes.put(numero, new Compte(numero, libelle));
	}

	private static void creerPortefeuille()
	{
		String libelle;
		String nomBanque;

		boolean flag = false;
		do
		{
			System.out.print("> LIBELLE DE PORTEFEUILLE ?");
			if (flag)
			{
				System.out.println("<UNIQUE>");
			}
			else
			{
				System.out.println();
			}
			libelle = scan.next();
			flag = true;
		}
		while (portefeuilles.containsKey(libelle));

		System.out.println("> NOM DE BANQUE DE PORTEFEUILLE ?");
		nomBanque = scan.next();

		portefeuilles.put(libelle, new Portefeuille(libelle, nomBanque));
	}

	private static void menuAfficher()
	{
		System.out.println("AFFICHAGE DES INFOS");
		System.out.println(" 1 - Afficher portefeuille(s)");
		System.out.println(" 2 - Créer des choses");
		System.out.println(" 3 - Sauvegarder");
		System.out.println(" 4 - Quitter");

	}
}
