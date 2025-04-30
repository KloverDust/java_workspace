package it.prova.lambda.premessa;

public class ClasseCheUsaQualunque {
	public static int metodoCheUsaQualunque(String numero, Convertibile convertibile) {
		if (convertibile.metodoCheMiDiceSePossoConvertire(numero))
			return Integer.parseInt(numero);

		return -999;
	}
}
