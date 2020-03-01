package br.com.alura.financask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.financask.R
import br.com.alura.financask.modelo.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesAdapter(transacoes: List<Transacao>) : BaseAdapter() {

    private val transacoes = transacoes

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        view.transacao_valor.text = transacao.valor.toString()
        view.transacao_categoria.text = transacao.categoria
        view.transacao_data.text = transacao.data.formataParaBrasileiro()


        return view
    }

    fun Calendar.formataParaBrasileiro():String{
        val formataBrasileiro = "dd/MM/yyyy"
        val format = SimpleDateFormat(formataBrasileiro)
        return format.format(this.time)
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