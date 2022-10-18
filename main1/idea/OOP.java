package com.main1.idea;

public class OOP
{
    public static void main(String[] args)
    {
        //  модификаторы доступа
        //  Private — наиболее строгий модификатор доступа. Он ограничивает видимость данных
        //  и методов пределами одного класса.

        //Поля и методы, обозначенные модификатором доступа protected, будут видны:
        //в пределах всех классов, находящихся в том же пакете, что и наш;
        //в пределах всех классов-наследников нашего класса.

        // Дальше у нас по списку идет модификатор default или, как его еще называют, package visible.
        // Он не обозначается ключевым словом, поскольку установлен в Java по умолчанию для всех полей и методов.

        //Если привести пример из жизни, private — это все процессы, происходящие внутри телевизора,
        // когда он работает, а public — это кнопки на пульте телевизора, с помощью которых
        // пользователь может им управлять. При этом ему не нужно знать как устроен телевизор
        // и за счет чего он работает. Пульт — это набор public-методов: on(), off(), nextChannel(),
        // previousChannel(), increaseVolume(), decreaseVolume() и т.д.


        
    }
}
