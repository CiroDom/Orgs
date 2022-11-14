package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import org.junit.Test

class CadastroActivityTests {

    @Test
    fun deveMostrarCamposDoCadastro(){
        ActivityScenario.launch(FormularioCadastroUsuarioActivity::class.java)

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_usuario))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_nome))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_senha))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_botao_cadastrar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
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