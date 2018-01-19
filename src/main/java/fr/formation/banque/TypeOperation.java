package fr.formation.banque;

public enum TypeOperation
{
	CB("CB"), CHEQUE("Chèque"), ESPECE("Espèce"), VIREMENT("Virement"), PRELEVEMENT("Prélèvement");
	private String libelle = "";

	TypeOperation(String libelle)
	{
		this.libelle = libelle;
	}

	public String toString()
	{
		return libelle;
	}

	public static TypeOperation getValue(String value) throws NullPointerException, ExceptionValeurIndefinie
	{
		if (value == null)
		{
			throw new NullPointerException("'value' est null!");
		}
		for (TypeOperation v : TypeOperation.values())
		{
			if (value.equals(v.toString()))
			{
				return v;
			}
		}
		throw new ExceptionValeurIndefinie("<Valeur " + value + " indéfinie>");
	}

	public static void main(String args[]) throws Exception
	{
		System.out.println("___statique___");
		System.out.println("\t" + TypeOperation.CB.toString());
		System.out.println("\t" + TypeOperation.ESPECE.toString());
		System.out.println("\t" + TypeOperation.valueOf("CHEQUE"));
		System.out.println("___TypeOperation.values___");
		System.out.println("\t" + TypeOperation.values());
		System.out.println("___test getValue()___");
		System.out.println("\t" + getValue("chocapic"));
		System.out.println("\t" + getValue("Chèque__"));
	}
}
