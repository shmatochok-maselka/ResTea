USE restea;


SET FOREIGN_KEY_CHECKS=0;
DELETE FROM user;
DELETE FROM role;
DELETE FROM user_role;
DELETE FROM product;
DELETE FROM type;
DELETE FROM origin;
DELETE FROM flavor;
DELETE FROM property;
DELETE FROM product_flavor;
DELETE FROM product_properties;
DELETE FROM blog_post;
DELETE FROM cart;


INSERT INTO origin(id, name)
VALUES (1, 'Китай'),
       (2, 'Індія');

INSERT INTO type(id, name)
VALUES (1, 'Білий'),
       (2, 'Зелений'),
       (3, 'Чорний'),
       (4, 'Фруктовий');

INSERT INTO product(id, name, description, image, price, type_id, origin_id)
VALUES (1, 'Юе Гуан Бай Ча', 'Цей унікальний чай багато хто називає "білим Пу Ером".І як завжди в народній творчості, це дуже близько до правди.Це дійсно білий чай. Збирають сировину з тієї ж породи дерев, що і для Пу Ера.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/juje_guan_baj_cha_belyj_lunnyj_svet-00.jpg?itok=xW_Op_EP&timestamp=1642357934',
        7, 1, 1),
       (2, 'Срібні голки Імператорські', 'З майже побожним захопленням і жахом ми несли додому на пробу цей неймовірний чай.Поспіхом відкрили пакет.Перше, що кинулося в очі - якась казкова пухнастість. Кожна чаїнка густо вкрита білим пухом.',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU',
        15, 1, 2),
       (3, 'Бай Мудань Королівський', 'Ми впевнені, що Березневий Заєць і Капелюшник у Країні Чудес пили саме цей чай. Якщо закрити очі та прислухатися до відчуттів, то можна вловити неземні смакові відтінки, що нагадують карамельну солодкість, весняне капання і березовий сік. Прозорий настій з ледь помітним ароматом – те, що потрібно до недільного бранчу. Пийте його, не поспішаючи. І нехай весь світ зачекає.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/belyj_chaj_belyj_pion_korolevskij.jpg?itok=rYKNZfYb&timestamp=1480693001',
        11, 1, 1),
       (4, 'Бай Мудань', 'Цей чай смачніший за пломбір з дитинства, ароматніший за букет троянд і змістовніший за велику радянську енциклопедію. Дуже сонячний чай. Ми обожнюємо його смак за нотки різнотрав''я, фруктів і меду. А ще – за солодкий післясмак. Як показує практика, «Біла півонія» зачаровує всіх дівчат без винятку. І вас зачарує, обіцяємо.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/belyj-pion-baj-mudan-000.jpg?itok=6vpNmEYO&timestamp=1628568996',
        8, 1, 2),
       (5, 'Сиху Лунцзин', 'Друзі, знайомтеся – це наш новий чай, національна гордість Китаю. Тільки з''явився, а вже став улюбленцем. Яскравий, смачний, незабутній. Він як політ на повітряній кулі – залишає тільки приємні емоції та метеликів у животі. Саме цей Лунцзин з обмеженої території озера Сіху має титул «Знаменитий чай з Китаю». Саме озеро є об''єктом Всесвітньої спадщини ЮНЕСКО.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/sihu_lunczin_kolodec_drakona.jpg?itok=p_SIaISH&timestamp=1562169480',
        10, 2, 1),
       (6, 'Бай Мао Хоу', 'Волохаті чаїнки схожі на хвостики мавп. Для цього чаю беруть бруньку і два сусідніх листочки, які щойно розпустилися. Чай легкий, без гіркоти, дає гарний золотистий настій. В ароматі відчуваються медові та цитрусові нотки. Ми вважаємо, що це найсмачніший чай для вечірньої релаксації після напруженого дня.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/snezhnaja_obezjana_baj_mao_hou.jpg?itok=dNpIbyRE&timestamp=1554385518',
        10, 2, 2),
       (7, 'Лунцзин Суперлюкс', 'Коли я чую, як хтось говорить, що пробував Лун Цзин, мені завжди хочеться запитати - "А який саме Лунцзин ти пробував?". І завжди соромлюся .. Але саме цього лунцзина соромитися не можна! Їм потрібно хвалитися! Кричати на всіх кутах - спробуйте саме цей чай! Він сподобається всім. Люди, які спробували Лунцзин Суперлюкс, ніколи не стануть колишніми. Це третє око і рідка нірвана.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/lunczin_superljuks.jpg?itok=aKLE5dW5&timestamp=1562172872',
        10, 2, 1),
       (8, 'Лу Шань Юнь У', 'Якби серед зелених чаїв проводився конкурс «Найкорисніший чай на кожний день», то Лу Шань Юнь У виборов би перше місце. Його можна пити вранці, вдень і ввечері. Він натуральний, як молоко корівки. Зібраний на екологічно чистій території гір Лушань. Зроблений з даоським терпінням мовчазних китайських фермерів.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/lu_shan_jun_u-00.jpg?itok=z55rkP35&timestamp=1566277295',
        15, 2, 2),
       (9, 'Мао Фен', 'Мао Фен («Ворсисті піки») – класичний зелений чай. Легкий та ароматний. Найкращий чай, коли не знаєш, який напій сьогодні обрати. Хороший варіант для першого знайомства з китайськими чаями.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/maofeng-01.jpg?itok=UfAvJGbA&timestamp=1628192490',
        11, 2, 1),
       (10, 'Лунцзин Преміум', 'Лунцзин - це класика. Це король зелених чаїв. Це найвідоміший зелений чай Китаю. Мабуть немає більше чаю, до якого можна підібрати стільки порівнянь, епітетів і титулів. І це не даремно. Особисто для мене Лун Цзін - найвідоміший чай. Я з закритими очима відрізню його від будь-якого іншого. А ви зможете?',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/luntszyn-premyum-00.jpg?itok=6CI_j_Q4&timestamp=1665716500',
        3, 2, 2),
       (11, 'Хуаншань Маофен', 'Назва цього чаю перекладається як «Ворсисті піки з жовтої гори». І цьому є пояснення. Листочки Маофен укриті дрібними бежевими ворсинками. Так, немов ранковий туман огорнув гірські піки. Чари на цьому не закінчуються. Чай дуже легкий. Коли ви куштуєте його, то відчуваєте, що трішки піднімаєтеся над землею, немов маєте крила.',
        'https://newtea.ua/sites/default/files/styles/product-list/public/node/product/img2/huanshan_maofjen-02.jpg?itok=v4Rsb8FU',
        3, 2, 2),
       (12, 'Смарагдові перлини', 'Це ті самі жасминові перлини.Але без жасмину.Ми відволікли похилого віку фермера і укручили кілька кілограм.Дуже вже нам хотілося спробувати початковий смак.Якщо ви теж прагнете докопатися до самої суті – велкам.Ще кілька кілограмів залишилося.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/izumrudnye-zhemchuzhiny-00.jpg?itok=X2LAF5b8&timestamp=1636365713',
        3, 2, 1),
       (13, 'Чжу Йє Цін', 'Це найвідоміший чай із Сичуані. Флагман провінції. Його люблять і знають усі китайці без винятку. Чжу Е Цин роблять не з листя, а з мініатюрних пружних чайних паростків. Уявляєте, скільки їх потрібно для 100 г чаю? Збирати Чжу Е Цин украй важко.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/zelenyj_chaj_chzhu_je_tsin_01.jpg?itok=JmQTqQ3o&timestamp=1578293333',
        3, 2, 1),
       (14, 'Лю Ань Гуан Пянь', 'Цей чай збирається на обмежених територіях у лімітованій кількості. Його потрібно добре пошукати навіть у Китаї. Саме тому він не з дешевих. Спробувати його – немов виграти мільйон.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/zelenyj_chaj_lyu_an_guan_pyan-1.jpg?itok=kgs2kCFP&timestamp=1565624923',
        3, 2, 1),
       (15, 'Сінь Ян Мао Цзян Люкс', 'Звичайно цей нескінченний карантин не дочекається від нас хороших слів.Але треба зізнатися, що деякі радості він все ж приніс.Ось, наприклад, Сінь Ян Мао Цзян Люкс.Раніше купити вище Преміума у нас не виходило - вже дуже високий був попит на елітні сорти всередині самого Китаю.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/sin_jan_mao_czjan_ljuks-00.jpg?itok=fCpwwPJl&timestamp=1593772024',
        3, 2, 2),
       (16, 'Зелене руно із садов Ецтері', 'Зелений чай від грузинських майстрів із садів Ецтері.Несподівано хороший чай.Нагадує Маофен.Під враженням!',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/zelenoe-runo-iz-sadov-jecteri_1.jpg?itok=N9q7_GK3&timestamp=1630518208',
        3, 2, 2),
       (17, 'Дунтин Бі Ло Чунь', 'Складно щось додати до цього чаю. Та й нічого не треба додавати. Це – цар гори, top of the hill. Король зелених чаїв. Аромат, що збиває з ніг, – так називали його раніше. Найкращий Бі Ло Чунь в Україні.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/duntyn-bi-lo-chun-liuks-smarahdovi-spirali-vesny-liuks-00.jpg?itok=Ksa0dsRG&timestamp=1665717914',
        3, 2, 2),
       (18, 'Кенійський вулканічний', 'Звичний для нас дешевий чорний кенійський СТС-чай (Crush, Tear, and Curl - "Давити, рвати, скручувати") відходить у минуле.Маючи фантастичні природні умови, кенійські фермери поступово вибираються з-під свого колоніального минулого і видають на ринок чудові продукти.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/keniiskyi-vulkanichnyi-zelenyi-chai-00.jpg?itok=MsILGsqb&timestamp=1667972034',
        3, 2, 2),
       (19, 'Лю Ань Гуан Пянь', 'Цей чай збирається на обмежених територіях у лімітованій кількості. Його потрібно добре пошукати навіть у Китаї. Саме тому він не з дешевих. Спробувати його – немов виграти мільйон.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/zelenyj_chaj_lyu_an_guan_pyan-1.jpg?itok=kgs2kCFP&timestamp=1565624923',
        3, 2, 1),
       (20, 'Хуаншань Маофен', 'Крилатий чай. Ворсисті піки з Жовтої гори піднімуть вас високо над горами.Легкість ваша буде подібна до хмари.Один з найлегших і ароматніших китайських зелених чаїв.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/khuanshan-maofen-superliuks-00.jpg?itok=rIH4PU-L&timestamp=1666193147',
        3, 2, 2),
       (21, 'Срібні голки Імператорські', 'З майже побожним захопленням і жахом ми несли додому на пробу цей неймовірний чай.Поспіхом відкрили пакет.Перше, що кинулося в очі - якась казкова пухнастість. Кожна чаїнка густо вкрита білим пухом.',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEA1ARqIgj9GJ8Gj9bSwnrvuMh6fl7eHAgQ&usqp=CAU',
        15, 3, 2),
       (22, 'Бай Мудань Королівський', 'Ми впевнені, що Березневий Заєць і Капелюшник у Країні Чудес пили саме цей чай. Якщо закрити очі та прислухатися до відчуттів, то можна вловити неземні смакові відтінки, що нагадують карамельну солодкість, весняне капання і березовий сік. Прозорий настій з ледь помітним ароматом – те, що потрібно до недільного бранчу. Пийте його, не поспішаючи. І нехай весь світ зачекає.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/belyj_chaj_belyj_pion_korolevskij.jpg?itok=rYKNZfYb&timestamp=1480693001',
        11, 3, 1),
       (23, 'Бай Мудань', 'Цей чай смачніший за пломбір з дитинства, ароматніший за букет троянд і змістовніший за велику радянську енциклопедію. Дуже сонячний чай. Ми обожнюємо його смак за нотки різнотрав''я, фруктів і меду. А ще – за солодкий післясмак. Як показує практика, «Біла півонія» зачаровує всіх дівчат без винятку. І вас зачарує, обіцяємо.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/belyj-pion-baj-mudan-000.jpg?itok=6vpNmEYO&timestamp=1628568996',
        8, 3, 2),
       (24, 'Сиху Лунцзин', 'Друзі, знайомтеся – це наш новий чай, національна гордість Китаю. Тільки з''явився, а вже став улюбленцем. Яскравий, смачний, незабутній. Він як політ на повітряній кулі – залишає тільки приємні емоції та метеликів у животі. Саме цей Лунцзин з обмеженої території озера Сіху має титул «Знаменитий чай з Китаю». Саме озеро є об''єктом Всесвітньої спадщини ЮНЕСКО.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/sihu_lunczin_kolodec_drakona.jpg?itok=p_SIaISH&timestamp=1562169480',
        10, 3, 1),
       (25, 'Бай Мао Хоу', 'Волохаті чаїнки схожі на хвостики мавп. Для цього чаю беруть бруньку і два сусідніх листочки, які щойно розпустилися. Чай легкий, без гіркоти, дає гарний золотистий настій. В ароматі відчуваються медові та цитрусові нотки. Ми вважаємо, що це найсмачніший чай для вечірньої релаксації після напруженого дня.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/snezhnaja_obezjana_baj_mao_hou.jpg?itok=dNpIbyRE&timestamp=1554385518',
        10, 3, 2),
       (26, 'Хуаншань Маофен', 'Назва цього чаю перекладається як «Ворсисті піки з жовтої гори». І цьому є пояснення. Листочки Маофен укриті дрібними бежевими ворсинками. Так, немов ранковий туман огорнув гірські піки. Чари на цьому не закінчуються. Чай дуже легкий. Коли ви куштуєте його, то відчуваєте, що трішки піднімаєтеся над землею, немов маєте крила.',
        'https://newtea.ua/sites/default/files/styles/product-list/public/node/product/img2/huanshan_maofjen-02.jpg?itok=v4Rsb8FU',
        3, 3, 2),
       (27, 'Смарагдові перлини', 'Це ті самі жасминові перлини.Але без жасмину.Ми відволікли похилого віку фермера і укручили кілька кілограм.Дуже вже нам хотілося спробувати початковий смак.Якщо ви теж прагнете докопатися до самої суті – велкам.Ще кілька кілограмів залишилося.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/izumrudnye-zhemchuzhiny-00.jpg?itok=X2LAF5b8&timestamp=1636365713',
        3, 4, 1),
       (28, 'Чжу Йє Цін', 'Це найвідоміший чай із Сичуані. Флагман провінції. Його люблять і знають усі китайці без винятку. Чжу Е Цин роблять не з листя, а з мініатюрних пружних чайних паростків. Уявляєте, скільки їх потрібно для 100 г чаю? Збирати Чжу Е Цин украй важко.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/zelenyj_chaj_chzhu_je_tsin_01.jpg?itok=JmQTqQ3o&timestamp=1578293333',
        3, 4, 1),
       (29, 'Лю Ань Гуан Пянь', 'Цей чай збирається на обмежених територіях у лімітованій кількості. Його потрібно добре пошукати навіть у Китаї. Саме тому він не з дешевих. Спробувати його – немов виграти мільйон.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/zelenyj_chaj_lyu_an_guan_pyan-1.jpg?itok=kgs2kCFP&timestamp=1565624923',
        3, 4, 1),
       (30, 'Сінь Ян Мао Цзян Люкс', 'Звичайно цей нескінченний карантин не дочекається від нас хороших слів.Але треба зізнатися, що деякі радості він все ж приніс.Ось, наприклад, Сінь Ян Мао Цзян Люкс.Раніше купити вище Преміума у нас не виходило - вже дуже високий був попит на елітні сорти всередині самого Китаю.',
        'https://newtea.ua/sites/default/files/styles/product-page/public/node/product/sin_jan_mao_czjan_ljuks-00.jpg?itok=fCpwwPJl&timestamp=1593772024',
        3, 4, 2);

