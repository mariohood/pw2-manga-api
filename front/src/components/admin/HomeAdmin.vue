<template>
  <div>
    <h2>Painel de Controle do Administrador: {{loginAdmin}}</h2>
    <table>
       <thead>
          <tr>
            <th>Login</th>
            <th>Email</th>
            <th>Administrador</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="usuario of usuarios" :key="usuario.id">
            <td>{{ usuario.login }}</td>
            <td>{{ usuario.email }}</td>
            <td>admin:  {{ usuario.admin }}</td>
           <td>
              <button @click="view(usuario)" class="waves-effect btn-small blue darken-1"><i class="material-icons">pageview</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>
     <button @click="adicionar" class="waves-effect waves-light btn-small">Adicionar Usuário<i class="material-icons left">save</i></button>

      <button @click="editar" class="waves-effect waves-light btn-small">Editar Usuário<i class="material-icons left">edit</i></button>
  </div>
</template>

<script>
import User from '../services/test'  

  export default{
    name: 'HomeAdmin',
    data() {
      return {
        usuarios: [],
        nome: "Admin",
        loginAdmin: "",
        edit: false
      }
    },
    methods: {

      view(usuario) {
       console.log("ID do usuario a visualizar: "+usuario.id);
        localStorage.setItem('idView', usuario.id);
        console.log(localStorage.getItem('idView'))
        this.$emit('viewUsuario');
       },
      adicionar(){
          console.log("Add usuario");
          this.$emit('addUsuario');
        },
      editar(){
         console.log("Edit usuario");
          this.$emit('editUsuario');
      }  
    },
    mounted(){
      this.loginAdmin = localStorage.getItem('login');
      User.list().then(resposta => {
            console.log(resposta)
            this.usuarios = resposta.data   
        })
    },
    
  
  }
</script>