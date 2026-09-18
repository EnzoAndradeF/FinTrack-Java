package com.fintrack.dao;

import java.util.List;
import com.fintrack.model.Transacao;

public interface TransacaoDAO {
    void salvar(Transacao transacao);

    List<Transacao> listarTodas();

    void deletar(int id);
}
