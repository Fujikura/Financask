package br.com.alura.financask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.financask.R

class ListaTransacoesAdapter(transacoes: List<String>) : BaseAdapter() {

    private val transacoes = transacoes

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(parent?.context)
            .inflate(R.layout.transacao_item, parent, false)
    }

    override fun getItem(position: Int): Any {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }
}