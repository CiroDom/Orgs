package br.com.alura.orgs

import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.database.repository.ProdutoRepository
import br.com.alura.orgs.model.Produto
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

class ProdutoRepositoryTests {

    @Test
    fun `deve chamar o dao quando salva um produto`() = runTest {
        //Arrange - Config
        val daoMock = mockk<ProdutoDao>()
        val produtoRepository = ProdutoRepository(daoMock)
        val produto = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        coEvery {
            daoMock.salva(produto)
        }.returns(Unit)
        //Act
        produtoRepository.salva(produto)

        coVerify {
            daoMock.salva(produto)
        }
    }
}