INSERT INTO flavor(id, name)
VALUES (1, 'Горіховий'),
       (2, 'Молочний'),
       (3, 'Шоколадний'),
       (4, 'Тропічний'),
       (5, 'Мультифруктовий'),
       (6, 'Медовий'),
       (7, 'Цитрусовий');

INSERT INTO property(id, name)
VALUES (1, 'property1'),
       (2, 'property2'),
       (3, 'property3');

INSERT INTO product_flavor(product_id, flavor_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 6),
       (3, 7),
       (4, 1),
       (4, 3),
       (5, 2),
       (5, 3),
       (5, 4),
       (6, 3),
       (6, 1),
       (6, 4),
       (7, 4),
       (7, 5),
       (7, 6),
       (7, 7),
       (8, 1),
       (8, 2),
       (9, 5),
       (9, 6),
       (9, 7),
       (10, 2),
       (10, 3),
       (11, 1),
       (11, 2),
       (11, 3),
       (12, 1),
       (12, 2),
       (13, 5),
       (13, 6),
       (13, 7),
       (14, 7),
       (15, 1),
       (15, 2),
       (15, 4),
       (16, 4),
       (16, 5),
       (17, 5),
       (18, 4),
       (18, 5),
       (18, 6),
       (19, 6),
       (19, 4),
       (20, 4),
       (20, 5),
       (20, 7),
       (21, 5),
       (21, 6),
       (22, 6),
       (23, 4),
       (23, 5),
       (23, 7),
       (24, 7),
       (24, 5),
       (25, 1),
       (25, 2),
       (26, 2),
       (26, 5),
       (26, 6),
       (26, 7),
       (27, 6),
       (27, 2),
       (28, 2),
       (28, 3),
       (29, 3),
       (29, 4),
       (29, 5),
       (30, 5);


