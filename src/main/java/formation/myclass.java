package formation;

import java.util.ArrayList;

import fr.formation.banque.Enregistrement;
import fr.formation.banque.Operation;
import fr.formation.banque.Prelevement;
import fr.formation.banque.TypeOperation;
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
			System.out.println("Object.typeOperation = " + TypeOperation.getValue(op.getTypeOperation()) + " [" + op.getTypeOperation() + "]");
			System.out.println("objet.toString = " + op.toString());
			System.out.println("");
			op = null;
		}

		System.gc();
		/*
		 * System.out.println("");
		 * System.out.println("");
		 * System.out.println("depuis les TypeOperation.***");
		 * System.out.println("");
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(
		 * TypeOperation.TYPE_CB)));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(
		 * TypeOperation.TYPE_CHEQUE)));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(
		 * TypeOperation.TYPE_ESPECE)));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(
		 * TypeOperation.TYPE_VIREMENT)));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(
		 * TypeOperation.TYPE_PRELEVEMENT)));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(-665)));
		 * System.out.println("");
		 * System.out.println("");
		 * System.out.println("depuis les \"chaines\"");
		 * System.out.println("");
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue("CB")));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue("Chèque")));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue("Espèce")));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue("Virement"))
		 * );
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(
		 * "Prélèvement")));
		 * System.out.println(TypeOperation.getValue(TypeOperation.getValue(
		 * "chocolatine")));/
		 **/

	}
}
