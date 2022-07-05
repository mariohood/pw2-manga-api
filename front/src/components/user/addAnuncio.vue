<template>
<h2>Criar novo anúncio</h2>
    <div class="container">
        {{ login }}
        {{ email }}
        {{ password }}
      <form @submit.prevent="">
            <label>Descrição</label>
            <input type="text" placeholder="Escreva uma descrição do anúncio" v-model="desc">
            <div></div>
            <button @click="addManga" class="tn-floating btn-large waves-effect waves-light green">Add Mangá<i class="material-icons left">add</i></button>
            <div v-if="estado==(1||2)"> 
            <label >Pesquise pelo nome</label>
            <input  type="text" placeholder="Digite o nome do mánga aqui" v-model="nome_manga">
            
            <button @click="pesquisarManga" class="tn-floating btn-large waves-effect waves-light green">Pesquisar<i class="material-icons left">search</i></button>
            </div>
            <div v-if="estado==2" >
              <p>Resultado da pesquisa:</p> 
              <table>
                <thead>
                  <tr>
                    <th>Imagem</th>
                    <th>Titulo</th>
                    <th>Capitulos</th>
                    <th>add</th>
                  </tr>
                </thead>
              <tbody>
                <tr v-for="manga of mangas" :key="manga.id">
                  <td><img :src="manga.image_url" style="height: 150px;"></td>
                  <td>{{ manga.title }}</td>
                  <td>{{ manga.chapters }}</td>
                  <td>
                    <button @click="addMangaAnuncio(manga)" class="waves-effect btn-small blue darken-1"><i class="material-icons">add</i></button>
                  </td>
                </tr>
              </tbody>
      
              </table>
            </div>
            <div v-if="estado==(3||4)"> <h1>ADD MANGA {{mal_id}}</h1>
                <table>
                <thead>
                  <tr>
                    <th>Imagem</th>
                    <th>Titulo</th>
                    <th>Capitulos</th>
                    <th></th>
                  </tr>
                </thead>
              <tbody>
                <tr>
                  <td><img :src="manga.image_url" style="height: 150px;"></td>
                  <td>{{ manga.title }}</td>
                  <td>{{ manga.chapters }}</td>
                  <td>
                  </td>
                </tr>
              </tbody>
      
              </table>
            
            </div>
             <div></div>
             <p></p>
            <button @click="criar" class="waves-effect waves-light btn-small">Criar Anúncio<i class="material-icons left">save</i></button>
            <div></div>
            <h3 v-if="estado==4">Anúncio Criado</h3>
           <p></p>
            <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

      </form>
    </div>
</template>

<script>
import Manga from '../services/test'

  export default{
    name: 'addAnuncio',
    data() {
      return {
        estado: 0,
        desc: '',
        id_manga: 0,
        mangas: [],
        manga: [],
        nome_manga: ''
      }
    },
       methods: {

        addMangaAnuncio(manga){
          this.estado = 3
          this.manga = manga

        },
        criar(){
          console.log("antes de criar mangá: " + this.manga.title + this.manga.image_url)
          Manga.criarManga(this.manga).then(resposta => {
            console.log("RESPOSTA MANGA"+resposta)
            console.log("manga resp: "+resposta.data.mal_id)
            this.id_manga = resposta.data.id
            console.log("manga resp ID: "+resposta.data.id)
            console.log("manga resp ID: "+this.id_manga)
            Manga.criarAnuncio(this.desc, this.id_manga).then(resposta => {
              console.log("RESPOSTA ANUNCIO"+resposta)
              alert("Anúncio criado com sucesso")
              this.voltar()
          })
          })
          
    },
        voltar(){
            this.$emit('retorno');

    },
        addManga(){
           this.estado = 1
    },
     pesquisarManga(){
        console.log("query: "+this.nome_manga)
        Manga.pesquisarManga(this.nome_manga).then(resposta => {
          console.log(resposta)
          this.mangas = resposta.data.results
        })
        
           this.estado = 2
    },
    }
  }
</script>
