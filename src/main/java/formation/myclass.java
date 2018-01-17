package formation;

import fr.formation.banque.Operation;

public class myclass
{
	public static void main(String... args)
	{
		System.out.println("Gestion de compte");
		Operation op = new Operation("lires", 200000);
		System.out.println("Objet.libelle : " + op.getLibelle());
		System.out.println("Objet.montant : " + op.getMontant());

		op = null;
		System.gc();
	}
}
