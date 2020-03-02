package br.com.alura.financask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.financask.R
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.modelo.Tipo
import br.com.alura.financask.modelo.Transacao
import br.com.alura.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = transacoesDeExemplo()
        var totalReceita = BigDecimal.ZERO

        for(transacao: Transacao in transacoes){
            if(transacao.tipo == Tipo.RECEITA)
                totalReceita = totalReceita.plus(transacao.valor)
        }

        resumo_card_receita.text = totalReceita.formataParaBrasileiro()

        configuraLista(transacoes)
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo(): List<Transacao> {
        return listOf(
            Transacao(
                valor = BigDecimal(100.00),
                tipo = Tipo.DESPESA,
                categoria = "Comida"

            ),
            Transacao(
                tipo = Tipo.RECEITA,
                valor = BigDecimal(3000.00)
            ),
            Transacao(
                tipo = Tipo.RECEITA,
                valor = BigDecimal(800.00),
                categoria = "Vale"
            )
            ,
            Transacao(
                valor = BigDecimal(150.00),
                tipo = Tipo.DESPESA,
                categoria = "Compras realizadas para setor de limpeza"
            )
        )
    }

}