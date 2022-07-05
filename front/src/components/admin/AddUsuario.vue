<template>
<h2>Criar novo usuário</h2>
    <div class="container">
      
      <form @submit.prevent="criar">
          <label>Login</label>
          <input type="text" placeholder="Login" v-model="login">
          <label>Email</label>
          <input type="text" placeholder="exemplo@email.com" v-model="email">
          <label>Senha</label>
          <input type="password" placeholder="****" v-model="password">

          <button class="waves-effect waves-light btn-small">Criar<i class="material-icons left">save</i></button>
          <p></p>
          <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

      </form>
    </div>
</template>

<script>
 import User from '../services/test'  

  export default{
    name: 'AddUsuario',
    data() {
      return {
        usuarios: [],
        login: '',
        password: '',
        email: ''
      }
    },
       methods: {
        criar(){
            User.criar(this.login, this.password, this.email).then(resposta => {
            console.log(resposta.data)
            alert("Criado usuario: " + this.login + " com sucesso");
            this.$emit('retorno');
        })
    },
    voltar(){
            this.$emit('retorno');

    }
    }
  }
</script>
