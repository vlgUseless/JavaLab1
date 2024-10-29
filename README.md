# Вводная лаборатория

## Задание

7. Перемножение двух матриц, заданных в программе.

## Требования

Для выполнения лабораторной потребуется установить:
1. Java версии не ниже 17
2. IDE Eclipse или Idea не использовать (а взять любимый текстовый редактор)
3. Завести аккаунт на github
4. Maven 3+
5. Git

## Создание проекта

```bash
mvn archetype:generate -DgroupId=ru.spbstu.telematics.java -DartifactId=${ProjectName} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Заменить в pom.xml зависимость junit на
```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.12</version>
  <scope>test</scope>
</dependency>
```

Добавить библиотеку commons-math
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-math3</artifactId>
    <version>3.6</version> 
</dependency>
```

## Сдача лабораторной

1. Предъявление работоспособного кода
2. Ссылка на github с проектом 
3. Unit тесты, проверяющие правильность работы программы
4. Демонстрация студентом умения базового использования Maven, Git и Java
