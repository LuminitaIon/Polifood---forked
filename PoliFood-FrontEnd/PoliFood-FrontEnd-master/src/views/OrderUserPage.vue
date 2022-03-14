<template>
<!--  <v-app style="align-content: center">-->
    <div id="table">
      <v-data-table
        :headers="headers"
        :items="items"
        class="elevation-1"
        :footer-props="{ 'items-per-page-text': 'Elemente pe pagina' }"
      >
        <template v-slot:top>
          <v-toolbar flat>
            <v-toolbar-title>Comenzi</v-toolbar-title>
            <v-divider class="mx-4" inset vertical></v-divider>
            <v-spacer></v-spacer>
            <v-dialog v-model="dialog" max-width="500px">
              <v-card>
                <v-card-title>
                  <span class="headline">{{ formTitle }}</span>
                </v-card-title>
                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="editedItem.name" label="Nume">
                        </v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field
                          v-model="editedItem.unitValue"
                          label="Cantitate"
                        >
                        </v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field
                          v-model="editedItem.unitType"
                          label="Unitate de masura"
                        >
                        </v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field
                          v-model="editedItem.unitPrice"
                          label="Pret"
                        >
                        </v-text-field>
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
                  >Sigur stergeti elementul?</v-card-title
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
<!--  </v-app>-->
</template>

<script>
import api from "../components/backend-api";
export default {
  name: "OrderUserPage",
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      { text: "Ora", value: "time" },
      { text: "Data", value: "date" },
      { text: "Pret", value: "menuElement.unitPrice" },
      { text: "Cantitatea", value: "quantity" },
      { text: "Actiuni", value: "actions", sortable: false }
    ],
    items: [],
    all_items: [],
    editedIndex: -1,
    editedItem: {
      name: "",
      unitValue: "",
      unitType: "",
      portion: "",
      unitPrice: ""
    },
    defaultItem: {
      name: "",
      unitValue: "",
      unitType: "",
      portion: "1",
      unitPrice: ""
    }
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "Adauga Element" : "Editeaza Element";
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
      // this.items = [
      // ]
      // api
      //     .getMenuElementsFromCafeteria(localStorage.getItem("cafeteria_name"))
      //     .then(response => {
      //       this.items = response.data;
      //       console.log(response.data);
      //     })
      //     .catch(error => {
      //       this.error.push(error);
      //     });
      api
          .getOrders()
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
      var new_portion =
        this.editedItem.unitValue + " " + this.editedItem.unitType;
      if (this.editedIndex > -1) {
        Object.assign(this.items[this.editedIndex], {
          ...this.editedItem,
          ...{ portion: new_portion }
        });
      } else {
        this.items.push({ ...this.editedItem, ...{ portion: new_portion } });
      }
      this.close();
    }
  }
};
</script>

<style>
#table {
  top: 0;
  bottom: 0;
  height: 100%;
  padding-top: 30px;
}

#table{
  width: 60%;
  margin: auto;
}
</style>
