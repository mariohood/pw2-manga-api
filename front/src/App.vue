<template>
<header><HeaderAppVue @retorno="retorno"/> </header>

  <main>
    <LoginScreenVue  @autenticado="autenticado" @enter-cadastrar="enterCadastrar" v-if="AppEstado == 0 " />
    <AuthAppVue  @authUser="autUser" @authAdmin="autAdmin" v-if="AppEstado == 1" />
    <AddUsuarioVue  @retorno="retorno" @authAdmin="autAdmin" v-if="AppEstado == 4" />
    <AdminCycleVue v-if="AppEstado == 2 " />
    <UserCycleVue v-if="AppEstado == 3 "/>
  </main>

  <footer><FooterAppVue /></footer>
</template>


<script>

  import HeaderAppVue from './components/HeaderApp.vue'
  import LoginScreenVue from './components/login/LoginScreen.vue'
  import AuthAppVue from './components/login/AuthApp.vue'
  import AdminCycleVue from './components/admin/AdminCycle.vue'
  import UserCycleVue from './components/user/UserCycle.vue'
  import AddUsuarioVue from './components/admin/AddUsuario.vue'
  import FooterAppVue from './components/FooterApp.vue'
  
  export default{
    name: 'App',
    data(){
      return {
        AppEstado: 0
      }
    },
    methods: {

        autenticado() {
            console.log("Autenticado no AppVue")
            console.log("localStorage Lifeid: "+localStorage.getItem('token'));
            this.AppEstado = 1
        },


       autAdmin() {
            console.log("Autenticado no AdminCycle")
            console.log("localStorage Lifeid: "+localStorage.getItem('token'));
            this.AppEstado = 2
        },

      autUser() {
            console.log("Autenticado no UserCycle")
            console.log("localStorage Lifeid: "+localStorage.getItem('token'));
            this.AppEstado = 3
        },
        retorno() {
            console.log("de volta ao Login")
            this.AppEstado = 0
        },
        enterCadastrar() {
            console.log("Cadastrar user")
            this.AppEstado = 4
        },
    },
    components: {
    HeaderAppVue,
    LoginScreenVue,
    AuthAppVue,
    AdminCycleVue,
    UserCycleVue,
    AddUsuarioVue,
    FooterAppVue
}
  }
</script>

<style>


</style>
