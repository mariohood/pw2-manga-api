<template>
    <div>
        <h2>VISUALIZAR ANUNCIOS</h2>
    <table>
       <thead>
          <tr>
            <th>Anuncio</th>
            <th>Descricao</th>
            <th>Manga</th>
            
          </tr>
        </thead>
        <tbody>
          <tr v-for="anuncio of this.anuncios" :key="anuncio.id">
             <td><img :src="anuncio.manga.image_url" style="height: 100px;">}</td>
            <td>{{anuncio.manga.title}}</td>
            <td>{{ anuncio.descricao }}</td>
           
           <td>
              <button @click="viewManga(anuncio.manga.mal_id)" class="waves-effect btn-small blue darken-1"><i class="material-icons">pageview</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

        <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

    </div>
</template>

<script>
 import User from '../services/test'  

  export default{
    name: 'ViewAnuncios',
    data() {
      return {
        cont: 0,
        usuario: [],
        usuarios: [],
        anuncios: [],
        anuncio: []
      }
    },
       methods: {
       
       listAnuncios() {
        console.log("Method Anuncio");
        this.$emit('listarAnuncios');
       },
       
       viewManga(mid){
        console.log("Methodo View Manga")
        console.log("Manga id: " +mid);
        localStorage.setItem('idManga', mid);
        this.$emit('viewManga');
       },
     
        deletar(usuario){
            this.id = usuario.id;
            User.deletar(this.id);
            alert("Deletado usuario: " + usuario.login + " com sucesso")
            this.voltar();
        },
    voltar(){
            this.$emit('viewUsuario');

    }
    },

     created(){

       User.list().then(resposta => {
        console.log("VIEW")
            console.log(resposta)
            console.log("view " +localStorage.getItem('idView'))
            this.usuarios = resposta.data
            for(this.usuario of this.usuarios){
                 if(this.usuario.id == localStorage.getItem('idView')){
                    this.anuncios = this.usuario.anuncios
                }
            }
        })
    },
  }
</script>
