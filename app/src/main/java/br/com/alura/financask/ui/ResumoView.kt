package br.com.alura.financask.ui

import android.view.View
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.modelo.Tipo
import br.com.alura.financask.modelo.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(private val view: View,
                 private val transacoes: List<Transacao>) {

    fun adicionaReceitaNoResumo() {
        var totalReceita = BigDecimal.ZERO

        for (transacao: Transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA)
                totalReceita = totalReceita.plus(transacao.valor)
        }

        view.resumo_card_receita.text = totalReceita.formataParaBrasileiro()
    }

    fun adicionaDespesaNoResumo() {
        var totalDespesa = BigDecimal.ZERO

        for (transacao: Transacao in transacoes) {
            if (transacao.tipo == Tipo.DESPESA)
                totalDespesa = totalDespesa.plus(transacao.valor)
        }

        view.resumo_card_despesa.text = totalDespesa.formataParaBrasileiro()
    }
}