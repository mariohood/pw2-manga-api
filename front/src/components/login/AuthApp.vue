<template>
  <div>
    <h1>Home {{ admin }}</h1>
    <table>
       <thead>
          <tr>
            <th>Login</th>
            <th>Email</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="usuario of usuarios" :key="usuario.id">
            <td>{{ usuario.login }}</td>
            <td>{{ usuario.email }}</td>
            <td>admin:  {{ usuario.admin }}</td>
           

          </tr>

        </tbody>
      
      </table>
     <button @click="enviarFormulario" class="waves-effect waves-light btn-small">Adicionar Usuário<i class="material-icons left">save</i></button>

      <button @click="editar" class="waves-effect waves-light btn-small">Editar Usuário<i class="material-icons left">save</i></button>
  </div>
</template>

<script>
  import User from '../services/test'  

  export default{
    name: 'AuthApp',
    data() {
      return {
        usuarios: [],
        nome: "Admin",
        edit: false
      }
    },
    methods: {
      enviarFormulario(){
          console.log("Add usuario");
          this.$emit('addUsuario');
        },
      editar(){
         console.log("Edit usuario");
          this.$emit('editUsuario');
      }  
    },
       mounted(){

       User.list().then(resposta => {
            console.log("MOUNTED"+resposta)
            this.usuarios = resposta.data
            console.log("MOUNTED login: " +localStorage.getItem('login'))
            for(this.usuario of this.usuarios){
                console.log("MOUNTED usuarios: " + this.usuario.login)
                if(this.usuario.login == localStorage.getItem('login')){
                    localStorage.setItem('idLogado', this.usuario.id)
                    if (this.usuario.admin) {
                        console.log("usuario "+this.usuario.login+" é admin")
                        this.$emit('authAdmin')
                    } else {console.log("usuario "+this.usuario.login+" NAO é admin")
                        this.$emit('authUser')
                    }
                    
                }

            }
        })
       
    },
    
  
  }
</script>