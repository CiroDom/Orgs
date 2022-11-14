package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Test

class ProdutoActivityTests {

    @Test
    fun deveMostrarElementosDoApp(){
        ActivityScenario.launch(ListaProdutosActivity::class.java)

        Espresso
            .onView(ViewMatchers.withText("Orgs"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_nome))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_descricao))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_valor))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_botao_salvar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun devePreencherOsCampos(){
        ActivityScenario.launch(FormularioProdutoActivity::class.java)

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_nome))
            .perform(
                ViewActions.typeText("Banana"),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_descricao))
            .perform(
                ViewActions.typeText("banana prata"),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_valor))
            .perform(
                ViewActions.typeText("3.99"),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_botao_salvar))
            .perform(
                ViewActions.click()
            )

        Espresso
            .onView(
                ViewMatchers
                    .withText("Banana"))
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
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