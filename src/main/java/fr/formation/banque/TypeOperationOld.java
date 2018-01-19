package fr.formation.banque;

public class TypeOperationOld
{
	public static final int TYPE_CB = 0;
	public static final int TYPE_CHEQUE = 1;
	public static final int TYPE_ESPECE = 2;
	public static final int TYPE_VIREMENT = 3;
	public static final int TYPE_PRELEVEMENT = 4;

	public static String getValue(int value)
	{
		switch (value)
		{
			case TYPE_CB:
				return "CB__pre";
			case TYPE_CHEQUE:
				return "Chèque__pre";
			case TYPE_ESPECE:
				return "Espèce__pre";
			case TYPE_VIREMENT:
				return "Virement__pre";
			case TYPE_PRELEVEMENT:
				return "Prélèvement__pre";
		}
		return "#ERR";
	}

	public static int getValue(String msg)
	{
		switch (msg)
		{
			case "CB__pre":
				return TYPE_CB;
			case "Chèque__pre":
				return TYPE_CHEQUE;
			case "Espèce__pre":
				return TYPE_ESPECE;
			case "Virement__pre":
				return TYPE_VIREMENT;
			case "Prélèvement__pre":
				return TYPE_PRELEVEMENT;
			default:
				return -1;
		}
	}
}
