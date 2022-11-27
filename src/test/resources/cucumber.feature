#language=en

@all

Feature: Проверка методов с сайта herokuapp.com по 8 домашнему заданию

  @Checkboxes
  Scenario: Checkboxes(нажать чекбокс, проверить, что нажат)
    When проверить что нажат Checkboxes

  @FormAuthentication_positive
  Scenario: ввести правильный логин, пароль, проверить результат
    When проверить возможность авторизации с правильными логином/паролем

  @FormAuthentication_negative
  Scenario: ввести неправильный логин, пароль,  проверить результат
    When проверить возможность авторизации с неправильными логином/паролем

  @Hovers
  Scenario: навести курсор на нужного пользователя, проверить что отображается текст
    When проверить что при наведении курсора на одного из аватаров пользователя отображается текст

  @DynamicallyLoadedPageElements
  Scenario: дождаться загрузки динамического элемента на странице
    When проверить что динамически загружаемый элемент отображается на странице

  @KeyPresses
  Scenario: отправить команду, проверить
    When проверить что команда введена

  @AddRemoveElements
  Scenario: добавлять элементы, пока не появится необходимое количество, переданное на вход
    When проверить что добавились элементы в количестве, которое передали на вход

