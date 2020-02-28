package br.com.alura.financask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.financask.R
import br.com.alura.financask.modelo.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(transacoes: List<Transacao>) : BaseAdapter() {

    private val transacoes = transacoes

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        view.transacao_valor.setText(transacao.getValor().toString());
        return view
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