package fr.formation.banque;

public class Enregistrement extends Operation
{
	public String modePaiement;

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Enregistrement()
	{
		this.typeOperation = TypeOperation.TYPE_CHEQUE;
	}

	public Enregistrement(double montant)
	{
		super(montant);
		this.typeOperation = TypeOperation.TYPE_CHEQUE;
	}

	public Enregistrement(String libelle, double montant)
	{
		super(libelle, montant);
		this.typeOperation = TypeOperation.TYPE_CHEQUE;
	}

	/******************************************************************************************************************
	 * GETTERS SETTERS
	 *****************************************************************************************************************/
	public double getMontant()
	{
		{
			return (getCredit() - getDebit()) / 100.0;
		}
	}

	public void setMontant(double montant)
	{
		{
			if (montant < 0)
			{
				setDebit((int) Math.floor(-montant * 100));
				setCredit(0);
			}
			else if (montant > 0)
			{
				setCredit((int) Math.floor(montant * 100));
				setDebit(0);
			}
			else
			{
				setCredit(0);
				setDebit(0);
			}
		}

	}
}
