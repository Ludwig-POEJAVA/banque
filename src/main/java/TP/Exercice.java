package TP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

import fr.formation.banque.*;

public class Exercice
{
	static Hashtable<String, Portefeuille> portefeuilles = new Hashtable<String, Portefeuille>();
	static Hashtable<String, Compte> comptes = new Hashtable<String, Compte>();
	static ArrayList<Operation> operations = new ArrayList<Operation>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String... args) throws Exception
	{

		boolean fini = false;

		preremplir();

		while (!fini)
		{
			fini = menuMain(fini);
		}
		System.out.println("FIN");
		System.out.println(String.join("", Collections.nCopies(80, "=")));
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

	private static void menuAfficher()
	{
		// TODO
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
					creerOperation();
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

	private static void creerOperation()
	{
		// TODO : uniquement Virement pour le moment
		creerVirement();
	}

	private static void creerVirement()
	{
		String libelle;
		double montant;

		System.out.println("> LIBELLE DE L'OPERATION ?");
		libelle = scan.next();
		System.out.println("> MONTANT DE L'OPERATION ?");
		montant = scan.nextDouble();

		Operation operation = new Virement(libelle, montant);
	}

	private static void creerCompte()
	{
		String numero;
		String libelle;
		String dateOuverture;
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

		Compte compte = new Compte(numero, libelle);

		flag = false;
		do
		{
			System.out.print("> DATE D'OUVERTURE DE COMPTE ?");
			if (flag)
			{
				System.out.println("<dd/MM/yyyy>");
			}
			else
			{
				System.out.println();
			}
			dateOuverture = scan.next();
			flag = true;
		}
		while (!isDateFormattedCorrectly(dateOuverture));
		try
		{
			compte.setDateOuverture((Date) (new SimpleDateFormat("dd/MM/yyyy")).parse(dateOuverture));
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		comptes.put(compte.getNumero(), compte);
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

	private static boolean isDateFormattedCorrectly(String dateSaisie)
	{
		try
		{
			Date dateLue = (new SimpleDateFormat("dd/MM/yyyy")).parse(dateSaisie);
			System.out.println(dateLue.toString());
			return true;
		}
		catch (ParseException e)
		{
			// e.printStackTrace();
		}
		return false;
	}

	private static void preremplir()
	{
		String str_p = "Portefeuille par défaut";
		Portefeuille p = new Portefeuille(str_p, "Banque JAVA");
		portefeuilles.put(str_p, p);

		String str_c = "Compte par défaut";
		Compte c = new Compte(str_c, "Livret jAvA");
		comptes.put(str_c, c);

		Operation o1 = new Virement("virement au pif", 1337.42);
		Operation o2 = new Prelevement("prelevement au pif", 100.01);
		Operation o3 = new Enregistrement("resto chèque -89.99", -89.99, TypeOperation.CHEQUE);
		Operation o4 = new Enregistrement("la paye chèque +2345.67", +2345.67, TypeOperation.CHEQUE);
		Operation o5 = new Enregistrement("CB quelconque", -20.0, TypeOperation.CB);
		Operation o6 = new Enregistrement("pourquoi gère-t'on les éspèces ? ce son généralement des rebuts de retraits par CB", 500.0, TypeOperation.ESPECE);

		operations.add(o1);
		operations.add(o2);
		operations.add(o3);
		operations.add(o4);
		operations.add(o5);
		operations.add(o6);

	}
}
