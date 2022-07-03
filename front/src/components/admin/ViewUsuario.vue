<template>
<h2>VISUALIZAR usuário</h2>
    

     <table>
       <thead>
          <tr>
            <th>Login</th>
            <th>Email</th>
            <th>Administrador</th>
            <th>Anúncios</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          <tr >
            <td>{{ this.id }}</td>
            <td>{{ this.email }}</td>
            <td>{{ this.admin }}</td>
            <td>
              <button @click="listAnuncios()" class="waves-effect btn-small grey darken-1"><i class="material-icons">find_in_page</i></button>
            </td>
            <td>
                {{ this.anuncios }}
            </td>

          </tr>

        </tbody>
      
      </table>
     <button @click="voltar" class="waves-effect waves-light btn-small">Voltar<i class="material-icons left">arrow_back</i></button>

</template>

<script>
 import User from '../services/test'  

  export default{
    name: 'ViewUsuario',
    data() {
      return {
        usuario: [],
        usuarios: [],
        login: '',
        password: '',
        email: '',
        admin: false,
        id: '',
        anuncios: []
      }
    },
       methods: {
       
       listAnuncios() {
        console.log("Method Anuncio");
        this.$emit('listarAnuncios');
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

     created(){

       User.list().then(resposta => {
            console.log(resposta)
            this.usuarios = resposta.data   
            for(this.usuario of this.usuarios){
                 console.log("entrou no for")
                 if(this.usuario.id == localStorage.getItem('idView')){
                    console.log("entrou no if")
                    console.log(this.usuario.id)
                    console.log(localStorage.getItem('idView'))
                    console.log(this.id)
                    this.id = this.usuario.id
                    console.log(this.id)
                    this.login = this.usuario.login
                    this.email = this.usuario.email
                    this.admin = this.usuario.admin
                    this.anuncios = this.usuario.anuncios
                 }
            }
            console.log(this.id)
            console.log(this.login)
            console.log(this.email)
            console.log(this.admin)


        })
    },
  }
</script>
