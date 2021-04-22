<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <div @click="goCreate">aaaa</div>
    <div @click="goHello">bbbb</div>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import {request} from '@/api/index'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  methods: {
    goCreate() {
      request({
        url: '/as/created',
      }).then((response) =>{
        console.log(response);
      })
    },
    goHello() {
      request({
        url: '/as/hello',
      }).then((response) => {
        console.log(response);
      })
    }
  }
}
</script>
