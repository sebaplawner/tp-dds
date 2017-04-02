package com.tp.dds.empresa;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Periodo {
    private final String periodo;
    private final List<Cuenta> cuentas;

    public static Periodo getInstance(Element periodoNodo) {
        String periodo = periodoNodo.getAttribute("valor");
        NodeList cuentasNodos = periodoNodo.getElementsByTagName("cuenta");
        List<Cuenta> cuentas = getCuentas(cuentasNodos);

        return new Periodo(periodo, cuentas);
    }

    private static List<Cuenta> getCuentas(NodeList cuentasNodos) {
        List<Cuenta> cuentas = new ArrayList<>();

        for(int i = 0; i < cuentasNodos.getLength(); i++) {
            Element cuentaNodo = (Element) cuentasNodos.item(i);
            String id = cuentaNodo.getAttribute("id");
            int valor = Integer.parseInt(cuentaNodo.getTextContent());

            Cuenta cuenta = new Cuenta(id, valor);
            cuentas.add(cuenta);
        }

        return cuentas;
    }

    private Periodo(String periodo, List<Cuenta> cuentas) {
        this.periodo = periodo;
        this.cuentas = cuentas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}
