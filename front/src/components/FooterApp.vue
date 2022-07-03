<template>
  <div  id="footer">
    <p>     ©  App feito por  {{ nome1 }} e {{ nome2 }}</p>
  </div>
</template>

<script>


  export default{
    name: 'FooterApp',
    data() {
      return {
        nome1: "Alexandre Fabian",
        nome2: "Mario Ibanez"
      }
    },
    

  }
</script>

<style scoped>
  #footer {
    height: 100px;
    background-color: whitesmoke;
    color: grey;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    bottom: 0;
    width: 100%;
  }
</style>