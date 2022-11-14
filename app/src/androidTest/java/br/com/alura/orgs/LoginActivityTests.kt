package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.*
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class LoginActivityTests {

    @Test
    fun deveMostrarElementosdoLogin() {
        launch(LoginActivity::class.java)

        // Nome do app
        onView(withText("Orgs"))
            .check(matches(isDisplayed()))

        // Campos existentes
        onView(withId(R.id.activity_login_usuario))
            .check(matches(isDisplayed()))

        onView(withId(R.id.activity_login_senha))
            .check(matches(isDisplayed()))

        onView(withId(R.id.activity_login_botao_entrar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun devePreencherElementosdoLogin() {
        launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario))
            .perform(typeText("Login"), ViewActions.pressBack())

        onView(withId(R.id.activity_login_senha))
            .perform(typeText("senha"), ViewActions.pressBack())

        onView(withId(R.id.activity_login_botao_entrar))
            .perform(click())
    }
}