# Втора лабораториска вежба по Софтверско инженерство
## Александар Тркалески, бр. на индекс 216126
## Control Flow Graph 

![CFG](https://github.com/TrkaleskiA/SI_2023_lab2_216126/assets/108904399/84089181-6563-4682-8f8c-68f3c8644dba)

## Цикломатска комплексност
Цикломатската комплексност ја пресметав како бројот на loops +1, односно региони во Control Flow Graph-от, и добив 11.

## Every Branch

![EveryBranch](https://github.com/TrkaleskiA/SI_2023_lab2_216126/assets/108904399/be01889c-de81-4180-864e-f8a4f9a67c8d)

## Тест случаи според критериумот EveryBranch <br/>
Имам вкупно 5 тест случаи: <br/>
1)Првиот тест е за RuntimeException.<br/>
2)Вториот тест е за if условот кога нема да внесам username и како username да го превземам соодветниот email <br/>
3)Третиот тест е if условот кога се проверува дали внесениот email е валиден и исто така и if условот дали password contains username односно дали пасвордот го содржи името илипасвордот е помал од 8 карактери. <br/>
4)Четвртиот тест е кога password има празно место<br/>
5)Петиот тест е за проверката дали password содржи специјален карактер <br/>

## Тест случаи според критериумот Multiple Condition
if (user==null || user.getPassword()==null || user.getEmail()==null) <br />
// T X X //кога user e null <br />
// F T X //кога user не е null, но password е null <br />
// F F T //кога user не е null и password не е null, но email е null  <br />
// F F F //кога сите се внесени односно ни едно не е null<br />
<br />
