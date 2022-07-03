<template>
    <div >
     <h3>Bem vindo, {{login}}, a sua página Inicial</h3>
     <h3> {{usuario.id}} {{usuario.login}} {{usuario.password}} {{usuario.email}}</h3>
     <p>{{usuario.anuncios}}</p>
     <table>
       <thead>
          <tr>
            <th>Login</th>
            <th>Email</th>
            <th>Password</th>
            <th>Anúncios</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          <tr >
            <td>{{ this.usuario.id }}</td>
            <td>{{ this.usuario.email }}</td>
            <td>{{ this.usuario.password }}</td>
            <td>
              <button @click="listAnuncios()" class="waves-effect btn-small grey darken-1"><i class="material-icons left">find_in_page</i></button>
            </td>
            <td>
                {{ this.usuario.anuncios }}
            </td>

          </tr>

        </tbody>
      
      </table>
      <div></div>
     <button @click="adicionar" class="waves-effect waves-light btn-small">Adicionar Anúncio<i class="material-icons left">save</i></button>

    </div>
</template>

<script>
  
import User from '../services/test'  

export default {
    name: 'HomeUser',
    data() {
        return {
            estado: 0,
            login: 'vazio',
            usuario: []
        }
    },
   methods: {

     adicionar(){
          console.log("Add usuario");
          this.$emit('addAnuncio');
        },

    listAnuncios() {
        console.log("Method Anuncio");
        this.$emit('listarAnuncios');
       },
   },
      
    mounted(){
        this.login=localStorage.getItem('login');
        console.log("usercycle: "+ this.login);
        console.log(localStorage.getItem('idLogado'));
        this.id_logado=localStorage.getItem('idLogado');
        localStorage.setItem('idView', this.id_logado);
        User.findbyID(this.id_logado).then(resposta => {
            console.log(resposta);
            this.usuario = resposta.data;
       })
      

   },
  
    components: {
      
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