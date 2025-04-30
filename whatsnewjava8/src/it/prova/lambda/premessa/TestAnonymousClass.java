package it.prova.lambda.premessa;

public class TestAnonymousClass {

	public static void main(String[] args) {
		String numero = "5";
		
		Convertibile convertibileInstance = null;
		
		
		
		
		
		
		int risultato = ClasseCheUsaQualunque.metodoCheUsaQualunque(numero, convertibileInstance);
		
		System.out.println("Risultato....."+risultato);

	}

}
/*
convertibileInstance = new Convertibile() {
@Override
public boolean metodoCheMiDiceSePossoConvertire(String input) {
	try {
		Integer.parseInt(input);
	}catch (NumberFormatException e) {
		return false;
	}
	return true;
}
};
*/