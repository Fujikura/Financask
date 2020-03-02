package br.com.alura.financask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import br.com.alura.financask.R
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.modelo.Tipo
import br.com.alura.financask.modelo.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.DecimalFormat
import java.util.*

class ListaTransacoesAdapter(transacoes: List<Transacao>) : BaseAdapter() {

    private val transacoes = transacoes

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val context = parent.context

        val view = LayoutInflater.from(context)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        if(transacao.tipo == Tipo.RECEITA){
            view.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.receita))
            view.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
        }else{
            view.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.despesa))
            view.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
        }

        val formatoBrasileiro = DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
        val moedaFormatada = formatoBrasileiro
            .format(transacao.valor)
            .replace("R$", "R$ ")

        view.transacao_valor.text = moedaFormatada
        view.transacao_categoria.text = transacao.categoria
        view.transacao_data.text = transacao.data.formataParaBrasileiro()


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