package fr.formation.banque;

import java.util.Date;

public interface IOperation
{

	/******************************************************************************************************************
	 * GETTERS SETTERS
	 *****************************************************************************************************************/
	double getMontant();

	void setMontant(double montant);

	/******************************************************************************************************************
	 * GETTERS SETTERS std
	 *****************************************************************************************************************/
	Date getDateOperation();

	void setDateOperation(Date dateOperation);

	Date getDateValeur();

	void setDateValeur(Date dateValeur);

	String getLibelle();

	void setLibelle(String libelle);

	public default double calculerMontantTTC(double taux)
	{
		return ((getCredit() - getDebit()) * (1 + taux)) / 100.0;
	}

	int getCredit();

	void setCredit(int credit);

	int getDebit();

	void setDebit(int debit);

	TypeOperation getTypeOperation();

	public double calculeTaux(double taux, ICalculeTaux calculTaux);
}