INSERT INTO product_properties(product_id, property_id)
VALUES (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (4, 2),
       (4, 3),
       (5, 1),
       (5, 2);

# INSERT INTO cart(cart_user_id, cart_product_id, weight)
# VALUES(1, 1, 25),
#     (1, 2, 50),
#     (1, 3, 75),
#     (2, 2, 80),
#     (2, 3, 80);

INSERT INTO blog_post(id, title, image, content)
VALUES(1, 'title1','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (2, 'title2','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (3, 'title3','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (4, 'title4','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (5, 'title5','https://kiev.karavan.com.ua/wp-content/uploads/2020/10/dimc-min.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

-- INSERT INTO cart(cart_user_id, cart_product_id, weight)

-- Password 1234 is encrypted

INSERT INTO user (id, name, surname, patronymic, birthday, email, password, image)
VALUES (1, 'Ivan', 'Ivanovich','Ivanovich', '2022-10-28', 'test1@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80'),
       (2, 'Petro', 'Ivanovich','Ivanovich', '2022-10-28', 'test2@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80'),
       (3, 'Dmitriy', 'Ivanovich','Ivanovich', '2022-10-28', 'test3@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80'),
       (4, 'Oleg', 'Ivanovich','Ivanovich', '2022-10-28', 'test4@gmail.com', '$2a$10$9RwGiLB.ydD8c8oVxVamzOXxHYF1FQMhjrlHKY3pkCsjifrwCeJKK', 'https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80');

INSERT INTO role
VALUES (1, 'customer'),
       (3, 'admin');


INSERT INTO user_role
VALUES (1, 1),
       (1, 3),
       (2, 1),
       (3, 1),
       (4, 1);

SET FOREIGN_KEY_CHECKS = 1;