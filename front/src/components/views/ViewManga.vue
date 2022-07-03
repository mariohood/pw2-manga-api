<template>
<h2>VISUALIZAR MANGA {{mal_id}}</h2>
    
     <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

</template>

<script>

  export default{
    name: 'ViewManga',
    data() {
      return {
        anuncios: [],
        mal_id: 0,
      }
    },
       methods: {
    voltar(){
           this.$emit('listarAnuncios');
            }
    },

     created(){
        this.mal_id = localStorage.getItem('idManga');
        console.log("MyAnimeList ID : "+ this.mal_id)
        
    },
  }
</script>
