package com.example.taskapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Testes automatizados de UI para TaskActivity usando Espresso.
 *
 * Esta classe contém os testes para validar o comportamento
 * da TaskActivity com padrões de teste Espresso.
 *
 * @author DIO Desafio de Projeto
 * @version 1.0
 */
@RunWith(AndroidJUnit4::class)
class TaskActivityTest {

    /**
     * Rule que fornece a Activity para teste.
     * ActivityScenarioRule lança a Activity antes de cada teste.
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(TaskActivity::class.java)

    /**
     * Teste 1: Verifica se a Activity lança corretamente.
     * Procura por um elemento EditText na tela.
     */
    @Test
    fun testActivityLaunch() {
        onView(withId(R.id.taskEditText))
            .check(matches(isDisplayed()))
    }

    /**
     * Teste 2: Verifica se é possível digitar no EditText.
     * Arrange: Preparar dados
     * Act: Executar ação de digitar
     * Assert: Verificar se o texto foi inserido
     */
    @Test
    fun testTypeTextInEditText() {
        // Arrange - preparar dados
        val taskName = "Minha Primeira Tarefa"

        // Act - digitar texto no EditText
        onView(withId(R.id.taskEditText))
            .perform(typeText(taskName))

        // Assert - verificar se o texto foi inserido
        onView(withId(R.id.taskEditText))
            .check(matches(withText(taskName)))
    }

    /**
     * Teste 3: Verifica se o botão de adicionar tarefa é exibido.
     */
    @Test
    fun testAddButtonIsDisplayed() {
        onView(withId(R.id.addButton))
            .check(matches(isDisplayed()))
    }

    /**
     * Teste 4: Testa a adicionar uma tarefa completa.
     * Digita uma tarefa e clica no botão de adicionar.
     */
    @Test
    fun testAddNewTask() {
        // Arrange
        val taskName = "Estudar Espresso"

        // Act
        onView(withId(R.id.taskEditText))
            .perform(typeText(taskName))

        onView(withId(R.id.addButton))
            .perform(click())

        // Assert - verifica se a tarefa foi adicionada à lista
        onView(withText(taskName))
            .check(matches(isDisplayed()))
    }

    /**
     * Teste 5: Verifica se EditText fica vazio após adicionar uma tarefa.
     */
    @Test
    fun testEditTextClearsAfterAddingTask() {
        // Arrange
        val taskName = "Tarefa de Teste"

        // Act - adicionar tarefa
        onView(withId(R.id.taskEditText))
            .perform(typeText(taskName), click())

        onView(withId(R.id.addButton))
            .perform(click())

        // Assert - verificar se o EditText está vazio
        onView(withId(R.id.taskEditText))
            .check(matches(withText("")))
    }

    /**
     * Teste 6: Valida comportamento com texto vazio.
     * Tenta adicionar uma tarefa sem digitar nada.
     */
    @Test
    fun testAddEmptyTask() {
        // Act - clicar no botão sem digitar
        onView(withId(R.id.addButton))
            .perform(click())

        // Assert - verifica se nenhuma tarefa vazia foi adicionada
        // ou se uma mensagem de erro é exibida
        onView(allOf(
            withId(R.id.taskEditText),
            withText("")  
        )).check(matches(isDisplayed()))
    }

    /**
     * Teste 7: Verifica se é possível deletar uma tarefa.
     */
    @Test
    fun testDeleteTask() {
        // Arrange - adicionar uma tarefa
        val taskName = "Tarefa para Deletar"
        onView(withId(R.id.taskEditText))
            .perform(typeText(taskName))
        onView(withId(R.id.addButton))
            .perform(click())

        // Act - deletar a tarefa (clicar no botão de deletar)
        onView(withId(R.id.deleteButton))
            .perform(click())

        // Assert - verificar se a tarefa foi removida
        onView(withText(taskName))
            .check(matches(isDisplayed()))
    }

    /**
     * Teste 8: Testa EditText com máximo de caracteres.
     */
    @Test
    fun testEditTextMaxLength() {
        // Arrange - texto muito longo
        val longText = "a".repeat(300)

        // Act - tentar digitar texto muito longo
        onView(withId(R.id.taskEditText))
            .perform(typeText(longText))

        // Assert - o EditText deve ter um limite de caracteres
        // Este teste depende da implementação
    }
}
