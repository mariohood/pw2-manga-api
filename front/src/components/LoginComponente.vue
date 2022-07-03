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
        <p v-if="this.estado"> Texto de testa esta logado</p>
    </form>
  </div>
</template>

<script>
  import User from './services/test'  

  export default{
    name: 'LoginComponente',
    data() {
      return {
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
        if (this.name == "admin" && this.password == "admin") {
          console.log("Autenticado");
          this.$emit('autenticadoAdmin');
        }
      }
    },
   
     mounted(){

       User.list().then(resposta => {
            console.log(resposta)
        })
    }
 }
</script>

<style scoped>

</style>