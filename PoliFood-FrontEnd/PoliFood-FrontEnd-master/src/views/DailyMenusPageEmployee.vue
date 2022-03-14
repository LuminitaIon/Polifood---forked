<template>
  <div class="daily_menus_page">
    <h1>{{ cafeteria_name }}</h1>
    <br /><br /><br />
    <v-dialog v-model="dialog" max-width="500px">
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
          Adauga Meniu
        </v-btn>
      </template>

      <v-card>
        <v-card-title>
          <span class="headline">Adauga Meniu</span>
        </v-card-title>

        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12" sm="6" md="4">
                <v-text-field label="Ziua" v-model="new_menu.day" />
              </v-col>
              <v-col cols="12" sm="6" md="4">
                <v-text-field label="Data" v-model="new_menu.date" />
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="close"> Anuleaza </v-btn>
          <v-btn color="blue darken-1" text @click="save"> Salveaza </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <br /><br /><br />
    <div class="daily_menus_list" v-for="(menu, idx) in menus" :key="menu.date">
      <daily-menu-employee :day_of_the_week="menu.day" :date="menu.date" />
      <v-dialog v-model="dialogDelete" max-width="500px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            @click="delete_menu(idx)"
            color="error"
            block
            dark
            class="mb-2"
            v-bind="attrs"
            v-on="on"
          >
            Sterge Meniu
          </v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            Sigur stergeti meniul {{ menu.day }} {{ menu.date }}?
          </v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="closeDelete"
              >Anuleaza</v-btn
            >
            <v-btn color="blue darken-1" text @click="deleteItemConfirm"
              >Da</v-btn
            >
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-dialog>
      <br /><br />
    </div>
  </div>
</template>

<script>
import DailyMenuEmployee from "./DailyMenuEmployee.vue";
import api from "../components/backend-api.js";

export default {
  props: {
    cafeteria_name: String
  },
  components: {
    DailyMenuEmployee
  },
  data: () => ({
    dialog: false,
    dialogDelete: false,
    deleteIdx: -1,
    new_menu: {
      day: "",
      date: ""
    },
    menus: []
  }),
  created() {
    this.initialize();
  },
  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    }
  },
  methods: {
    initialize() {
      api.getMenu().then(response => {
        this.menus = response.data;
        console.log(response.data);
      });
    },
    reset_new_menu() {
      this.new_menu = { day: "", date: "" };
    },
    add_new_menu() {
      this.dialog = true;
    },
    close() {
      this.reset_new_menu();
      this.dialog = false;
    },
    save() {
      this.menus.push(this.new_menu);
      this.reset_new_menu();
      this.close();
    },
    delete_menu(idx) {
      this.deleteIdx = idx;
    },
    closeDelete() {
      this.deleteIdx = -1;
      this.dialogDelete = false;
    },
    deleteItemConfirm() {
      this.menus.splice(this.deleteIdx, 1);
      this.closeDelete();
    }
  }
};
</script>

<style scoped>
.daily_menus_page {
  top: 0;
  bottom: 0;
  height: 100%;
  padding-top: 30px;
}

.daily_menus_list {
  width: 60%;
  margin: auto;
}
</style>
