<template>
    <Slide isOpen noOverlay>
      <UserPage/>
      <a style="text-decoration: none; white-space: nowrap;" href="/">
        <span>Acasa</span>  
      </a>
      <a style="text-decoration: none; white-space: nowrap;" href="/generalMenuPage">
        <span>Meniul Cantinei</span>  
      </a>
      <a style="text-decoration: none; white-space: nowrap;" href="/dailyMenus">
        <span>Meniuri Zilnice</span>  
      </a>
      <a style="text-decoration: none; white-space: nowrap;" href="/orderTableEmployee">
        <span>Comenzi</span>  
      </a>
      <a style="text-decoration: none;" href="#" v-on:click="logout()">
        <span>Logout</span>
      </a>
    </Slide>
</template>

<script>

import { Slide } from 'vue-burger-menu'
import UserPage from "./UserPage";

export default ({
    name: "EmployeeMenuBar",
    components: {
        Slide,
      UserPage
    },
    methods: {
      logout: function() {
        this.$store.dispatch("logout",{});
        this.$router.go();
      }
    }
})
</script>

<style>

.bm-menu {
    height: 100%; /* 100% Full-height */
    width: 0; /* 0 width - change this with JavaScript */
    position: fixed; /* Stay in place */
    z-index: 1000; /* Stay on top */
    top: 0;
    left: 0;
    background-color: #ffff00;/*#bd711b;*/
    overflow-x: hidden; /* Disable horizontal scroll */
    padding-top: 60px; /* Place content 60px from the top */
    transition: 0.5s; /*0.5 second transition effect to slide in the sidenav*/
}

</style>
