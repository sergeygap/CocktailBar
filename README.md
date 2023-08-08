# CocktailBar
## Описание
"Cocktail Bar" - это приложение, разработанное для создания и сохранения любимых коктейлей пользователей в одном месте. Оно предоставляет возможность пользователям легко создавать новые записи о своих любимых коктейлях, добавлять детализированную информацию, такую как название, рецепт и список ингредиентов. 
## Основные функциональности
1. Splash screen: экран загрузки, во время которого происходит проверка наличия записей в базе данных.<br>![2023-08-09_00h14_50](https://github.com/sergeygap/CocktailBar/assets/90153806/abd4285a-6d00-4140-82df-c6460f4ba46f)
2. Экран "Добавление первого коктейля".<br>![2023-08-09_00h17_30](https://github.com/sergeygap/CocktailBar/assets/90153806/6fbf1eb8-0ff3-426f-b7fb-26897108f473)
3. Экран "Мои Коктейли": экран со прокручиваемым списком коктейлей пользователя.![2023-08-09_00h24_29](https://github.com/sergeygap/CocktailBar/assets/90153806/00ddf0e3-80ad-40d4-a34a-0c7ebfa4d9fe) ![image](https://github.com/sergeygap/CocktailBar/assets/90153806/0540cc18-767c-4435-aee6-8ca9af6b215c)

4. Экран "Добавление коктейля". <br>![image](https://github.com/sergeygap/CocktailBar/assets/90153806/0d7e34fc-049d-482d-ba2b-ca69cff8719f)
![image](https://github.com/sergeygap/CocktailBar/assets/90153806/ed545218-88a8-4286-b80a-5d825956f119)
5. Экран "Детализированная информация": экран с детальной информацией о коктейле, отображает название, рецепт и описание. (TextView с ингредиентами куда-то улетел с экрана).<br>![image](https://github.com/sergeygap/CocktailBar/assets/90153806/d355a254-66c2-4a13-bfdd-eddb7847d326)
6. Кнопка "Удалить" со всплывающим диалогом: позволяет удалить коктейль при нажатии на экране "Детализированная информация".<br>![2023-08-09_00h25_48](https://github.com/sergeygap/CocktailBar/assets/90153806/944c5659-5020-4e6f-aac5-cc283893163b)
7. Кнопка "Сохранить": позволяет сохранить новый коктейль в личном списке,  при выходе из приложения список не стирается.<br>![2023-08-09_00h25_39](https://github.com/sergeygap/CocktailBar/assets/90153806/3d21fc1f-f122-4bec-8fc8-d983df7911ff)
8. Кнопка "Отмена": позволяет прервать сохранение нового коктейля и вернуться на предыдущий экран.
9. Перед сохранением нового коктейля выполняется валидация на проверку заполненности обязательных полей.<br>![2023-08-09_00h23_25](https://github.com/sergeygap/CocktailBar/assets/90153806/0ee35b91-a3a7-40d4-ae44-0a07283229dd)
### Не успел реализовать, но есть дизайн и наработки 
1. Экран "Редактирования": позволяет пользователю отредактировать имеющийся коктейль.
## Видео работы приложения
![2023-08-09_00h09_32](https://github.com/sergeygap/CocktailBar/assets/90153806/89de60ee-8aa6-496c-90fc-acd2ff8cd1bc)
_
## Технические детали реализации
- Язык программирования: Kotlin;
- Работа с UI: Constraint Layout, Material Design, Fragments (SAA);
- Работа с базой данных: Room, LiveData, Thread;
- Архитектурный паттерн: MVVM (Model-View-ViewModel), Clean Architecture 
## Контакты
Tg: @sergeygap
