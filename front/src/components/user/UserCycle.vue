<template>
    <div >
     <HomeUserVue @listar-anuncios="listAnuncios" @enter-change-password="enterChangePassword" @enter-edit-profile="enterEditProfile" @add-anuncio="addAnuncio" v-if="estado ==0" />
     <ViewAnunciosVue v-if="estado ==1" @view-manga="viewManga" @view-usuario="retorno"/>
    <addAnuncioVue v-if="estado ==2" @retorno="retorno"/>
    <editProfileVue v-if="estado ==3" @retorno="retorno"/>
     <changePasswordVue v-if="estado ==4" @retorno="retorno"/>
     <ViewMangaVue v-if="estado ==5" @list-anuncios="listAnuncios" @add-mensagens="addMensagens"/>

    </div>
</template>

<script>
  
import User from '../services/test'  
import HomeUserVue from './HomeUser.vue'
import ViewAnunciosVue from '../views/ViewAnuncios.vue'
import addAnuncioVue from './addAnuncio.vue'
import editProfileVue from './editProfile.vue'
import changePasswordVue from './changePassword.vue'
import ViewMangaVue from '../views/ViewManga.vue'


export default {
    name: 'UserCycle',
    data() {
        return {
            estado: 0,
            login: 'vazio',
            id_logado: 0,
        }
    },
    methods: {
        addAnuncio(){
            console.log("Anuncio add no userCycle")
            this.estado = 2
        },
        listAnuncios(){
            console.log("Anuncio View no userCycle")
            this.estado = 1
        },
        retorno(){
            console.log("de volta User cycle")
            this.estado = 0;
        },
        enterEditProfile(){
            console.log("EditProfile no userCycle")
            this.estado = 3;
        },
        enterChangePassword(){
            console.log("ChangePassword no userCycle")
            this.estado = 4;
        },
        viewManga(){
            console.log("View Manga no userCycle")
            this.estado = 5;
        },
         addMensagens(){
            console.log("Add Mensagens no userCycle")
            this.estado = 6;
        }


   },
      
    mounted(){
        this.login=localStorage.getItem('login');
        console.log("usercycle: "+ this.login)
        console.log(localStorage.getItem('idLogado'))
        localStorage.setItem('idView', this.id_logado)
        this.id_logado=localStorage.getItem('idLogado')
        User.findbyID(this.id_logado).then(resposta => {
            console.log(resposta);
       })
      

   },
  
    components: {
        HomeUserVue,
        ViewAnunciosVue,
        addAnuncioVue,
        editProfileVue,
        changePasswordVue,
        ViewMangaVue
      
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