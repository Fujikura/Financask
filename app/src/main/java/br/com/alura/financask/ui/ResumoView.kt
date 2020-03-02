package br.com.alura.financask.ui

import android.view.View
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.modelo.Resumo
import br.com.alura.financask.modelo.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*

class ResumoView(
    private val view: View,
    transacoes: List<Transacao>
) {

    private val resumo: Resumo = Resumo(transacoes)

    fun adicionaReceita() {
        val totalReceita = resumo.receita().formataParaBrasileiro()
        view.resumo_card_receita.text = totalReceita
    }

    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa().formataParaBrasileiro()
        view.resumo_card_despesa.text = totalDespesa
    }

    fun adicionaTotal(){
        val total = resumo.total().formataParaBrasileiro()
        view.resumo_card_total.text = total
    }

}