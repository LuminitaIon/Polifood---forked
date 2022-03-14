<template>
  <div id="grid">
    <v-row dense align-content="center">
      <v-col cols="5" md="6" v-for="item in items" :key="item.name">
      <v-card
        :loading="loading"
        class="mx-auto my-12"
        max-width="374"
        @click="reserve(item.name)"
      >
        <template slot="progress">
          <v-progress-linear
            color="deep-purple"
            height="10"
            indeterminate
          ></v-progress-linear>
        </template>

        <v-img
          height="250"
          src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
        ></v-img>

        <v-card-title>{{item.name}}</v-card-title>

        <v-card-text>
          <v-row align="center" class="mx-0"> </v-row>

          <div class="my-4 subtitle-1">
           Location: {{item.location}}
          </div>

          <div></div>
          <v-row align="center" class="mx-0"> </v-row>

          <div class="my-4 subtitle-1">
            Schedule: {{item.schedule}}
          </div>

          <div></div>
        </v-card-text>

        <v-divider class="mx-4"></v-divider>
      </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import api from "../components/backend-api";

export default {
  name: "CafeteriaPageUser",
  data: () => ({
    loading: false,
    selection: 1,
    items: []
  }),
  created() {
    this.initialize();
  },
  methods: {
    reserve(name) {
      this.loading = true;
      console.log(name);
      setTimeout(() => (this.loading = false), 2000);
      const str1 = "/menuPageUser/";
      this.$router.push(str1.concat(name));

    },
    initialize() {
      api
        .getCafeteriasAdmin()
        .then(response => {
          console.log(response.data);
          this.items = response.data;
        })
        .catch(error => {
          this.errors.push(error);
        });
    }
  }
};
</script>

<style scoped>
#grid{
  width: 60%;
  margin: auto;
  align-self: center;
}
</style>
