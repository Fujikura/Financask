package br.com.alura.financask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.financask.R
import br.com.alura.financask.modelo.Tipo
import br.com.alura.financask.modelo.Transacao
import br.com.alura.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacao1 = Transacao(
            valor = BigDecimal(100.00),
            tipo = Tipo.DESPESA,
            categoria = "Comida"

        )

        val transacao2 = Transacao(
            tipo = Tipo.RECEITA,
            valor = BigDecimal(3000.00)

        )

        val transacoes = listOf(transacao1, transacao2)

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes))
    }

}