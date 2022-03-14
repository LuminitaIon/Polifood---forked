<template>
  <v-data-table
    :headers="headers"
    :items="items"
    class="elevation-1"
    :footer-props="{ 'items-per-page-text': 'Elemente pe pagina' }"
  >
    <template v-slot:top>
      <v-toolbar flat>
        <v-toolbar-title>{{ day_of_the_week }} {{ date }}</v-toolbar-title>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="500px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
              Adauga mancare
            </v-btn>
          </template>

          <v-card>
            <v-card-title>
              <span class="headline">Adauga Element</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6" md="4">
                    <model-select
                      :options="items"
                      v-model="new_item"
                      placeholder="Alege mancare"
                    ></model-select>
                  </v-col>
                  <br /><br /><br />
                  <br /><br /><br />
                  <br /><br /><br />
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close">
                Anuleaza
              </v-btn>
              <v-btn color="blue darken-1" text @click="save"> Salveaza </v-btn>
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
      <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
    </template>
  </v-data-table>
</template>

<script>
import { ModelSelect } from "vue-search-select";
import api from "../components/backend-api";

export default {
  props: {
    day_of_the_week: String,
    date: String
  },
  components: {
    ModelSelect
  },
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      { text: "Nume", value: "name" },
      { text: "Portie", value: "portion" },
      { text: "Pret (lei)", value: "unitPrice" },
      { text: "Actiuni", value: "actions", sortable: false }
    ],
    items: [],
    database_items: [],
    new_item: {
      name: "",
      unitValue: "",
      unitType: "",
      portion: "",
      unitPrice: "",
      value: ""
    },
    editedIndex: -1,
    defaultItem: {
      name: "",
      unitValue: "",
      unitType: "",
      portion: "",
      unitPrice: "",
      value: ""
    }
  }),

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
      api.getMenuElementsFromMenuDay(this.day_of_the_week, localStorage.getItem("cafeteria_name"))
          .then(response => {
            var new_text, new_portion;
            for (const el of response.data) {
              new_portion = el.unitValue+ " "+el.unitType;
              new_text = el.name + " " + el.portion + " " + el.unitPrice + " lei";
              this.items.push({...el, ...{portion: new_portion, text: new_text, value: new_text}});
            }
            console.log(response.data);
          })
          .catch(error => {
            this.error.push(error);
          })

    },

    deleteItem(item) {
      this.editedIndex = this.items.indexOf(item);
      this.dialogDelete = true;
    },

    deleteItemConfirm() {
      this.items.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.new_item = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.new_item = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      this.items.push(this.new_item);
      this.close();
    }
  }
};
</script>
