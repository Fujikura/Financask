package br.com.alura.financask.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import br.com.alura.financask.R
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.modelo.Resumo
import br.com.alura.financask.modelo.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(
    private val contexto: Context,
    private val view: View,
    transacoes: List<Transacao>
) {

    private val resumo: Resumo = Resumo(transacoes)

    private val corDaReceita = ContextCompat.getColor(contexto, R.color.receita)
    private val corDaDespesa = ContextCompat.getColor(contexto, R.color.despesa)

    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        with(view.resumo_card_receita) {
            text = totalReceita.formataParaBrasileiro()
            setTextColor(corDaReceita)
        }
    }


    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa()
        with(view.resumo_card_despesa) {
            text = totalDespesa.formataParaBrasileiro()
            setTextColor(corDaDespesa)
        }
    }

    fun adicionaTotal() {
        val total = resumo.total()
        val cor = corPor(total)

        with(view.resumo_card_total) {
            setTextColor(cor)
            text = total.formataParaBrasileiro()
        }
    }

    private fun corPor(valor: BigDecimal): Int {
        if (valor >= BigDecimal.ZERO)
            return corDaReceita
        return corDaDespesa
    }

}