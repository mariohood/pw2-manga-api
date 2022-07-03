<template>
<h2>Editar usuário</h2>
    <div class="container">
        {{ login }}
        {{ email }}
        {{ password }}
      <form @submit.prevent="salvar">
          <label>Login</label>
          <input type="text" placeholder="Login" v-model="login">
          <label>Email</label>
          <input type="text" placeholder="exemplo@email.com" v-model="email">
          <label>Senha</label>
          <input type="password" placeholder="****" v-model="password">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>
          <p></p>
          <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

      </form>
    </div>

     <table>
       <thead>
          <tr>
            <th>Login</th>
            <th>Email</th>
            <th>Administrador</th>
            <th>OPÇÕES</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="usuario of usuarios" :key="usuario.id">
            <td>{{ usuario.login }}</td>
            <td>{{ usuario.email }}</td>
            <td>admin:  {{ usuario.admin }}</td>
            <td>
              <button @click="editar(usuario)" class="waves-effect btn-small blue darken-1"><i class="material-icons">edit</i></button>
              <button @click="deletar(usuario)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>
</template>

<script>
 import User from '../services/test'  

  export default{
    name: 'EditUsuario',
    data() {
      return {
        usuarios: [],
        login: '',
        password: '',
        email: '',
        id: 0
      }
    },
       methods: {
       
       editar(usuario) {
        this.id = usuario.id;
        this.login = usuario.login;
        this.password = usuario.password;
        this.email = usuario.email;
       },
       salvar(){
        console.log("SALVAR");
        User.update(this.id, this.login, this.password, this.email);
        alert("Atualizado usuario: " + this.login + " com sucesso");
        this.voltar();
       },
    
        deletar(usuario){
            this.id = usuario.id;
            User.deletar(this.id);
            alert("Deletado usuario: " + usuario.login + " com sucesso")
            this.voltar();
        },
    voltar(){
            this.$emit('autenticadoAdmin');

    }
    },

     mounted(){

       User.list().then(resposta => {
            console.log(resposta)
            this.usuarios = resposta.data   
        })
    },
  }
</script>
