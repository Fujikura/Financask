package br.com.alura.financask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.financask.R
import br.com.alura.financask.modelo.Tipo
import br.com.alura.financask.modelo.Transacao
import br.com.alura.financask.ui.ResumoView
import br.com.alura.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = transacoesDeExemplo()

        configuraResumo(transacoes)
        configuraLista(transacoes)
    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view = window.decorView
        val resumoView = ResumoView(view, transacoes)

        resumoView.adicionaReceita()
        resumoView.adicionaDespesa()
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