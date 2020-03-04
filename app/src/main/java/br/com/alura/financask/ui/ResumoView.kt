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

class ResumoView(private val contexto: Context,
    private val view: View,
    transacoes: List<Transacao>
) {

    private val resumo: Resumo = Resumo(transacoes)

    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        view.resumo_card_receita.text = totalReceita.formataParaBrasileiro()
        view.resumo_card_receita.setTextColor(ContextCompat.getColor(contexto, R.color.receita))
    }

    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa()
        view.resumo_card_despesa.text = totalDespesa.formataParaBrasileiro()
        view.resumo_card_despesa.setTextColor(ContextCompat.getColor(contexto, R.color.despesa))
    }

    fun adicionaTotal(){
        val total = resumo.total()

        if(total.compareTo(BigDecimal.ZERO) >= 0){
            view.resumo_card_total.setTextColor(ContextCompat.getColor(contexto,R.color.receita))
        }else{
            view.resumo_card_total.setTextColor(ContextCompat.getColor(contexto,R.color.despesa))
        }

        view.resumo_card_total.text = total.formataParaBrasileiro()
    }

}