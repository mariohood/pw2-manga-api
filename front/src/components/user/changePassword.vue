<template>
<h2>Trocar senha</h2>
    <div class="container">
        {{ usuario.login }}
        {{ usuario.email }}
         {{ usuario.password }}
      <form @submit.prevent="verificar">
          <label>Digite sua senha antiga:</label>
          <input type="password" placeholder="Senha antiga" v-model="oldPassword">
          <label>Digite sua nova senha:</label>
          <input type="password" placeholder="*******" v-model="newPassword1">
          <label>Digite novamente sua nova senha:</label>
          <input type="password" placeholder="*******" v-model="newPassword2">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>
          <p></p>
          <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

      </form>
    </div>
</template>

<script>
 import User from '../services/test'  

  export default{
    name: 'ChangePassword',
    data() {
      return {
        usuario: [],
        id: 0,
        resposta: [],
        oldPassword: '',
        newPassword1: '',
        newPassword2: '',
      }
    },
       methods: {
       
       verificar(){
        if(this.oldPassword == this.usuario.password){
            if(this.newPassword1 == this.newPassword2){
                this.salvar();
            } else{ alert("Nova senha deve ser igual em ambos os formulários")}
        } else{ alert("Sua senha antiga não confere")}
            
    },

       salvar(){
        console.log("SALVAR");
        User.update(this.id, this.usuario.login, this.newPassword1, this.usuario.email).then(resposta =>{
            alert("Trocada a senha do usuario " + this.usuario.login + " com sucesso");
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
