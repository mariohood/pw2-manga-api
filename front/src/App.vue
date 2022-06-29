<template>
  <HeaderAppVue />
  <LifeCycleVue />
  <FooterAppVue />
</template>


<script>

  import HeaderAppVue from './components/HeaderApp.vue'
  import LifeCycleVue from './components/LifeCycle.vue'
  import FooterAppVue from './components/FooterApp.vue'
  
  export default{
    name: 'App',
    components: {
    HeaderAppVue,
    LifeCycleVue,
    FooterAppVue
}
  }
</script>

<style>


</style>
