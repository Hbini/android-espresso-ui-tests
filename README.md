# Android Espresso UI Tests - Desafio DIO

Projeto de testes automatizados de UI em Android com Kotlin e Espresso, desenvolvido como desafio da plataforma Digital Innovation One (DIO).

## Descrição do Projeto

Este projeto replica e melhora o projeto conduzido pelos experts da DIO, com o objetivo de incluir novas funcionalidades e melhorias, tornando os testes ainda mais robustos e efetivos.

## Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Framework de Testes**: Espresso
- **Plataforma**: Android
- **Build Tool**: Gradle
- **IDE**: Android Studio
- **Controle de Versão**: Git

## Estrutura do Projeto

```
android-espresso-ui-tests/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/taskapp/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── TaskActivity.kt
│   │   │   │   └── models/Task.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   └── activity_task.xml
│   │   │   │   ├── values/strings.xml
│   │   │   │   └── drawable/
│   │   │   └── AndroidManifest.xml
│   │   └── androidTest/
│   │       └── java/com/example/taskapp/
│   │           ├── TaskActivityTest.kt
│   │           └── MainActivityTest.kt
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
├── README.md
└── .gitignore
```

## Dependências Principais

### Core Android
```gradle
implementation('androidx.appcompat:appcompat:1.6.1')
implementation('androidx.core:core-ktx:1.9.0')
implementation('com.google.android.material:material:1.9.0')
```

### Testes (Espresso)
```gradle
androidTestImplementation('androidx.test.ext:junit:1.1.5')
androidTestImplementation('androidx.test.espresso:espresso-core:3.5.1')
androidTestImplementation('androidx.test:runner:1.5.2')
```

## Testes Implementados

### TaskActivityTest

Testes que verificam:
- Lançamento da Activity
- Exibição de elementos de UI (EditText, Button, TextView)
- Interações com EditText (digitação de texto)
- Clique em botões
- Validação de dados inseridos
- Navegação entre Activities
- Mensagens de erro e validação

### MainActivityTest

Testes que verificam:
- Inicialização da aplicação
- Exibição de elementos iniciais
- Ações de clique em botões
- Navegação para TaskActivity
- Estado das views após ações

## Como Executar os Testes

### Via Android Studio

1. Abrir o projeto no Android Studio
2. Conectar um dispositivo Android ou abrir um emulador
3. Executar os testes:
   - Clicar com botão direito no arquivo de teste
   - Selecionar "Run 'NomeDoteste'"
   - Ou pressionar Shift + F10

### Via Linha de Comando

```bash
# Executar todos os testes instrumentados
./gradlew connectedAndroidTest

# Executar um teste específico
./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.example.taskapp.TaskActivityTest

# Executar com debug
./gradlew connectedAndroidTest --debug
```

## Padrões de Teste Utilizados

### Padrão AAA (Arrange, Act, Assert)

```kotlin
@Test
fun testAddTask() {
    // Arrange - Preparar dados
    val taskName = "Nova Tarefa"
    
    // Act - Executar ações
    onView(withId(R.id.editText)).perform(typeText(taskName))
    onView(withId(R.id.addButton)).perform(click())
    
    // Assert - Verificar resultados
    onView(withText(taskName)).check(matches(isDisplayed()))
}
```

### Padrão Robot

O padrão Robot pode ser implementado para melhorar a legibilidade e manutenibilidade dos testes:

```kotlin
class TaskActivityRobot {
    fun typeTaskName(name: String) {
        onView(withId(R.id.editText)).perform(typeText(name))
    }
    
    fun clickAddButton() {
        onView(withId(R.id.addButton)).perform(click())
    }
}
```

## Melhorias Implementadas

1. **Cobertura de Testes Expandida**: Incluindo múltiplos cenários e casos extremos
2. **Testes mais Robustos**: Com tratamento de erros e validações
3. **Documentação Detalhada**: Comentários no código e documentação do projeto
4. **Boas Práticas Android**: Seguindo guidelines oficiais do Android
5. **Organização**: Estrutura clara e modular do projeto
6. **CI/CD Ready**: Pronto para integração contínua

## Recursos de Apoio Oficiais

- [Documentação Espresso - Android Developers](https://developer.android.com/training/testing/espresso)
- [Robot Pattern - Testing Robots](https://jakewharton.com/testing-robots/)
- [Testing Android Apps - Android Developers](https://developer.android.com/training/testing)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Android Architecture Components](https://developer.android.com/topic/architecture)

## Requisitos do Sistema

- Android Studio 4.0 ou superior
- SDK Android 21 (Android 5.0) ou superior
- Kotlin 1.6 ou superior
- Gradle 7.0 ou superior
- JDK 11 ou superior

## Contribuições

Este projeto foi desenvolvido como parte do desafio de projeto da DIO. Contribuições e melhorias são bem-vindas!

## Autor

Desenvolvido como desafio de projeto da plataforma **Digital Innovation One (DIO)**.

## Especialista Instrutor

- **Caroline Tenorio Ribeiro** - Mobile Engineer, Santander
  - LinkedIn: linkedin.com/in/carolinetenorio/

## Tags

`#QA` `#Testes` `#Android` `#Kotlin` `#Git` `#Espresso` `#Automação` `#Testes-UI` `#Mobile` `#DIO`

## Licença

Este projeto está disponível sob licença aberta para fins educacionais e de portfólio.

---

**Última atualização**: Fevereiro de 2026
**Status**: Ativo e em desenvolvimento
