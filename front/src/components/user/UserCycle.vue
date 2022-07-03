<template>
    <div >
     <HomeUserVue @listar-anuncios="listAnuncios" @add-anuncio="addAnuncio" v-if="estado ==0" />
     <ViewAnunciosVue v-if="estado ==1" @view-usuario="retorno"/>
    <addAnuncioVue v-if="estado ==2" @retorno="retorno"/>

    </div>
</template>

<script>
  
import User from '../services/test'  
import HomeUserVue from './HomeUser.vue'
import ViewAnunciosVue from '../views/ViewAnuncios.vue'
import addAnuncioVue from './addAnuncio.vue'

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
            console.log("Anuncio add no AdminCycle")
            this.estado = 2
        },
        listAnuncios(){
            console.log("Anuncio View no AdminCycle")
            this.estado = 1
        },
        retorno(){
            console.log("de volta User cycle")
            this.estado = 0;
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
        addAnuncioVue
      
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