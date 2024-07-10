package service;

import model.Practica;
import model.Resultado;

public class ResultadoService {

    public void crearYAsociarResultado(Practica practica, float valor) {
        Resultado resultado = new Resultado(valor, practica);
        practica.setResultado(resultado);
    }
}
