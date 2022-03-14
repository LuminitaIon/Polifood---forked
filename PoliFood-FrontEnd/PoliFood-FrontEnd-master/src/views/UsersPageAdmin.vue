<template>
    <div class="users_page" style="background-color: #f2ebc4">
      <v-data-table
        :headers="headers"
        :items="items"
        class="elevation-1"
        :footer-props="{ 'items-per-page-text': 'Elemente pe pagina' }"
      >
        <template v-slot:top>
          <v-toolbar flat>
            <v-toolbar-title>Utilizatori</v-toolbar-title>
            <v-divider class="mx-4" inset vertical></v-divider>
            <v-spacer></v-spacer>
            <v-dialog v-model="dialog" max-width="500px">
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  color="primary"
                  dark
                  class="mb-2"
                  v-bind="attrs"
                  v-on="on"
                >
                  Adauga Utilizator
                </v-btn>
              </template>

              <v-card>
                <v-card-title>
                  <span class="headline">{{ formTitle }}</span>
                </v-card-title>

                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="editedItem.email" label="Email">
                        </v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field
                          v-model="editedItem.last_name"
                          label="Nume de familie"
                        >
                        </v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field
                          v-model="editedItem.first_name"
                          label="Prenume"
                        >
                        </v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <model-select
                          :options="roles"
                          v-model="editedItem.roleName"
                          placeholder="Alege rol"
                        ></model-select>
                      </v-col>
                    </v-row>
                  </v-container>
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="close">
                    Anuleaza
                  </v-btn>
                  <v-btn color="blue darken-1" text @click="save">
                    Salveaza
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>

            <v-dialog v-model="dialogDelete" max-width="500px">
              <v-card>
                <v-card-title class="headline"
                  >Sigur stergeti utilizatorul?</v-card-title
                >
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
          </v-toolbar>
        </template>

        <template v-slot:[`item.actions`]="{ item }">
          <v-icon small class="mr-2" @click="editItem(item)">
            mdi-pencil
          </v-icon>
          <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
        </template>
      </v-data-table>
    </div>
</template>

<script>
import { ModelSelect } from "vue-search-select";
import api from "../components/backend-api"
export default {
  props: {},
  components: {
    ModelSelect
  },
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      { text: "Email", value: "email" },
      { text: "Prenume", value: "firstName" },
      { text: "Nume", value: "lastName" },
      { text: "Rol", value: "role.name" },
      { text: "Actiuni", value: "actions", sortable: false }
    ],
    roles: [
      { text: "user", value: "USER" },
      { text: "admin", value: "ADMIN" },
      { text: "cafeteria", value: "CAFETERIA"}
    ],
    items: [],
    editedIndex: -1,
    editedItem: {
      email: "",
      first_name: "",
      last_name: "",
      name: "",
      roleName: ""
    },
    defaultItem: {
      email: "",
      first_name: "",
      last_name: "",
      name: "",
      roleName: ""
    }
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1
        ? "Adauga Utilizator"
        : "Editeaza Utilizator";
    }
  },

  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    }
  },

  created() {
    this.initialize();
  },

  methods: {
    initialize() {
      api.getUsers()
      .then(response => {
        console.log(response.data);
        this.items = response.data;
      })
          .catch(error => {
            this.errors.push(error);
          });
    },

    editItem(item) {
      this.editedIndex = this.items.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.new_role = item.roleName;
      this.dialog = true;
    },

    deleteItem(item) {
      this.editedIndex = this.items.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm() {
      this.items.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      var new_name =
        this.editedItem.first_name + " " + this.editedItem.last_name;
      if (this.editedIndex > -1) {
        Object.assign(this.items[this.editedIndex], {
          ...this.editedItem,
          ...{ name: new_name }
        });
      } else {
        this.items.push({ ...this.editedItem, ...{ name: new_name } });
      }
      this.close();
    }
  }
};
</script>

<style scoped>
.users_page {
  top: 0;
  bottom: 0;
  height: 100%;
  padding-top: 30px;
  padding-right: 20%;
  padding-left: 20%;
}
</style>
