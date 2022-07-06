# Troca de Mangás
## Projeto Final para a disciplina de Programação Web II do Instituto Federal do Rio Grande do Sul - Campus Porto Alegre
## Professor: Rodrigo Prestes Machado
### Alexandre de Mesquita Fabian e Mario Ceferino Ibanez Hancco

## Descrição do Negócio

Sistema de trocas onde os usuários podem criar um perfil, anunciar seus mangás, navegar pela lista de anúncios dos outros usuários, pesquisar o catálogo online, ver o status das suas trocas e avaliar outros usuários. Esse sistema deverá ser acessível através da web por um navegador padrão (website).

**Perfil**

Cada usuário será associado a um perfil. Com este perfil será possível criar vários anúncios, as avaliações recebidas, verificar o status das trocas e o seu histórico.

Os campos são os seguintes:
- nome de usuário;
- senha; 
- e-mail; 

**Anúncio**

Cada usuário pode criar vários anúncios, o qual deve conter as informações do mangá que deseja permutar. Um anúncio pode ter diversos comentários dos usuários interessados, podendo ser respondidos individualmente pelo anunciante.

Os campos são os seguintes:
- Foto do mangá;
- Nome do mangá;
- Capítulos contidos no mangá;
- Descrição do Anúncio;
- Mensagens (comentários)

**Mangá**

Cada Mangá terá suas informações retiradas da Jikan api (Unofficial MyanimeList API) do RapidAPI.

**Pesquisa na API**

Será possível pesquisar pelo nome do mangá utilizando a api Jikan e escolher da lista apresentada o mangá para adicionar ao anúncio.

**Avaliações**

Avaliações são feitas após o término de uma troca. Pode ser positiva, com 1,2,3,4 ou 5 estrelas ou negativa, com 0 estrelas. 

**Como uma troca ocorre:**
>- um usuário 1 cria um anúncio;
>- outro usuário 2 encontra o anúncio (pela pesquisa) e mostra interesse pelo mangá anunciado;
>- o usuário 1, dono do anúncio, verifica a lista de anúncios do interessado;
>- caso não encontre algo que quer, o usuário 1 recusa a troca;
>- caso encontre algo que quer, o usuário 1 informa o interesse pela troca;
>- o usuário 2 recebe a solicitação de troca e pode confirmar ou não;
>- caso a troca seja confirmada, o endereço dos usuários é mostrado e é possível a comunicação entre os usuários através de comentários;
>- A troca é realizada.

**Usuário Admin**

O sistema deve possuir um usuário admin com as seguintes características: além de todas as características de um usuário normal o admin deverá conseguir visualizar qualquer página, mesmo as que são privativas de outro usuário (página de edição de dados pessoais por exemplo). No perfil de cada usuário deverá haver um link visível apenas para o admin que possibilite banir este usuário, assim como desbanir se já estiver banido.

  O usuário admin poderá gerar relatórios.
  
## Implementação

### pw2-crud-projeto
Implementa um WS com persistência de dados utilizando Hibernate/Panache em um banco de dados MySQL.

### pw2-manga-api
Implementa um WS que acessa uma API não oficial do banco de dados MyAnimeList. Recebe uma query e devolve uma lista de resultados para a pesquisa.

### auth-user
Implementa um WS que recebe um nome e email e retorna um Token apropriado para Usuário ou Admin

### bff
Implementa um back-end for front-end que acessa os demais services. Implementa uma camada de autenticação, onde só é possivel acessar os endpoints com o token adequado (Usuário ou Admin)

### front
Front-end feito em Vue.js para demonstrar as funcionalidades dos services.

### Diagrama de Classes
![image](https://user-images.githubusercontent.com/16073346/177653074-244b6cea-d09a-4394-b606-11502b7139a7.png)


