<template>
     <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>
      <h4>Mangá Anunciado:</h4> 
      <table>
       <thead>
          <tr>
            <th>Imagem</th>
            <th>Titulo</th>
            <th>Capitulos</th>
            
          </tr>
        </thead>
        <tbody>
          <tr >
             <td>
                <table>
                <img :src="anuncio.manga.image_url" style="height: 100px;" @click="voltar">
                </table>
             </td>
            <td>{{anuncio.manga.title}}</td>
            <td>{{anuncio.manga.chapters}}</td>
           
           <td>
              
            </td>

          </tr>

        </tbody>
      
      </table>
       <h4>Descrição: </h4> <h5>{{anuncio.descricao}}</h5>
       <h4>Mensagens:</h4>
       <table>
          <thead>
            <tr>
            </tr>
          </thead>
          <tbody>
            <tr v-for="mensagem of anuncio.mensagens" :key="mensagem.id">
              <td>{{mensagem.texto}}</td>


            </tr>
          </tbody>
        </table>


       <button @click="enterAddMensagens()" class="waves-effect btn-large blue darken-1"><i class="material-icons">message</i></button>
<p></p>
      <div v-if="estado==1">
      <h5>Escreva sua mensagem:</h5>
      <label ></label>
            <input  type="text" placeholder="Digite aqui sua mensagem" v-model="texto">
            
            <button @click="enterPostar" class="tn-floating btn-small waves-effect waves-light blue">Postar<i class="material-icons left">note_add</i></button>
            </div>


<p></p>
     <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

</template>

<script>
import Anuncio  from '../services/test'  
  export default{
    name: 'ViewManga',
    data() {
      return {
        anuncio: [],
        id: 0,
        estado: 0,
        texto: "",
      }
    },
       methods: {
    voltar(){
           this.$emit('listAnuncios');
            },
    enterAddMensagens(){
      console.log("Enter Methodo Mensagens")
      this.estado = 1;
    },
    enterPostar(){
      console.log("Enter Methodo Postar Mensagens: "+this.anuncio.id)
      Anuncio.postarMensagem(this.anuncio.id, this.texto).then(resposta => {
        console.log("REsposta PostarMensagem "+resposta)
        alert("Sua mensagem foi postada com sucesso")
        this.estado = 0
         Anuncio.FindAnunciobyID(this.id).then(resposta => {
            console.log("REsposta FindbyAnuncio"+resposta)
            this.anuncio = resposta.data

          })
        this.$emit('viewManga')
      })
      
    }
    },


     created(){
          this.id = localStorage.getItem('idManga');
          console.log("Anuncio ID : "+ this.id);
          Anuncio.FindAnunciobyID(this.id).then(resposta => {
            console.log("REsposta FindbyAnuncio"+resposta)
            this.anuncio = resposta.data

          })

        
    },
  }
</script>
