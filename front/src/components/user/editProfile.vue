<template>
<h2>Editar meus dados</h2>
    <div class="container">
        {{ usuario.login }}
        {{ usuario.email }}
         {{ usuario.password }}
      <form @submit.prevent="salvar">
          <label>Login</label>
          <input type="text" placeholder="Login" v-model="usuario.login">
          <label>Email</label>
          <input type="text" placeholder="exemplo@email.com" v-model="usuario.email">
          

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>
          <p></p>
          <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

      </form>
    </div>
</template>

<script>
 import User from '../services/test'  

  export default{
    name: 'EditProfile',
    data() {
      return {
        usuario: [],
        id: 0,
        resposta: [],
      }
    },
       methods: {
       
       salvar(){
        console.log("SALVAR");
        User.update(this.id, this.usuario.login, this.usuario.password, this.usuario.email).then(resposta =>{
            alert("Atualizado usuario " + this.usuario.login + " com sucesso");
            console.log(resposta)
            this.voltar();

        })
        
       },
    
    voltar(){
            this.$emit('retorno');
    }
    },

    mounted(){
        console.log("mounted editProfile - id: " +this.id);
        this.id = localStorage.getItem('idLogado')
        console.log("mounted editProfile - idLogado: " +this.id);
        User.findbyID(this.id).then(resposta => {
            console.log(resposta)
            this.usuario = resposta.data   
        })
    },
  }
</script>
