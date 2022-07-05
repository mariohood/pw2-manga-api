<template>
  <div>
    <h3>Login:</h3>
    <form action="" @submit="enviarFormulario($event)">
        <div>
            <label center>Login</label>
            <input type="text" v-model="name" placeholder="Insira seu login aqui">
       
            <label>Senha</label>
            <input type="password" v-model="password" placeholder="*********">
        
              <input type="submit"  class="waves-effect waves-light btn-large" value="Enviar">
        </div>
        
    </form>
    
    

        <button @click="enterCadastrar" class="waves-effect waves-light btn-small">Cadastrar novo usuário<i class="material-icons left">add</i></button>

       
  </div>
</template>

<script>
  let token = '';
  import User from '../services/test'  

  export default{
    name: 'LoginScreen',
    data() {
      return {
        usuarios: [],
        name: "",
        password: "",
        estado: "0"
      }
    },

    methods : {
        enviarFormulario(e){
            e.preventDefault();
            console.log(this.name);
            console.log(this.password);
            token = 'teste';
            console.log(token);
           
            User.login(this.name, this.password).then(resposta => {
                localStorage.setItem('token', resposta.data);
                localStorage.setItem('login', this.name);
               
                console.log("localStorage SCREEN LOGIN: "+localStorage.getItem('login'));
                console.log("localStorage SCREEN TOKEN: "+localStorage.getItem('token'));
                console.log("Autenticado");
                this.$emit('autenticado');
            })
        },
        enterCadastrar(){
          this.$emit('enterCadastrar')
        }
    }
        
 }
</script>

<style scoped>
div {
  padding-top: 50px;
  padding-right: 30px;
  padding-bottom: 50px;
  padding-left: 30px;
}
</style>