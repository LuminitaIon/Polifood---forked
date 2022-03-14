<template>
<!--  <div id="app">-->
    <v-app id="app">
    <UserMenuBar v-if="$store.state.role === 'USER'" />
    <AdminMenuBar v-else-if="$store.state.role === 'ADMIN'" />
    <EmployeeMenuBar v-else-if="$store.state.role === 'CAFETERIA'" />
    <router-view />
    </v-app>
<!--  </div>-->
</template>

<script>
import AdminMenuBar from "./views/AdminMenuBar";
import EmployeeMenuBar from "./views/EmployeeMenuBar";
import UserMenuBar from "./views/UserMenuBar";
export default {
  name: "App",
  components: {
    AdminMenuBar,
    EmployeeMenuBar,
    UserMenuBar
  },
  data: () => ({
    role: localStorage.getItem("role")
  }),
  methods: {},
  beforeCreate() {
    this.$store.state.role = localStorage.getItem("role");
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: orange;
  margin: auto;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  position: absolute;
}
</style>
