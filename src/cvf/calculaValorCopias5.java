
package cvf;

import javax.swing.*;

public class calculaValorCopias5 
{
    static int tipoDeFotocopia; 
    static Object[] enunciadosBotones = {"Sencilla","Doble"};
    
    public static void main(String args[])
    {
          do { //repetir el proceso varias veces

            int numPaginaInicial, numPaginaFinal, cantidadDePagAFotocopiar;
            double precioPorUnaFotocopia,valorTotalQuePagaElCliente;
            
            numPaginaInicial = getEntero("Digite el numero de \nla Pagina Inicial: ");
            numPaginaFinal = getEntero("Digite el numero de \nla Pagina Final: ");
            precioPorUnaFotocopia = getReal("Digite el valor de una \npagina de Fotocopia: ");
            
            if (numPaginaInicial == numPaginaFinal)
            {
               cantidadDePagAFotocopiar = 1;  //para que de uno ya que es la misma pagina y no hay mas...
            }
            else
            {
                cantidadDePagAFotocopiar =(1 + cantidadDePaginas(numPaginaInicial, numPaginaFinal)); 
                /* le sumo 1 porque la pagina inicial tambien cuenta... es decie si necesitamos sacarle copia a 
                 * las paginas desde la 2 hasta la 5 necesitaremos entonces  sacar 5-2 = 3 mas la misma 2 que 
                 * tambien cuenta entonces seran "4"...
                 */
            }
            
            valorTotalQuePagaElCliente  = valorDePagoTotal(cantidadDePagAFotocopiar, precioPorUnaFotocopia);
            
            tipoDeFotocopia = JOptionPane.showOptionDialog(null, "Que tipo de Fotocopia desea?", "Tipo de Fotocopia",
                                                                                                        JOptionPane.YES_NO_OPTION,
                                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                                        null,     /*do not use a custom Icon*/
                                                                                                        enunciadosBotones,  /*the titles of buttons*/
                                                                                                        enunciadosBotones[0]); /*default button title*/
            
            if(tipoDeFotocopia == 1)
            {
                valorTotalQuePagaElCliente = valorTotalQuePagaElCliente / 2.0;
            }
            
            mostrarResultados(numPaginaInicial, numPaginaFinal, cantidadDePagAFotocopiar , precioPorUnaFotocopia,valorTotalQuePagaElCliente);   
            
          } while((JOptionPane.showConfirmDialog(
                null,
                "Desea repetir el Calculo?",
                "Sollicitud",
                JOptionPane.YES_NO_OPTION)) == 0);

        JOptionPane.showMessageDialog(null, "Programa Finalizado");
        JOptionPane.showMessageDialog(null, "      =========================" +
                                           "\n      ¦¦--- Institucion Universitaria ---¦¦" + 
                                           "\n      ¦¦- ANTONIO JOSE CAMACHO -¦¦" +
                                          "\n      =========================" +
                                       "\n\n            INGENIERIA EN SISTEMAS" +
                                          "\n            Programa Realizado por: " + 
                                       "\n\n            Leonardo Collazos Paez"+
                                       "\n               E-MAIL DE CONTACTO:"+
                                       "\n             leo011093@hotmail.com\n", "Creditos", 
                                       
                                       JOptionPane.INFORMATION_MESSAGE, 
                                       new ImageIcon("\\images\\leoface.png"));
    }
    
    
    
   public static void mensajeEntradaError()
   {
      JOptionPane.showMessageDialog(null, "La entrada realizada es incorrecta!");
   }
    
    public static int getEntero(String cadena)
   {//metodo que evalua si las entradas de las filas son correctas y repite el bucle las veces que sea necesarias para no tener que escribirla comprobacion tantas veces si no que el metodo se repita las veces que sea necesario.
       int num;
            try
            {
                num = Integer.parseInt(JOptionPane.showInputDialog(cadena));
            }
            catch(NumberFormatException e)
            {
                mensajeEntradaError();
                num = getEntero(cadena);
            }
        return num; //retorna la variable filaMatriz que es la misma variable que m1 o m2.
    }
     
   public static double getReal(String cadena)
   {//metodo que evalua si las entradas de las filas son correctas y repite el bucle las veces que sea necesarias para no tener que escribirla comprobacion tantas veces si no que el metodo se repita las veces que sea necesario.
       double num;  //no vale la pena inicializarlo en cero por que o si no lo que sucedera es que despues del error solo almacenara el cero como valor despues de la repeticion...
            try
            {
                num = Double.parseDouble(JOptionPane.showInputDialog(cadena));
            }catch(NumberFormatException e)
            {
                mensajeEntradaError();
                num = getReal(cadena);
            }
        return num; //retorna la variable filaMatriz que es la misma variable que m1 o m2.
    }
   
    public static int cantidadDePaginas(int numPag1, int numPag2) 
    {
        return numPag2 - numPag1;
    }
    
    public static double valorDePagoTotal(int numPags, double valorUnaCopia)
    {
        return numPags * valorUnaCopia;
    }
    
    public static void mostrarResultados(int pagina1, int pagina2, int paginasTotales, double valorPorPagina, double valorPagoTotal)
    {
        JOptionPane.showMessageDialog(null,     "La Pagina Inicial es: " + pagina1 
                                                                        + "\nLa pagina Final es: " + pagina2 
                                                                        + "\nEl valor unitario de fotocopia es: $" + valorPorPagina
                                                                        + "\nLas Paginas a fotocopiar en total son: " + paginasTotales 
                                                                        + "\nEl valor total a Pagar es: $" + valorPagoTotal);
    }
    
}
