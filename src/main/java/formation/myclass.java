package formation;

import java.util.ArrayList;

import fr.formation.banque.Depot;
import fr.formation.banque.ExceptionValeurIndefinie;
import fr.formation.banque.ICalculeTaux;
import fr.formation.banque.IOperation;
import fr.formation.banque.Operation;
import fr.formation.banque.Prelevement;
import fr.formation.banque.TypeOperation;
import fr.formation.banque.Virement;

public class myclass
{
	public static void main(String... args) throws Exception
	{
		System.out.println("Gestion de compte");

		ArrayList<Operation> operations = new ArrayList<Operation>();
		// ArrayList<Depot> depots = new ArrayList<Depot>();
		// ArrayList<Virement> virements = new ArrayList<Virement>();
		// ArrayList<Prelevement> prelevements = new ArrayList<Prelevement>();

		operations.add((Operation) new Depot("depot cheque 100 balles", 100.01, TypeOperation.CHEQUE));
		operations.add((Operation) new Depot("paiement kebab 200 boules", -200.02, TypeOperation.ESPECE));
		operations.add((Operation) new Virement("libelle virement +", 123.45));
		operations.add((Operation) new Virement("libelle virement -", -222.22));
		operations.add((Operation) new Prelevement("libelle prelevement+", 333.33));
		operations.add((Operation) new Prelevement("libelle prelevement -", -444.44));

		Operation operationAnonyme = new Operation()
		{
			private double montant;
			private String libelle;
			private double taux;

			@Override
			public TypeOperation getTypeOperation()
			{
				return TypeOperation.CHEQUE;
			}

			@Override
			public double getMontant()
			{
				return montant;
			}

			@Override
			public void setMontant(double montant)
			{
				this.montant = montant;
			}

			@Override
			public void setLigne(String libelle, double montant, double taux)
			{
				this.libelle = libelle;
				this.montant = montant;
				this.taux = taux;
			}

			@Override
			public String toString()
			{
				return "libelle <" + libelle + "> \tmontant : " + montant + " \ttaux  " + taux;
			}

		};
		operationAnonyme.setLigne("anonymous", 1000, 0.2);
		System.out.println(operationAnonyme.toString());

		ICalculeTaux monTaux = new ICalculeTaux()
		{
			public double calcule(IOperation operation, double taux)
			{
				return operation.getMontant() * taux;
			}
		};
		System.out.println("Montant du taux à 20 % :" + monTaux.calcule(operationAnonyme, 0.2));
		System.out.println("Montant du taux à 20 % :" + operationAnonyme.calculeTaux(0.2, monTaux));
		System.out.println("Montant du taux à 20 % :"
				+ operationAnonyme.calculeTaux(0.2, (op, t) -> op.getMontant() * t));
		System.out.println("");

		for (Operation op : operations)
		{
			/*
			 * System.out.println("Objet.libelle => " + op.getLibelle());
			 * System.out.println("Objet.getMontant => " + op.getMontant());
			 * System.out.println("Object.TTC => " + op.calculerMontantTTC(0.25));// 25% VAT
			 * System.out.println("Object.typeOperation => " +
			 * TypeOperation.getValue(op.getTypeOperation().toString())
			 * + " [" + op.getTypeOperation() + " " + op.getTypeOperation() + "]");
			 * System.out.println("objet.toString => " + op.toString());
			 */
			op.setLigne(op.getLibelle(), op.getMontant(), 0.20);
			System.out.println(op.toString());
		}

		// creation d'un java.lang.NullPointerException
		System.out.println("\n\n*************************************************************************************\nGESTION D'ERREURS");
		System.out.println("*************************************************************************************\n");

		// creation d'un java.lang.ArithmeticException
		try
		{
			// chaque ligne lève une Exception, commentez celle en amont de l'Exception à
			// tester
			// System.out.println(TypeOperation.getValue(null).toString());
			// int j = 1500 / (1 - 1);
			System.out.println(TypeOperation.getValue("t").toString());
		}
		catch (NullPointerException | ExceptionValeurIndefinie e)
		{
			System.out.println("ERREUR un objet est null");
			System.out.println(e);
			// throw e;

		}
		catch (ArithmeticException e)
		{
			System.out.println("ERREUR division par 0");
			System.out.println(e);
		}
		/*
		 * catch (ExceptionValeurIndefinie e)
		 * {
		 * System.out.
		 * println("ERREUR spécifique de la classe TypeOperation sur la methode getValue()"
		 * );
		 * System.out.println(e);
		 * // throw e;
		 * }
		 */
		catch (Exception e)
		{
			System.out.println("ERREUR sans plus de commentaires");
			// System.out.println(e.getStackTrace());
			// e.printStackTrace();
		}
		finally
		{
			System.out.println("enfin....");
		}

		// creation d'un java.lang.NullPointerException
		System.out.println("\n\n*************************************************************************************\nFIN GESTION D'ERREURS");
		System.out.println("*************************************************************************************\n");

		System.gc();
	}
}
