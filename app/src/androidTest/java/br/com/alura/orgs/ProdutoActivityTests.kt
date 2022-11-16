package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Before
import org.junit.Test

class ProdutoActivityTests {

    /** PREPARAÇÃO DO AMBIENTE */

    @Before
    fun preparaAmbiente(){
        AppDatabase.instancia(
            InstrumentationRegistry.getInstrumentation().targetContext
        ).clearAllTables()
    }

    /** FUNÇÕES TESTE */

    @Test
    fun deveMostrarElementosDoApp(
        idDaViewDoNome: Int = R.id.activity_formulario_produto_nome,
        idDaViewDaDesc: Int = R.id.activity_formulario_produto_descricao,
        idDaViewDoValor: Int = R.id.activity_formulario_produto_valor,
        idDaViewDoBotaoSalvar: Int = R.id.activity_formulario_produto_botao_salvar
    ){
        lancaListaProdActivity()

        confereSeOElementoApareceCorretamentePeloNome("Orgs")

        checaSeOElementoAparecePelaID(idDaViewDoNome)

        checaSeOElementoAparecePelaID(idDaViewDaDesc)

        checaSeOElementoAparecePelaID(idDaViewDoValor)

        checaSeOElementoAparecePelaID(idDaViewDoBotaoSalvar)
    }

    @Test
    fun devePreencherOsCamposESalvar(
        nome: String = "Banana Prata",
        desc: String = "Banana prata madura",
        valor: String = "5.99"
    ){
        lancaListaProdActivity()

        clicaNoFAB()

        preencheOsCampos(nome, desc, valor)

        salvaProduto()

        confereSeOElementoApareceCorretamentePeloNome(nome)

        deletaOProdutoTeste(nome)
    }

    @Test
    fun deveEditarUmProduto(
        nome: String = "Banana Prata",
        desc: String = "Banana prata madura",
        valor: String = "5.99",
        novoNome: String = "Banana Nanica",
        novaDesc: String = "Banana nanica da feirinha",
        novoValor: String = "3.99",
        idDaViewDoNome: Int = R.id.activity_formulario_produto_nome
    ){
        lancaListaProdActivity()

        clicaNoFAB()

        preencheOsCampos(nome, desc, valor)

        salvaProduto()

        clicaEmEditar(nome)

        repreencheOsCampos(novoNome, novaDesc, novoValor)

        salvaProduto()

        checaSeOElementoAparecePelaID(idDaViewDoNome)

        deletaOProdutoTeste(novoNome)
    }

    /** FUNÇÕES AUXILIARES */

    private fun lancaListaProdActivity() {
        ActivityScenario.launch(ListaProdutosActivity::class.java)
    }

    private fun checaSeOElementoAparecePelaID(idDaViewDoNome: Int) {
        Espresso
            .onView(ViewMatchers.withId(idDaViewDoNome))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun confereSeOElementoApareceCorretamentePeloNome(nome: String) {
        Espresso
            .onView(ViewMatchers.withText(nome))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun clicaNoFAB() {
        Espresso
            .onView((ViewMatchers.withId(R.id.activity_lista_produtos_fab)))
            .perform(ViewActions.click())
    }

    private fun preencheOsCampos(nome: String, desc: String, valor: String) {
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_nome))
            .perform(
                ViewActions.typeText(nome),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_descricao))
            .perform(
                ViewActions.typeText(desc),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_valor))
            .perform(
                ViewActions.typeText(valor),
                ViewActions.closeSoftKeyboard()
            )
    }

    private fun salvaProduto() {
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_botao_salvar))
            .perform(ViewActions.click())
    }


    private fun clicaEmEditar(nome: String) {
        Espresso
            .onView(ViewMatchers.withText(nome))
            .perform(ViewActions.click())

        Espresso
            .onView(ViewMatchers.withId(R.id.menu_detalhes_produto_editar))
            .perform(ViewActions.click())
    }

    private fun repreencheOsCampos(
        novoNome: String,
        novaDesc: String,
        novoValor: String
    ) {
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_nome))
            .perform(
                ViewActions.replaceText(novoNome),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_descricao))
            .perform(
                ViewActions.replaceText(novaDesc),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_valor))
            .perform(
                ViewActions.replaceText(novoValor),
                ViewActions.closeSoftKeyboard()
            )
    }

    private fun deletaOProdutoTeste(nome: String){
        Espresso
            .onView(ViewMatchers.withText(nome))
            .perform(ViewActions.click())

        Espresso
            .onView(ViewMatchers.withId(R.id.menu_detalhes_produto_remover))
            .perform(ViewActions.click())
    }
}

/**

É possível simplificar, a partir da importação de membros,
as funções da ActivityScenario e do Espresso, tal como as
classes ViewMatchers e ViewAssertions.

Foi optado deixar assim para que a forma "não-simplificada"
pudesse ser consultada.

 A versão simplificada se encontra na LoginActivityTests

 **/