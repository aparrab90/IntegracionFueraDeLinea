package org.acme.camelIntegracionFueradeLineaaparrab;

import org.apache.camel.main.Main;

/**
 * Main class that boot the Camel application
 */
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class MyApplication {
    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(new MyRouteBuilder());
            camelContext.start();
            // Para detener la espera
            Thread.sleep(5 * 60 * 1000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}