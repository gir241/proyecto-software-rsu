/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

/**
 *
 * @author joel
 */
public class validaRut {
     public String digitoVerificador(int rut){
    int Digito;
            int Contador;
            int Multiplo;
            int Acumulador;
            String RutDigito;

            Contador = 2;
            Acumulador = 0;

            while (rut != 0)
            {
                Multiplo = (rut % 10) * Contador;
                Acumulador = Acumulador + Multiplo;
                rut = rut / 10;
                Contador = Contador + 1;
                if (Contador == 8)
                {
                    Contador = 2;
                }

            }

            Digito = 11 - (Acumulador % 11);
            RutDigito = Integer.toString(Digito).trim();
            //RutDigito = Digito.ToString.Trim();
            
            if (Digito == 10)
            {
                RutDigito = "K";
            }
            if (Digito == 11)
            {
                RutDigito = "0";
            }
            return (RutDigito);
    }
}
