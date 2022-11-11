package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.amshove.kluent.should
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test
import java.math.BigDecimal

class ProdutoTests {

    @Test
    fun `deve retornar verdadeiro quando o valor for valido`() {
        //Arrange
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        //Act
        val valorEhValido = produtoValido.valorEhValido

        //Assert
        valorEhValido shouldBe true
    }

    @Test
    fun `deve retornar falso quando o valor for maior que cem`() {
        //Arrange - Arrumar
        val produtoInvalido = Produto(
            nome = "Carambola",
            descricao = "Amarela",
            valor = BigDecimal("105.99")
        )

        //Act - Agir
        val valorEhValido = produtoInvalido.valorEhValido

        //Assert - Afirme
        valorEhValido shouldBe false
    }

    @Test
    fun `deve retornar falso quando o valor for menor ou igual a zero`() {
        //Arrange
        val produtoComValorIgualAZero = Produto(
            nome = "Lichia",
            descricao = "Doce",
            valor = BigDecimal("0")
        )
        val produtoComValorMenorQueZero = Produto(
            nome = "Uva",
            descricao = "Thompson",
            valor = BigDecimal("-10.99")
        )

        //Act
        val valorIgualAZeroEhValido = produtoComValorIgualAZero.valorEhValido
        val valorMenorQueZeroEhValido = produtoComValorMenorQueZero.valorEhValido

        //Assert
        valorIgualAZeroEhValido shouldBe false
        valorMenorQueZeroEhValido shouldBe false
    }
}