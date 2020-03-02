package br.com.alura.financask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import br.com.alura.financask.R
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.extension.limitaEmAte
import br.com.alura.financask.modelo.Tipo
import br.com.alura.financask.modelo.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(
    private val transacoes: List<Transacao>,
    private val contexto: Context
) : BaseAdapter() {
    private val limiteCategoria: Int = 14

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(contexto)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        adicionaIcone(transacao, view)
        adicionaValor(view, transacao)
        adicionaCategoria(view, transacao)
        adicionaData(view, transacao)


        return view
    }

    private fun adicionaData(
        view: View,
        transacao: Transacao
    ) {
        view.transacao_data.text = transacao.data.formataParaBrasileiro()
    }

    private fun adicionaCategoria(
        view: View,
        transacao: Transacao
    ) {
        view.transacao_categoria.text = transacao.categoria.limitaEmAte(limiteCategoria)
    }

    private fun adicionaIcone(
        transacao: Transacao,
        view: View
    ) {
        val icone: Int = iconePor(transacao.tipo)
        view.transacao_icone.setBackgroundResource(icone)
    }

    private fun adicionaValor(
        view: View,
        transacao: Transacao
    ) {
        val cor: Int = corPor(transacao.tipo)
        view.transacao_valor.setTextColor(cor)
        view.transacao_valor.text = transacao.valor.formataParaBrasileiro()
    }

    private fun iconePor(tipo: Tipo): Int{
        if (tipo == Tipo.RECEITA)
            return R.drawable.icone_transacao_item_receita
        return R.drawable.icone_transacao_item_despesa
    }

    private fun corPor(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) {
            return ContextCompat.getColor(contexto, R.color.receita)
        }
        return ContextCompat.getColor(contexto, R.color.despesa)
    }


    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }
}