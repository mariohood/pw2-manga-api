<template>
    <div >
     <h3>Bem vindo, {{login}}</h3>
     <table>
      <thead>
        <tr>
          <th>Usuário</th>
          <th>Opções</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
                    <table>
                      <thead>
                          <tr>
                            <th>Login</th>
                            <th>Email</th>
                            <th>Anúncios</th>
                            
                          </tr>
                        </thead>
                        <tbody>
                          <tr >
                            <td>{{ this.usuario.login }}</td>
                            <td>{{ this.usuario.email }}</td>
                            <td>
                              <button @click="listAnuncios()" class="waves-effect btn-small blue darken-1">Ver <i class="material-icons left">find_in_page</i></button> <p>

                              </p>
                                    <button @click="adicionar" class="waves-effect waves-light btn-small">Adicionar<i class="material-icons left">save</i></button>

                            </td>
                            

                          </tr>

                        </tbody>
                      
                      </table>
                </td>
          <td>
            <p>
            <button @click="enterEditProfile()" class="waves-effect btn-small grey darken-1">Editar dados do usuário<i class="material-icons left">edit</i></button>
             </p><p>
            <button @click="enterChangePassword()" class="waves-effect btn-small grey darken-1">Editar Senha<i class="material-icons left">https</i></button>
             </p><p>
</p>
          </td>
        </tr>      
          </tbody>
      </table>
     
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
         localStorage.setItem('idView', this.usuario.id);
         console.log("USUARIO ID " +this.usuario.id);
        this.$emit('listarAnuncios');
       },
       enterEditProfile() {
        console.log("Method EditProfile");
        this.$emit('enterEditProfile');
       },
    enterChangePassword() {
        console.log("Method ChangePassword");
        this.$emit('enterChangePassword');
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