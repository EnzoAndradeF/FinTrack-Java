package com.fintrack.repository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenerico<T> {
    private List<T> elementos = new ArrayList<>();

    public void adicionar(T elemento) {
        elementos.add(elemento);
    }

    public void remover(T elemento) {
        elementos.remove(elemento);
    }

    public List<T> listarTodos() {
        return new ArrayList<>(elementos);
    }

    public void adicionarTodos(List<? extends T> novosElementos) {
        for (T t : novosElementos) {
            elementos.add(t);
        }
    }

    public void exportarPara(List<? super T> destino) {
        destino.addAll(elementos);
    }
}

