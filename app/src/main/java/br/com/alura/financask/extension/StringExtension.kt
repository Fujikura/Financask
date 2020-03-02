package br.com.alura.financask.extension

fun String.limitaEmAte(caracteres: Int): String {
    if (this.length > caracteres) {
        val primeiroCaracterer = 0
        return "${this.substring(primeiroCaracterer, caracteres)}..."
    }
    return this
}