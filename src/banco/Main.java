package banco;

import java.util.Scanner;
import java.util.logging.*;

public class Main {

    //INTRODUCIENDO CAMBIOS
    
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        
        operativaCuenta();
    }

    public static void operativaCuenta() {
        CtaCorriente miCuenta;
        double saldoActual;

        miCuenta = new CtaCorriente("Koldo García Ábalos","0001-2345-07-1234567890",5000,0);
        saldoActual = miCuenta.getSaldocuenta();
        logger.log(Level.INFO,"El saldo inicial es de {0} euros", saldoActual);

        try {
            Scanner entrada = new Scanner(System.in);
            
            logger.log(Level.INFO,"¿Cuánto desea retirar?");
            double importe = entrada.nextDouble();
            miCuenta.retirar(importe);
            logger.log(Level.INFO,"El saldo actual de su cuenta es {0} euros",miCuenta.getSaldocuenta());
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING,"Fallo al retirar");
        }
        try {
            Scanner entrada = new Scanner(System.in);
            logger.log(Level.INFO,"¿Cuánto desea ingresar en su cuenta?");
            double importe = entrada.nextDouble();
            miCuenta.ingresar(importe);
            logger.log(Level.INFO,"El saldo actual de su cuenta es {0} euros",miCuenta.getSaldocuenta());
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING,"Fallo al ingrear");
        }
    }
}