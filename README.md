# Aplicativo Pokemon

## Introdução


## Configuração do projeto
Ele pode ser baixado conforme abaixo:
```sh
$ git clone https://github.com/SamuelDevMobile/AppMarvelStudios.git
```
Abra-o no seu Android Studio
<img width="796" alt="Captura de Tela 2022-08-18 às 16 49 30" src="https://user-images.githubusercontent.com/26841238/185482115-adb2f78d-4b36-4cac-a6b7-d2806b0b7bc5.png">

Execute o projeto no seguinte icone.
<img width="24" alt="Captura de Tela 2022-08-18 às 16 50 33" src="https://user-images.githubusercontent.com/26841238/185482305-56a82404-d54c-4590-a658-b855461eb1d2.png">

## Visão geral da arquitetura
Este projeto foi construido com a linguagem Kotlin e construído com a arquitetura MVVM junto com LiveData, foi implementado também alguns princípios de boas práticas
no mundo de desenvolvimento orientado a objeto com SOLID, Coroutines para uma requisição assíncrona e Retrofit para se comunicar com a API da Marvel, Picasso
para renderizar imagens e Injeção de dependência com Koin. Desenvolvido com Activitys e usado ViewBinding, RecyclerView para Listar os pokemons na Tela de ver todos os Pokemons. Possui uma tela para ler um QRCode
e com esse QRCode ele le o pokemon e mostra o detalhamento em uma outra tela.

## Fluxo de trabalho de Controle de Versão
Usamos vagamente a abordagem "Git flow": master é a versão
branch - deve ser sempre liberável e apenas mesclado em
quando testamos e verificamos que tudo funciona e está
bom para ir.

O desenvolvimento diário é feito no ramo de desenvolvimento. Características,
correções de bugs e outras tarefas são feitas como ramificações do desenvolvimento,
em seguida, mesclado de volta ao desenvolvimento diretamente ou por meio de solicitações pull.

Mantenha os commits atômicos e autoexplicativos, use o rebase para limpar
até ramificações confusas antes de se fundir novamente no desenvolvimento.

## Ambiente de teste
```
Android Studio Chipmunk | 2021.2.1 Patch 1
dispositivo de teste: Android O (Google Pixel 2)
Certifique-se de que seu dispositivo tenha a versão Android >= 21.
```

## Tela Principal
> Aqui é Exibido os três botões iniciais para ir em diferentes pontos do App.
<img width="324" alt="Captura de Tela 2022-12-13 às 15 19 08" src="https://user-images.githubusercontent.com/26841238/207413620-e67762bf-f053-4f66-921d-e16a87380556.png">

## Pokedex
> Abre a câmera para ler o QRCode e exibir o pokemon.
<img width="324" alt="Captura de Tela 2022-12-13 às 15 20 58" src="https://user-images.githubusercontent.com/26841238/207414013-0dfdf24b-3977-4d37-9a8b-5902ff39fce0.png">

## Leitor
> Le Pokemon (Capturado hehe)
<img width="324" alt="Captura de Tela 2022-12-13 às 15 23 56" src="https://user-images.githubusercontent.com/26841238/207414597-ba2d7f28-e592-4a62-8b98-d3cc2cee7a50.png">

## Detalhe do Pokemon Lido
<img width="324" alt="Captura de Tela 2022-12-13 às 15 23 00" src="https://user-images.githubusercontent.com/26841238/207414413-85f27a51-85ac-424d-8570-6ee6c1e15df0.png">

## Lista os Pokemons
<img width="324" alt="Captura de Tela 2022-12-13 às 15 24 46" src="https://user-images.githubusercontent.com/26841238/207414748-ec0e8c56-2bf7-46e5-9a1f-3ade85d348db.png">
