package formation;

import java.util.ArrayList;

import fr.formation.banque.Enregistrement;
import fr.formation.banque.IOperation;
import fr.formation.banque.Operation;
import fr.formation.banque.Prelevement;
import fr.formation.banque.Virement;

public class myclass
{
	public static void main(String... args)
	{
		System.out.println("Gestion de compte");

		ArrayList<Operation> operations = new ArrayList<Operation>();

		operations.add(new Enregistrement("enreg", 12.34));
		operations.add(new Enregistrement("enreg", -56.78));
		operations.add(new Virement("vire", 111.11));
		operations.add(new Virement("vire", -222.22));
		operations.add(new Prelevement("preleve", 333.33));
		operations.add(new Prelevement("preleve", -444.44));

		System.out.println("");

		for (Operation op : operations)
		{
			System.out.println("Objet.libelle : " + op.getLibelle());
			System.out.println("Objet.getMontant : " + op.getMontant());
			System.out.println("Object.TTC = " + op.calculerMontantTTC(0.206));
			System.out.println("objet.toString = " + op.toString());
			System.out.println("");
			op = null;
		}

		System.gc();
	}
}
