<template>
    <div >
        <HomeAdminVue @add-usuario="addUsuario" @edit-usuario="editUsuario" @view-usuario="viewUsuario" v-if="estado == 0"/>
        <AddUsuarioVue @retorno="retorno"  v-if="estado == 2"/>
        <EditUsuarioVue @autenticado-admin="autAdmin" v-if="estado == 3"/>
        <ViewUsuarioVue @autenticado-admin="autAdmin" @listar-anuncios="listAnuncios" v-if="estado == 4"/>
        <ViewAnunciosVue @view-usuario="viewUsuario" @view-Manga="viewManga" v-if="estado == 5"/>
        <ViewMangaVue @list-anuncios="listAnuncios" v-if="estado == 6" />
    </div>
</template>

<script>
  import HomeAdminVue from './HomeAdmin.vue'
  import AddUsuarioVue from './AddUsuario.vue'
  import EditUsuarioVue from './EditUsuario.vue'
  import ViewUsuarioVue from './ViewUsuario.vue'
  import ViewAnunciosVue from '../views/ViewAnuncios.vue'
  import ViewMangaVue from '../views/ViewManga.vue'

export default {
    name: 'AdminCycle',
    data() {
        return {
            estado: 0,
        }
    },
   methods: {

        viewManga(){
            console.log("Manga View no AdminCycle")
            this.estado = 6
        },
        listAnuncios(){
            console.log("Anuncio View no AdminCycle")
            this.estado = 5
        },
        viewUsuario(){
            console.log("User View no AdminCycle")
            this.estado = 4
        },
        addUsuario() {
            console.log("Add no AdminCycle")
            this.estado = 2
        },
        editUsuario() {
            console.log("Edit no AdminCycle")
            this.estado = 3
        },
         autAdmin() {
            console.log("de volta ao AdminCycle")
            this.estado = 0
        },
        retorno() {
            console.log("de volta ao AdminCycle")
            this.estado = 0
        },

   },
  
    components: {
        HomeAdminVue,
        AddUsuarioVue,
        EditUsuarioVue,
        ViewUsuarioVue,
        ViewAnunciosVue,
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