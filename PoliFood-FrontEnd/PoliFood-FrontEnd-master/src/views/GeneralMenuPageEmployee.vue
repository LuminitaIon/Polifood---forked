<template>
<!--  <v-app>-->
    <div id="menu_page" class="menu-page">
      <h1>{{ $store.state.cafeteria_name }}</h1>
      <br /><br /><br />
      <general-menu-employee id="general-menu" />
    </div>
<!--  </v-app>-->
</template>

<script>
import GeneralMenuEmployee from "./GeneralMenuEmployee.vue";

export default {
  el: "#menu_page",

  components: {
    GeneralMenuEmployee
  },

  props: {
    menu_items: [
      {
        id: Number,
        name: String,
        quantity: Number,
        quantity_type: String,
        price: Number
      }
    ]
  },

  data: () => ({
    cafeteria_name: localStorage.getItem("cafeteria_name")
  }),
  beforeCreate() {
    this.$store.state.cafeteria_name = localStorage.getItem("cafeteria_name");
  }
};
</script>

<style>
.menu-page {
  top: 0;
  bottom: 0;
  height: 100%;
  padding-top: 30px;
}

#general-menu {
  width: 60%;
  margin: auto;
}
</style>
