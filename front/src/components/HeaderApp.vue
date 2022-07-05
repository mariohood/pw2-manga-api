<template>
     <nav>
      <div class="nav-wrapper blue darken-1">
        
      
        <a href="#" class="brand-logo center"> {{ nome }}</a>
         
      </div>
         
      <button @click="voltar" class="waves-effect waves-light btn-small">Logoff<i class="material-icons left"></i></button>
    </nav>

    
</template>

<script>
  export default{
    name: 'LoginComponente',
    data() {
      return {
        nome: "Troca Mangás"
      }
    },
    methods :{
       voltar(){
            this.$emit('retorno');

    }
    }
  }
</script>

<style scoped>
button {
  padding-right: 30px;
  position: absolute;
  right: 00;

}
</style>