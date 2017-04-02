package com.tp.dds.empresa;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private final String nombre;
    private final List<Periodo> periodos;

    public static Empresa getInstance(Element empresaNodo) {
        String nombre = empresaNodo.getAttribute("nombre");
        NodeList periodoNodos = empresaNodo.getElementsByTagName("periodo");
        List<Periodo> periodos = getPeriodos(periodoNodos);

        return new Empresa(nombre, periodos);
    }

    private static List<Periodo> getPeriodos(NodeList periodoNodos) {
        List<Periodo> periodos = new ArrayList<>();

        for (int i = 0; i < periodoNodos.getLength(); i++) {
            Element periodoNodo = (Element) periodoNodos.item(i);
            Periodo periodo = Periodo.getInstance(periodoNodo);
            periodos.add(periodo);
        }

        return periodos;
    }

    private Empresa(String nombre, List<Periodo> periodos) {
        this.nombre = nombre;
        this.periodos = periodos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Periodo periodo : periodos) {
            sb.append(String.format("%s\n\n", periodo.getPeriodo()));
            for (Cuenta cuenta : periodo.getCuentas()) {
                String id = cuenta.getId();
                id = id.substring(0, Math.min(id.length(), 25));
                if (cuenta.getId().length() > 25)
                    id = id.concat("...");

                sb.append(String.format("  %s: %d\n", id, cuenta.getValor()));
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }
}
