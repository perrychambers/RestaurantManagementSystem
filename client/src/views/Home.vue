<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to the Restaurant Management System"/>
    <p>Create a menu item under the new Recipe tab, that recipe can be added to a cart or removed.</p>
    <p>There are more API endpoints for each the recipe and order items that still need to be implemented.</p>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
