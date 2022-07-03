<template>
  <div>
    <h3>Login:</h3>
    <form action="" @submit="enviarFormulario($event)">
        <div>
            <label center>Login</label>
            <input type="text" v-model="name" placeholder="Insira seu login aqui">
        </div>
        <div>
            <label>Senha</label>
            <input type="password" v-model="password" placeholder="*********">
        </div>
       
        <div>
              <input type="submit" value="Enviar">
        </div>
        <p v-if="this.estado"> Texto de test esta logado</p>
    </form>
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
        }
    }
        
 }
</script>

<style scoped>

</style>