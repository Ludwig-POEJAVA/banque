package formation;

import fr.formation.banque.Operation;

public class myclass
{
	public static void main(String... args)
	{
		System.out.println("Gestion de compte");
		Operation op1 = new Operation("lires", 200000);
		System.out.println("Objet.libelle : " + op1.getLibelle());
		System.out.println("Objet.montant : " + op1.getMontant());
		System.out.println("Objet.credit : " + op1.getCredit());
		System.out.println("Objet.debit : " + op1.getDebit());

		System.out.println("");

		Operation op2 = new Operation("lires", -123456);
		System.out.println("Objet.libelle : " + op2.getLibelle());
		System.out.println("Objet.montant : " + op2.getMontant());
		System.out.println("Objet.credit : " + op2.getCredit());
		System.out.println("Objet.debit : " + op2.getDebit());

		System.out.println("");
		System.out.println("");

		op1 = null;
		op2 = null;
		System.gc();
	}
}
