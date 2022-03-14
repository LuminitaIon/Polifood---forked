<template>
  <div id="table">
    <v-data-table
      :headers="headers"
      :items="desserts"
      sort-by="calories"
      class="elevation-1"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>{{ day }} {{ date }}</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
        </v-toolbar>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import api from "../components/backend-api";

export default {
  props: {
    day: String,
    date: String
  },
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      { text: "Data", value: "date" },
      { text: "Nume", value: "menuElement.name" },
      { text: "Pret (lei)", value: "menuElement.unitPrice" },
      { text: "Numar", value: "quantity" }
    ],
    desserts: []
  }),
  created() {
    this.initialize();
  },

  methods: {
    initialize() {
      // this.desserts = [
      //   {
      //     name: 'Frozen Yogurt',
      //     portion: "159 g",
      //     price: 3,
      //     number: 100,
      //   },
      //   {
      //     name: 'Ice cream sandwich',
      //     portion: "200 g",
      //     price: 5,
      //     number: 201,
      //   },
      //   {
      //     name: 'Eclair',
      //     portion: "100 g",
      //     price: 8,
      //     number: 50,
      //   },
      // ]
      api
        .getOrders()
        .then(response => {
          console.log(response.data);
          this.desserts = response.data;
        })
        .catch(error => {
          this.errors.push(error);
        });
    }
  }
};
</script>
<style>
#table {
  width: 60%;
  margin: auto;
}
</style>
