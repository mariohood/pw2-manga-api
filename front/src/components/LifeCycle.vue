<template>
    <div >
        <HomeAdminVue @add-usuario="addUsuario" @edit-usuario="editUsuario" v-if="estado == 1"/>
        <LoginComponenteVue @autenticado-admin="autAdmin" v-if="estado == 0"/>
        <AddUsuarioVue @autenticado-admin="autAdmin" v-if="estado == 2"/>
        <EditUsuarioVue @autenticado-admin="autAdmin" v-if="estado == 3"/>
    </div>
</template>

<script>
  import LoginComponenteVue from './LoginComponente.vue'
  import HomeAdminVue from './HomeAdmin.vue'
  import AddUsuarioVue from './AddUsuario.vue'
  import EditUsuarioVue from './EditUsuario.vue'

export default {
    name: 'LifeCycle',
    data() {
        return {
            estado: 0,
        }
    },
   methods: {
        autAdmin() {
            console.log("Autenticado no LifeCycle")
            this.estado = 1
        },
        addUsuario() {
            console.log("Add no LifeCycle")
            this.estado = 2
        },
        editUsuario() {
            console.log("Edit no LifeCycle")
            this.estado = 3
        },

   },
  
    components: {
        LoginComponenteVue,
        HomeAdminVue,
        AddUsuarioVue,
        EditUsuarioVue
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