<template>
  <div  id="footer">
    <p>       App feito por  {{ nome1 }} e {{ nome2}}</p>
  </div>
</template>

<script>


  export default{
    name: 'FooterApp',
    data() {
      return {
        nome1: "Alexandre de Mesquita Fabian",
        nome2: "Mario Ibanez"
      }
    },
    

  }
</script>

<style scoped>
  #footer {
    height: 200px;
    background-color: #222;
    border-top: 4px solid #111;
    color: #fcba03;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    bottom: 0;
    width: 100%;
  }
</style>