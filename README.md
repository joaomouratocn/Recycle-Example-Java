# RecycleView

RecycleView é um widget que apresenta dados em forma de lista ou grid. a recycle carrega os dados
a serem apresentado dinamicamente, só carregando os dados que estão visiveis ao usúario. Por isso o nome recycleView (Reciclagem de views).RecycleView

Para usar recycleView precisa de seis partes:

## Os dados
Os dados a serem aprensetado na recycleView

## O Layout da recycleView
O layout onde serão apresentados os items

## O Layout manager
O metodo que informará a recycleView como o layout do itens serão apresentado (List, Grid, Staggered)

## ViewHolder
A viewHolder é uma class recebe os dados e passa para o layout do item, para assim serem apresentados.

## Adaptador
O adaptador é que realmente realiza a ligação de todos os componentes, sendo setado na recycleView
